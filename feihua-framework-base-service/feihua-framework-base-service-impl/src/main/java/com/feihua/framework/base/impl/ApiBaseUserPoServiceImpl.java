package com.feihua.framework.base.impl;

import com.feihua.exception.DataExistsException;
import com.feihua.framework.base.modules.datascope.api.ApiBaseDataScopeService;
import com.feihua.framework.constants.DictEnum;
import com.feihua.framework.base.modules.office.api.ApiBaseOfficePoService;
import com.feihua.framework.base.modules.office.dto.BaseOfficeDataScopeDefineDto;
import com.feihua.framework.base.modules.office.dto.BaseOfficeDto;
import com.feihua.framework.base.modules.office.dto.SearchOfficesConditionDto;
import com.feihua.framework.base.modules.office.po.BaseOfficePo;
import com.feihua.framework.base.modules.rel.api.ApiBaseUserRoleRelPoService;
import com.feihua.framework.base.modules.rel.dto.BaseUserRoleRelDto;
import com.feihua.framework.base.modules.role.api.ApiBaseRolePoService;
import com.feihua.framework.base.modules.role.dto.BaseRoleDataScopeDefineDto;
import com.feihua.framework.base.modules.role.dto.BaseRoleDto;
import com.feihua.framework.base.modules.role.dto.SearchRolesConditionDto;
import com.feihua.framework.base.modules.user.api.ApiBaseUserAuthPoService;
import com.feihua.framework.base.modules.user.api.ApiBaseUserPoService;
import com.feihua.framework.base.modules.user.dto.*;
import com.feihua.framework.base.modules.user.po.BaseUserAuthPo;
import com.feihua.framework.base.modules.user.po.BaseUserPo;
import com.feihua.utils.string.StringUtils;
import com.github.pagehelper.Page;
import feihua.jdbc.api.pojo.BasePo;
import feihua.jdbc.api.pojo.PageAndOrderbyParamDto;
import feihua.jdbc.api.pojo.PageResultDto;
import feihua.jdbc.api.service.impl.ApiBaseServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2018-04-19 14:30:11
 */
@Service
public class ApiBaseUserPoServiceImpl extends ApiBaseServiceImpl<BaseUserPo, BaseUserDto, String> implements ApiBaseUserPoService {
    
    @Autowired
    com.feihua.framework.base.mapper.BaseUserPoMapper BaseUserPoMapper;


    @Autowired
    private ApiBaseUserAuthPoService apiBaseUserAuthPoService;
    @Autowired
    private ApiBaseDataScopeService<BaseUserDataScopeDefineDto> apiBaseUserDataScopeService;
    @Autowired
    private ApiBaseDataScopeService<BaseOfficeDataScopeDefineDto> apiBaseOfficeDataScopeService;
    @Autowired
    private ApiBaseDataScopeService<BaseRoleDataScopeDefineDto> apiBaseRoleDataScopeService;
    @Autowired
    private ApiBaseOfficePoService apiBaseOfficePoService;
    @Autowired
    private ApiBaseRolePoService apiBaseRolePoService;
    @Autowired
    private ApiBaseUserRoleRelPoService apiBaseUserRoleRelPoService;
    
    public ApiBaseUserPoServiceImpl() {
        super(BaseUserDto.class);
    }

    @Transactional( propagation = Propagation.SUPPORTS, readOnly = true )
    @Override
    public PageResultDto<BaseUserDto> searchBaseUsersDsf(SearchBaseUsersConditionDto dto,PageAndOrderbyParamDto pageAndOrderbyParamDto) {

        BaseUserDataScopeDefineDto userDataScopeDefineDto = apiBaseUserDataScopeService.selectDataScopeDefineByUserId(dto.getCurrentUserId(),dto.getCurrentRoleId());
        // 如果没有定义，或定义是无权限
        if (userDataScopeDefineDto == null || StringUtils.isEmpty(userDataScopeDefineDto.getType()) || DictEnum.UserDataScope.no.name().equals(userDataScopeDefineDto.getType())) {
            return new PageResultDto();
        }
        SearchUsersConditionDsfDto searchUsersConditionDsfDto = new SearchUsersConditionDsfDto();

        searchUsersConditionDsfDto.setDataOfficeId(dto.getDataOfficeId());
        searchUsersConditionDsfDto.setLocked(dto.getLocked());
        searchUsersConditionDsfDto.setNickname(dto.getNickname());
        // 如果是所有用户
        if (DictEnum.UserDataScope.all.name().equals(userDataScopeDefineDto.getType())) {
            Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
            List<BaseUserPo> list = BaseUserPoMapper.searchBaseUsers(searchUsersConditionDsfDto);
            return new PageResultDto(this.wrapDtos(list), this.wrapPage(p));
        }
        // 如果是本人
        if (DictEnum.UserDataScope.personal.name().equals(userDataScopeDefineDto.getType())) {
            Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
            searchUsersConditionDsfDto.setSelfCondition(StringUtils.messageFormat("and id = ''{0}''",dto.getCurrentUserId()));
            List<BaseUserPo> list = BaseUserPoMapper.searchBaseUsers(searchUsersConditionDsfDto);
            return new PageResultDto(this.wrapDtos(list), this.wrapPage(p));
        }
        // 如果所在机构下的用户
        if (DictEnum.UserDataScope.useroffice.name().equals(userDataScopeDefineDto.getType())) {
            BaseOfficeDto officeDto = apiBaseOfficePoService.selectOfficeByUserId(dto.getCurrentUserId());
            // 如果所在机构不存在，直接返回空
            if(officeDto == null){
                return new PageResultDto();
            }
            Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
            searchUsersConditionDsfDto.setDataOfficeId(officeDto.getId());
            List<BaseUserPo> list = BaseUserPoMapper.searchBaseUsers(searchUsersConditionDsfDto);
            return new PageResultDto(this.wrapDtos(list), this.wrapPage(p));
        }
        // 如果所在机构及以下机构的用户
        if (DictEnum.UserDataScope.userofficedown.name().equals(userDataScopeDefineDto.getType())) {
            BaseOfficeDto officeDto = apiBaseOfficePoService.selectOfficeByUserId(dto.getCurrentUserId());
            // 如果所在机构不存在，直接返回空
            if(officeDto == null){
                return new PageResultDto();
            }
            // 查询机构
            List<BaseOfficePo> officePoList = new ArrayList<>();
            officePoList.add(apiBaseOfficePoService.selectByPrimaryKeySimple(officeDto.getId(),false));

            // 查询子机构
            List<BaseOfficePo> officePos = apiBaseOfficePoService.getChildrenAll(officeDto.getId());
            if(officePos != null && !officePos.isEmpty()){
                officePoList.addAll(officePos);
            }
            if(officePoList.isEmpty()){
                return new PageResultDto();
            }
            // 机构查询完，根据机构id查询用户

            StringBuffer sb = new StringBuffer("and (1!=1 ");
            for (BaseOfficePo officePo : officePoList) {
                sb.append(" or data_office_id = '").append(officePo.getId()).append("'");
            }
            sb.append(")");

            Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
            searchUsersConditionDsfDto.setSelfCondition(sb.toString());
            List<BaseUserPo> list = BaseUserPoMapper.searchBaseUsers(searchUsersConditionDsfDto);
            return new PageResultDto(this.wrapDtos(list), this.wrapPage(p));
        }
        // 角色所在机构的用户
        if (DictEnum.UserDataScope.roleoffice.name().equals(userDataScopeDefineDto.getType())) {
            BaseOfficeDto officeDto = apiBaseOfficePoService.selectOfficeByRoleId(dto.getCurrentRoleId());
            // 如果所在机构不存在，直接返回空
            if(officeDto == null){
                return new PageResultDto();
            }
            Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
            searchUsersConditionDsfDto.setDataOfficeId(officeDto.getId());
            List<BaseUserPo> list = BaseUserPoMapper.searchBaseUsers(searchUsersConditionDsfDto);
            return new PageResultDto(this.wrapDtos(list), this.wrapPage(p));
        }
        // 角色所在机构及以下机构用户
        if (DictEnum.UserDataScope.roleofficedown.name().equals(userDataScopeDefineDto.getType())) {
            BaseOfficeDto officeDto = apiBaseOfficePoService.selectOfficeByRoleId(dto.getCurrentRoleId());
            // 如果所在机构不存在，直接返回空
            if(officeDto == null){
                return new PageResultDto();
            }
            // 查询机构
            List<BaseOfficePo> officePoList = new ArrayList<>();
            officePoList.add(apiBaseOfficePoService.selectByPrimaryKeySimple(officeDto.getId(),false));

            // 查询子机构
            List<BaseOfficePo> officePos = apiBaseOfficePoService.getChildrenAll(officeDto.getId());
            if(officePos != null && !officePos.isEmpty()){
                officePoList.addAll(officePos);
            }
            if(officePoList.isEmpty()){
                return new PageResultDto();
            }
            // 机构查询完，根据机构id查询用户

            StringBuffer sb = new StringBuffer("and (1!=1 ");
            for (BaseOfficePo officePo : officePoList) {
                sb.append(" or data_office_id = '").append(officePo.getId()).append("'");
            }
            sb.append(")");

            Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
            searchUsersConditionDsfDto.setSelfCondition(sb.toString());
            List<BaseUserPo> list = BaseUserPoMapper.searchBaseUsers(searchUsersConditionDsfDto);
            return new PageResultDto(this.wrapDtos(list), this.wrapPage(p));
        }
        // 角色范围绑定的用户
        if (DictEnum.UserDataScope.rolebind.name().equals(userDataScopeDefineDto.getType())) {
            // 判断是否设置的所有角色

            boolean isAllData = apiBaseRoleDataScopeService.isAllData(apiBaseRoleDataScopeService.selectDataScopeDefineByUserId(dto.getCurrentUserId(),dto.getCurrentRoleId()));
            if(isAllData){
                Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
                List<BaseUserPo> list = BaseUserPoMapper.searchBaseUsers(searchUsersConditionDsfDto);
                return new PageResultDto(this.wrapDtos(list), this.wrapPage(p));
            }

            PageResultDto<BaseRoleDto> roles = apiBaseRolePoService.searchRolesDsf(new SearchRolesConditionDto(),null);
            if(roles == null || roles.getData() == null || roles.getData().isEmpty()){
                return new PageResultDto();
            }
            List<BaseUserRoleRelDto> userRoleRelDtoList = new ArrayList<>();
            // 根据角色结果查询用户id
            for (BaseRoleDto roleDto : roles.getData()) {
                List<BaseUserRoleRelDto> userRoleRelDtos = apiBaseUserRoleRelPoService.selectByRoleId(roleDto.getId());
                if(userRoleRelDtos != null && !userRoleRelDtos.isEmpty()){
                    userRoleRelDtoList.addAll(userRoleRelDtos);
                }
            }
            if(userRoleRelDtoList == null || userRoleRelDtoList.isEmpty()){
                return new PageResultDto();
            }
            // 根据用户id查询用户
            StringBuffer sb = new StringBuffer("and (1!=1 ");
            for (BaseUserRoleRelDto userRoleRelDto : userRoleRelDtoList) {
                sb.append(" or id = '").append(userRoleRelDto.getId()).append("'");
            }
            sb.append(")");
            Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
            searchUsersConditionDsfDto.setSelfCondition(sb.toString());
            List<BaseUserPo> list = BaseUserPoMapper.searchBaseUsers(searchUsersConditionDsfDto);
            return new PageResultDto(this.wrapDtos(list), this.wrapPage(p));
        }
        // 机构数据范围下的用户
        if (DictEnum.UserDataScope.officedata.name().equals(userDataScopeDefineDto.getType())) {
            // 判断机构是否设置的所有数据
            boolean isOfficeAllData = apiBaseOfficeDataScopeService.isAllData(apiBaseOfficeDataScopeService.selectDataScopeDefineByUserId(dto.getCurrentUserId(),dto.getCurrentRoleId()));
            if (isOfficeAllData) {
                Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
                List<BaseUserPo> list = BaseUserPoMapper.searchBaseUsers(searchUsersConditionDsfDto);
                return new PageResultDto(this.wrapDtos(list), this.wrapPage(p));
            }

            PageResultDto<BaseOfficeDto> offices = apiBaseOfficePoService.searchOfficesDsf(new SearchOfficesConditionDto(),null);
            if(offices == null || offices.getData() == null || offices.getData().isEmpty()){
                return new PageResultDto();
            }
            // 根据机构id查询用户
            StringBuffer sb = new StringBuffer("and (1!=1 ");
            for (BaseOfficeDto officeDto : offices.getData()) {
                sb.append(" or data_office_id = '").append(officeDto.getId()).append("'");
            }
            sb.append(")");

            Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
            searchUsersConditionDsfDto.setSelfCondition(sb.toString());
            List<BaseUserPo> list = BaseUserPoMapper.searchBaseUsers(searchUsersConditionDsfDto);
            return new PageResultDto(this.wrapDtos(list), this.wrapPage(p));
        }
        return new PageResultDto();
    }

    @Override
    public PageResultDto<BaseUserPo> searchBaseUsers(SearchBaseUsersConditionDto dto,PageAndOrderbyParamDto pageAndOrderbyParamDto) {
        Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
        List<BaseUserPo> list = BaseUserPoMapper.searchBaseUsers(dto);
        return new PageResultDto(this.wrapDtos(list), this.wrapPage(p));
    }

    @Transactional(rollbackFor = Exception.class,readOnly = false)
    @Override
    public BaseUserPo addUser(BaseUserAddParamDto addParamDto) {
        BaseUserAuthDto userAuthDto = apiBaseUserAuthPoService.selectByIdentifierAndType(addParamDto.getIdentifier(),addParamDto.getIdentityType());
        if (userAuthDto != null) {
            throw new DataExistsException("account already exist");
        }
        // 插入用户
        BaseUserPo userPo = new BaseUserPo();
        userPo.setNickname(addParamDto.getNickname());
        userPo.setSerialNo(addParamDto.getSerialNo());
        userPo.setGender(addParamDto.getGender());
        userPo.setLocked(addParamDto.getLocked());
        userPo.setDataOfficeId(addParamDto.getDataOfficeId());
        userPo.setPhoto(addParamDto.getPhoto());
        this.preInsert(userPo,addParamDto.getCurrentUserId());
        userPo = this.insertSimple(userPo);

        //插入帐号信息
        BaseUserAuthPo baseUserAuthPo = new BaseUserAuthPo();
        baseUserAuthPo.setUserId(userPo.getId());
        baseUserAuthPo.setIdentifier(addParamDto.getIdentifier());
        baseUserAuthPo.setIdentityType(addParamDto.getIdentityType());
        baseUserAuthPo.setVerified(BasePo.YesNo.Y.name());
        //密码信息
        baseUserAuthPo.setCredential(addParamDto.getPassword());
        apiBaseUserAuthPoService.preInsert(baseUserAuthPo,addParamDto.getCurrentUserId());
        apiBaseUserAuthPoService.insertSelectiveSimple(baseUserAuthPo);
        return userPo;
    }

    @Override
    public BaseUserDto wrapDto(BaseUserPo po) {
        if (po == null) {
            return null;
        }
        BaseUserDto baseUserDto = new BaseUserDto();
        baseUserDto.setSerialNo(po.getSerialNo());
        baseUserDto.setGender(po.getGender());
        baseUserDto.setLocked(po.getLocked());
        baseUserDto.setPhoto(po.getPhoto());
        baseUserDto.setNickname(po.getNickname());
        baseUserDto.setDataUserId(po.getDataUserId());
        baseUserDto.setId(po.getId());
        baseUserDto.setDataType(po.getDataType());
        baseUserDto.setUpdateAt(po.getUpdateAt());
        baseUserDto.setDataAreaId(po.getDataAreaId());
        baseUserDto.setDataOfficeId(po.getDataOfficeId());
        return baseUserDto;
    }
}