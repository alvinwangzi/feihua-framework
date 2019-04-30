package com.feihua.framework.statistic.impl;

import com.feihua.framework.statistic.api.ApiStatisticUserCountHistoryPoService;
import com.feihua.framework.statistic.dto.StatisticUserCountHistoryDto;
import com.feihua.framework.statistic.po.StatisticUserCountHistoryPo;
import feihua.jdbc.api.service.impl.ApiBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2019-04-23 09:20:38
 */
@Service
public class ApiStatisticUserCountHistoryPoServiceImpl extends ApiBaseServiceImpl<StatisticUserCountHistoryPo, StatisticUserCountHistoryDto, String> implements ApiStatisticUserCountHistoryPoService {
    @Autowired
    com.feihua.framework.statistic.mapper.StatisticUserCountHistoryPoMapper StatisticUserCountHistoryPoMapper;

    public ApiStatisticUserCountHistoryPoServiceImpl() {
        super(StatisticUserCountHistoryDto.class);
    }

    @Override
    public StatisticUserCountHistoryDto wrapDto(StatisticUserCountHistoryPo po) {
        if (po == null) { return null; }
        StatisticUserCountHistoryDto dto = new StatisticUserCountHistoryDto();
        dto.setId(po.getId());
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