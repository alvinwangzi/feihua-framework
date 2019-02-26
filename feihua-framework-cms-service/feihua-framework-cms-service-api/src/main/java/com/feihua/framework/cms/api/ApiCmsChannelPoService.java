package com.feihua.framework.cms.api;

import com.feihua.framework.cms.dto.CmsChannelDto;
import com.feihua.framework.cms.po.CmsChannelPo;
import feihua.jdbc.api.pojo.PageResultDto;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2018-11-09 16:45:29
 */
public interface ApiCmsChannelPoService extends feihua.jdbc.api.service.ApiBaseTreeService<CmsChannelPo, CmsChannelDto, String> {
    PageResultDto<CmsChannelDto> searchCmsChannelsDsf(com.feihua.framework.cms.dto.SearchCmsChannelsConditionDto dto, feihua.jdbc.api.pojo.PageAndOrderbyParamDto pageAndOrderbyParamDto);

    CmsChannelPo selectByPathAndSiteId(String channelPath,String siteId);
}