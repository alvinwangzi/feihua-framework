package com.feihua.framework.cms.impl;

import com.feihua.framework.cms.api.ApiCmsSurveyAnswerPoService;
import com.feihua.framework.cms.dto.CmsSurveyAnswerDto;
import com.feihua.framework.cms.po.CmsSurveyAnswerPo;
import com.github.pagehelper.Page;
import feihua.jdbc.api.pojo.PageResultDto;
import feihua.jdbc.api.service.impl.ApiBaseServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class was generated by MyBatis Generator.
 * @author revolver 2019-01-17 14:05:00
 */
@Service
public class ApiCmsSurveyAnswerPoServiceImpl extends ApiBaseServiceImpl<CmsSurveyAnswerPo, CmsSurveyAnswerDto, String> implements ApiCmsSurveyAnswerPoService {
    @Autowired
    com.feihua.framework.cms.mapper.CmsSurveyAnswerPoMapper CmsSurveyAnswerPoMapper;

    public ApiCmsSurveyAnswerPoServiceImpl() {
        super(CmsSurveyAnswerDto.class);
    }

    @Override
    public PageResultDto<CmsSurveyAnswerDto> searchCmsSurveyAnswersDsf(com.feihua.framework.cms.dto.SearchCmsSurveyAnswersConditionDto dto, feihua.jdbc.api.pojo.PageAndOrderbyParamDto pageAndOrderbyParamDto) {
        Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
        List<com.feihua.framework.cms.dto.CmsSurveyAnswerDto> list = this.wrapDtos(CmsSurveyAnswerPoMapper.searchCmsSurveyAnswers(dto));
        return new PageResultDto(list, this.wrapPage(p));
    }

    @Override
    public CmsSurveyAnswerDto wrapDto(CmsSurveyAnswerPo po) {
        if (po == null) { return null; }
        CmsSurveyAnswerDto dto = new CmsSurveyAnswerDto();
        dto.setId(po.getId());
        dto.setSurveyId(po.getSurveyId());
        dto.setQuestionId(po.getQuestionId());
        dto.setAnswers(po.getAnswers());
        dto.setDataUserId(po.getDataUserId());
        dto.setDataOfficeId(po.getDataOfficeId());
        dto.setDataType(po.getDataType());
        dto.setDataAreaId(po.getDataAreaId());
        dto.setUpdateAt(po.getUpdateAt());
        return dto;
    }
}