package com.feihua.wechat.mapper;

import com.feihua.wechat.common.dto.SearchWeixinAccountsConditionDto;
import com.feihua.wechat.common.po.WeixinAccountPo;

/**
 * This class was generated by MyBatis Generator.
 * @author revolver 2018-10-19 16:31:29
 */
public interface WeixinAccountPoMapper extends feihua.jdbc.api.dao.CrudDao<WeixinAccountPo, String> {
    java.util.List<WeixinAccountPo> searchWeixinAccounts(SearchWeixinAccountsConditionDto dto);
}