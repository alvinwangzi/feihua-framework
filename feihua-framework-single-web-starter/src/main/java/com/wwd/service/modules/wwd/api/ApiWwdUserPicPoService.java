package com.wwd.service.modules.wwd.api;

import com.wwd.service.modules.wwd.dto.WwdUserPicDto;
import com.wwd.service.modules.wwd.po.WwdUserPicPo;

import java.util.List;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2018-04-25 11:24:56
 */
public interface ApiWwdUserPicPoService extends feihua.jdbc.api.service.ApiBaseService<WwdUserPicPo, WwdUserPicDto, String> {

    public List<WwdUserPicDto> selectByWwdUserId(String wwdUserId);
}