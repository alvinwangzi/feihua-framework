package com.feihua.framework.statistic.impl;

import com.feihua.framework.statistic.api.ApiStatisticUserAreaCountHistoryPoService;
import com.feihua.framework.statistic.dto.StatisticUserAreaCountHistoryDto;
import com.feihua.framework.statistic.po.StatisticUserAreaCountHistoryPo;
import feihua.jdbc.api.service.impl.ApiBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2019-04-25 11:14:07
 */
@Service
public class ApiStatisticUserAreaCountHistoryPoServiceImpl extends ApiBaseServiceImpl<StatisticUserAreaCountHistoryPo, StatisticUserAreaCountHistoryDto, String> implements ApiStatisticUserAreaCountHistoryPoService {
    @Autowired
    com.feihua.framework.statistic.mapper.StatisticUserAreaCountHistoryPoMapper StatisticUserAreaCountHistoryPoMapper;

    public ApiStatisticUserAreaCountHistoryPoServiceImpl() {
        super(StatisticUserAreaCountHistoryDto.class);
    }

    @Override
    public StatisticUserAreaCountHistoryDto wrapDto(StatisticUserAreaCountHistoryPo po) {
        if (po == null) { return null; }
        StatisticUserAreaCountHistoryDto dto = new StatisticUserAreaCountHistoryDto();
        dto.setId(po.getId());
        dto.setAreaId(po.getAreaId());
        dto.setAreaName(po.getAreaName());
        dto.setBatchNo(po.getBatchNo());
        dto.setAllNum(po.getAllNum());
        dto.setMaleNum(po.getMaleNum());
        dto.setFemaleNum(po.getFemaleNum());
        dto.setGenderOtherNum(po.getGenderOtherNum());
        dto.setOnlineAllNum(po.getOnlineAllNum());
        dto.setOnlineMaleNum(po.getOnlineMaleNum());
        dto.setOnlineFemaleNum(po.getOnlineFemaleNum());
        dto.setOnlineGenderOtherNum(po.getOnlineGenderOtherNum());
        dto.setLongitude(po.getLongitude());
        dto.setLatitude(po.getLatitude());
        dto.setDataUserId(po.getDataUserId());
        dto.setDataOfficeId(po.getDataOfficeId());
        dto.setDataType(po.getDataType());
        dto.setDataAreaId(po.getDataAreaId());
        dto.setUpdateAt(po.getUpdateAt());
        return dto;
    }
}