package com.feihua.framework.cms.mapper;

import com.feihua.framework.cms.po.CmsChannelPo;
import feihua.jdbc.api.dao.CrudDao;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2018-11-09 16:45:29
 */
public interface CmsChannelPoMapper extends feihua.jdbc.api.dao.CrudDao<CmsChannelPo, String> {
    java.util.List<CmsChannelPo> searchCmsChannels(com.feihua.framework.cms.dto.SearchCmsChannelsConditionDto dto);
}