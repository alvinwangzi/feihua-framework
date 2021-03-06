package com.feihua.framework.base.modules.loginclient.po;

import feihua.jdbc.api.pojo.BasePo;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2019-04-08 14:30:09
 * Database Table Remarks:
 *   系统客户端与渠道绑定表
 *
 * This class corresponds to the database table base_login_client_channel_bind
 * @mbg.generated do_not_delete_during_merge 2019-04-08 14:30:09
*/
public class BaseLoginClientChannelBindPo extends feihua.jdbc.api.pojo.BasePo<String> {
    /**
     * Database Column Remarks:
     *   客户端id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_login_client_channel_bind.client_id
     *
     * @mbg.generated 2019-04-08 14:30:09
     */
    private String clientId;

    /**
     * Database Column Remarks:
     *   渠道类型，如：微信公众平台，微信小程序，支付宝小程序等
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_login_client_channel_bind.channel_type
     *
     * @mbg.generated 2019-04-08 14:30:09
     */
    private String channelType;

    /**
     * Database Column Remarks:
     *   渠道的id，如果类型为微信公众平台，则该字段为微信帐户的id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_login_client_channel_bind.channel_id
     *
     * @mbg.generated 2019-04-08 14:30:09
     */
    private String channelId;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public com.feihua.framework.base.modules.loginclient.api.ApiBaseLoginClientChannelBindPoService service() {
        return com.feihua.utils.spring.SpringContextHolder.getBean(com.feihua.framework.base.modules.loginclient.api.ApiBaseLoginClientChannelBindPoService.class);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", clientId=").append(clientId);
        sb.append(", channelType=").append(channelType);
        sb.append(", channelId=").append(channelId);
        sb.append("]");
        return sb.toString();
    }
}