package com.feihua.framework.base.impl;

import com.feihua.framework.base.modules.area.api.ApiBaseAreaPoService;
import com.feihua.framework.base.modules.area.dto.BaseAreaDto;
import com.feihua.framework.base.modules.area.dto.SearchAreasConditionDto;
import com.feihua.framework.base.mapper.BaseAreaPoMapper;
import com.feihua.framework.base.modules.area.po.BaseAreaPo;
import com.feihua.framework.base.modules.user.api.ApiBaseUserPoService;
import com.feihua.framework.base.modules.user.po.BaseUserPo;
import com.github.pagehelper.Page;
import feihua.jdbc.api.pojo.PageAndOrderbyParamDto;
import feihua.jdbc.api.pojo.PageResultDto;
import feihua.jdbc.api.service.impl.ApiBaseTreeServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2018-01-09 16:34:31
 */
@Service
public class ApiBaseAreaPoServiceImpl extends ApiBaseTreeServiceImpl<BaseAreaPo, BaseAreaDto, String> implements ApiBaseAreaPoService {

    public ApiBaseAreaPoServiceImpl() {
        super(BaseAreaDto.class);
    }

    @Autowired
    private BaseAreaPoMapper baseAreaPoMapper;
    @Autowired
    private ApiBaseUserPoService apiBaseUserPoService;

    @Transactional( propagation = Propagation.SUPPORTS, readOnly = true )
    @Override
    public PageResultDto<BaseAreaDto> searchAreasDsf(SearchAreasConditionDto conditionDto, PageAndOrderbyParamDto pageAndOrderbyParamDto) {
        Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
        List<BaseAreaDto> list = this.wrapDtos(baseAreaPoMapper.searchAreas(conditionDto));
        return new PageResultDto(list, this.wrapPage(p));
    }

    @Override
    public BaseAreaPo selectAreaByUserId(String userId) {
        BaseUserPo userPo = apiBaseUserPoService.selectByPrimaryKeySimple(userId,false);
        // 如果用户存在
        if(userPo != null && StringUtils.isNotEmpty(userPo.getDataOfficeId())){
            return this.selectByPrimaryKeySimple(userPo.getDataOfficeId(),false);
        }
        return null;
    }

    @Override
    public BaseAreaDto wrapDto(BaseAreaPo po) {
        if (po == null) {
            return null;
        }
        BaseAreaDto baseAreaDto = new BaseAreaDto();
        baseAreaDto.setName(po.getName());
        baseAreaDto.setDataOfficeId(po.getDataOfficeId());
        baseAreaDto.setParentId(po.getParentId());
        baseAreaDto.setId(po.getId());
        baseAreaDto.setType(po.getType());
        baseAreaDto.setSequence(po.getSequence());
        baseAreaDto.setLevel(po.getLevel());
        baseAreaDto.setUpdateAt(po.getUpdateAt());
        baseAreaDto.setDataAreaId(po.getDataAreaId());
        baseAreaDto.setDataType(po.getDataType());
        baseAreaDto.setDataUserId(po.getDataUserId());
        baseAreaDto.setLongitude(po.getLongitude());
        baseAreaDto.setLatitude(po.getLatitude());
        return baseAreaDto;
    }
}