package com.feihua.framework.cms.impl;

import com.feihua.framework.cms.api.ApiCmsSurveyPoService;
import com.feihua.framework.cms.dto.CmsSurveyDto;
import com.feihua.framework.cms.po.CmsSurveyPo;
import com.github.pagehelper.Page;
import feihua.jdbc.api.pojo.PageResultDto;
import feihua.jdbc.api.service.impl.ApiBaseServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class was generated by MyBatis Generator.
 * @author revolver 2019-01-17 13:56:58
 */
@Service
public class ApiCmsSurveyPoServiceImpl extends ApiBaseServiceImpl<CmsSurveyPo, CmsSurveyDto, String> implements ApiCmsSurveyPoService {
    @Autowired
    com.feihua.framework.cms.mapper.CmsSurveyPoMapper CmsSurveyPoMapper;

    public ApiCmsSurveyPoServiceImpl() {
        super(CmsSurveyDto.class);
    }

    @Override
    public PageResultDto<CmsSurveyDto> searchCmsSurveysDsf(com.feihua.framework.cms.dto.SearchCmsSurveysConditionDto dto, feihua.jdbc.api.pojo.PageAndOrderbyParamDto pageAndOrderbyParamDto) {
        Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
        List<com.feihua.framework.cms.dto.CmsSurveyDto> list = this.wrapDtos(CmsSurveyPoMapper.searchCmsSurveys(dto));
        return new PageResultDto(list, this.wrapPage(p));
    }

    @Override
    public CmsSurveyDto wrapDto(CmsSurveyPo po) {
        if (po == null) { return null; }
        CmsSurveyDto dto = new CmsSurveyDto();
        dto.setId(po.getId());
        dto.setTitle(po.getTitle());
        dto.setDescription(po.getDescription());
        dto.setType(po.getType());
        dto.setStartTime(po.getStartTime());
        dto.setEndTime(po.getEndTime());
        dto.setStatus(po.getStatus());
        dto.setSequence(po.getSequence());
        dto.setRegister(po.getRegister());
        dto.setRepeatLimit(po.getRepeatLimit());
        dto.setUrl(po.getUrl());
        dto.setCount(po.getCount());
        dto.setDataUserId(po.getDataUserId());
        dto.setDataOfficeId(po.getDataOfficeId());
        dto.setDataType(po.getDataType());
        dto.setDataAreaId(po.getDataAreaId());
        dto.setUpdateAt(po.getUpdateAt());
        return dto;
    }
}