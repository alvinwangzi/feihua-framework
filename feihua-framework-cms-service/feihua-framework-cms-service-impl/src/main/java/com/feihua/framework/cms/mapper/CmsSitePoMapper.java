package com.feihua.framework.cms.mapper;

import com.feihua.framework.cms.po.CmsSitePo;
import feihua.jdbc.api.dao.CrudDao;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2018-11-09 16:15:06
 */
public interface CmsSitePoMapper extends feihua.jdbc.api.dao.CrudDao<CmsSitePo, String> {
    java.util.List<CmsSitePo> searchCmsSites(com.feihua.framework.cms.dto.SearchCmsSitesConditionDto dto);
}