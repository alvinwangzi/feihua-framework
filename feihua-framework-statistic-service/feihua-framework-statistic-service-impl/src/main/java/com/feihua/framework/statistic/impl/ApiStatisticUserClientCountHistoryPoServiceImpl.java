package com.feihua.framework.statistic.impl;

import com.feihua.framework.statistic.api.ApiStatisticUserClientCountHistoryPoService;
import com.feihua.framework.statistic.dto.StatisticUserClientCountHistoryDto;
import com.feihua.framework.statistic.po.StatisticUserClientCountHistoryPo;
import feihua.jdbc.api.service.impl.ApiBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2019-04-23 09:21:26
 */
@Service
public class ApiStatisticUserClientCountHistoryPoServiceImpl extends ApiBaseServiceImpl<StatisticUserClientCountHistoryPo, StatisticUserClientCountHistoryDto, String> implements ApiStatisticUserClientCountHistoryPoService {
    @Autowired
    com.feihua.framework.statistic.mapper.StatisticUserClientCountHistoryPoMapper StatisticUserClientCountHistoryPoMapper;

    public ApiStatisticUserClientCountHistoryPoServiceImpl() {
        super(StatisticUserClientCountHistoryDto.class);
    }

    @Override
    public StatisticUserClientCountHistoryDto wrapDto(StatisticUserClientCountHistoryPo po) {
        if (po == null) { return null; }
        StatisticUserClientCountHistoryDto dto = new StatisticUserClientCountHistoryDto();
        dto.setId(po.getId());
        dto.setClientId(po.getClientId());
        dto.setClientCode(po.getClientCode());
        dto.setClientName(po.getClientName());
        dto.setBatchNo(po.getBatchNo());
        dto.setAllNum(po.getAllNum());
        dto.setMaleNum(po.getMaleNum());
        dto.setFemaleNum(po.getFemaleNum());
        dto.setGenderOtherNum(po.getGenderOtherNum());
        dto.setOnlineAllNum(po.getOnlineAllNum());
        dto.setOnlineMaleNum(po.getOnlineMaleNum());
        dto.setOnlineFemaleNum(po.getOnlineFemaleNum());
        dto.setOnlineGenderOtherNum(po.getOnlineGenderOtherNum());
        dto.setDataUserId(po.getDataUserId());
        dto.setDataOfficeId(po.getDataOfficeId());
        dto.setDataType(po.getDataType());
        dto.setDataAreaId(po.getDataAreaId());
        dto.setUpdateAt(po.getUpdateAt());
        return dto;
    }
}