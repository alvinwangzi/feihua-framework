package com.feihua.framework.base.impl;

import com.feihua.framework.base.modules.loginclient.api.ApiBaseLoginClientChannelBindPoService;
import com.feihua.framework.base.modules.loginclient.dto.BaseLoginClientChannelBindDto;
import com.feihua.framework.base.modules.loginclient.po.BaseLoginClientChannelBindPo;
import feihua.jdbc.api.service.impl.ApiBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2019-04-04 17:36:52
 */
@Service
public class ApiBaseLoginClientChannelBindPoServiceImpl extends ApiBaseServiceImpl<BaseLoginClientChannelBindPo, BaseLoginClientChannelBindDto, String> implements ApiBaseLoginClientChannelBindPoService {
    @Autowired
    com.feihua.framework.base.mapper.BaseLoginClientChannelBindPoMapper BaseLoginClientChannelBindPoMapper;

    public ApiBaseLoginClientChannelBindPoServiceImpl() {
        super(BaseLoginClientChannelBindDto.class);
    }

    @Override
    public BaseLoginClientChannelBindDto wrapDto(BaseLoginClientChannelBindPo po) {
        if (po == null) { return null; }
        BaseLoginClientChannelBindDto dto = new BaseLoginClientChannelBindDto();
        dto.setId(po.getId());
        dto.setClientId(po.getClientId());
        dto.setChannelType(po.getChannelType());
        dto.setChannelId(po.getChannelId());
        dto.setDataUserId(po.getDataUserId());
        dto.setDataOfficeId(po.getDataOfficeId());
        dto.setDataType(po.getDataType());
        dto.setDataAreaId(po.getDataAreaId());
        dto.setUpdateAt(po.getUpdateAt());
        return dto;
    }
}