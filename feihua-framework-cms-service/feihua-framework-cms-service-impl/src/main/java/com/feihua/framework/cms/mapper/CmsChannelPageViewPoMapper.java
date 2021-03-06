package com.feihua.framework.cms.mapper;

import com.feihua.framework.cms.po.CmsChannelPageViewPo;
import feihua.jdbc.api.dao.CrudDao;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2018-11-09 16:53:22
 */
public interface CmsChannelPageViewPoMapper extends feihua.jdbc.api.dao.CrudDao<CmsChannelPageViewPo, String> {

    public int computeIv(@Param("channelId") String channelId,@Param("dateStart") Date dateStart,@Param("dateEnd") Date dateEnd);
    public int existHost(@Param("host") String host,@Param("dateStart") Date dateStart,@Param("dateEnd") Date dateEnd);

    public int computeUv(@Param("channelId") String channelId,@Param("dateStart") Date dateStart,@Param("dateEnd") Date dateEnd);
    public int existCookie(@Param("cookie") String cookie,@Param("dateStart") Date dateStart,@Param("dateEnd") Date dateEnd);
}