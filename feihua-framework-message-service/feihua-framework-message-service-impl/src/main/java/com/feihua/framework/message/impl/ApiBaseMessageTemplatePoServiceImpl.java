package com.feihua.framework.message.impl;

import com.feihua.framework.message.api.ApiBaseMessageTemplatePoService;
import com.feihua.framework.message.dto.BaseMessageTemplateDto;
import com.feihua.framework.message.mapper.BaseMessageTemplatePoMapper;
import com.feihua.framework.message.po.BaseMessageTemplatePo;
import com.github.pagehelper.Page;
import feihua.jdbc.api.pojo.BasePo;
import feihua.jdbc.api.pojo.PageResultDto;
import feihua.jdbc.api.service.impl.ApiBaseServiceImpl;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2018-10-29 20:18:23
 */
@Service
public class ApiBaseMessageTemplatePoServiceImpl extends ApiBaseServiceImpl<BaseMessageTemplatePo, BaseMessageTemplateDto, String> implements ApiBaseMessageTemplatePoService {
    @Autowired
    private BaseMessageTemplatePoMapper baseMessageTemplatePoMapper;

    public ApiBaseMessageTemplatePoServiceImpl() {
        super(BaseMessageTemplateDto.class);
    }

    @Override
    public PageResultDto<BaseMessageTemplateDto> searchBaseMessageTemplatesDsf(com.feihua.framework.message.dto.SearchBaseMessageTemplatesConditionDto dto, feihua.jdbc.api.pojo.PageAndOrderbyParamDto pageAndOrderbyParamDto) {
        Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
        List<com.feihua.framework.message.dto.BaseMessageTemplateDto> list = this.wrapDtos(baseMessageTemplatePoMapper.searchBaseMessageTemplates(dto));
        return new PageResultDto(list, this.wrapPage(p));
    }

    @Override
    public BaseMessageTemplatePo selectByTemplateCode(String code) {
        if(StringUtils.isEmpty(code)) return null;

        BaseMessageTemplatePo condition = new BaseMessageTemplatePo();
        condition.setCode(code);
        condition.setDelFlag(BasePo.YesNo.N.name());

        return selectOneSimple(condition);
    }

    @Override
    public BaseMessageTemplateDto wrapDto(BaseMessageTemplatePo po) {
        if (po == null) {
            return null;
        }
        BaseMessageTemplateDto baseMessageTemplateDto = new BaseMessageTemplateDto();
        baseMessageTemplateDto.setName(po.getName());
        baseMessageTemplateDto.setCode(po.getCode());
        baseMessageTemplateDto.setDataOfficeId(po.getDataOfficeId());
        baseMessageTemplateDto.setDataUserId(po.getDataUserId());
        baseMessageTemplateDto.setDataAreaId(po.getDataAreaId());
        baseMessageTemplateDto.setId(po.getId());
        baseMessageTemplateDto.setUpdateAt(po.getUpdateAt());
        baseMessageTemplateDto.setContent(po.getContent());
        baseMessageTemplateDto.setDataType(po.getDataType());
        baseMessageTemplateDto.setProfile(po.getProfile());
        baseMessageTemplateDto.setTitle(po.getTitle());
        baseMessageTemplateDto.setMsgLevel(po.getMsgLevel());
        baseMessageTemplateDto.setMsgType(po.getMsgType());
        return baseMessageTemplateDto;
    }
}