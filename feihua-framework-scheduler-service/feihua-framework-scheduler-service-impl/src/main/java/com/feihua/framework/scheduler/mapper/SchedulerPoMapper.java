package com.feihua.framework.scheduler.mapper;

import com.feihua.framework.scheduler.po.SchedulerPo;
import feihua.jdbc.api.dao.CrudDao;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2019-04-16 09:51:01
 */
public interface SchedulerPoMapper extends feihua.jdbc.api.dao.CrudDao<SchedulerPo, String> {
    java.util.List<SchedulerPo> searchSchedulers(com.feihua.framework.scheduler.dto.SearchSchedulersConditionDto dto);
}