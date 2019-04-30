package com.feihua.framework.message.po;

import feihua.jdbc.api.pojo.BasePo;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2019-04-30 09:53:11
 * Database Table Remarks:
 *   消息发送表,记录消息的发送参数
 *
 * This class corresponds to the database table base_message_send
 * @mbg.generated do_not_delete_during_merge 2019-04-30 09:53:11
*/
public class BaseMessageSendPo extends feihua.jdbc.api.pojo.BasePo<String> {
    /**
     * Database Column Remarks:
     *   消息id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_send.MESSAGE_ID
     *
     * @mbg.generated 2019-04-30 09:53:11
     */
    private String messageId;

    /**
     * Database Column Remarks:
     *   发送人id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_send.SEND_USER_ID
     *
     * @mbg.generated 2019-04-30 09:53:11
     */
    private String sendUserId;

    /**
     * Database Column Remarks:
     *   发送人昵称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_send.SEND_USER_NICKNAME
     *
     * @mbg.generated 2019-04-30 09:53:11
     */
    private String sendUserNickname;

    /**
     * Database Column Remarks:
     *   客户端id们，多个以逗号分隔
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_send.CLIENT_IDS
     *
     * @mbg.generated 2019-04-30 09:53:11
     */
    private String clientIds;

    /**
     * Database Column Remarks:
     *   客户端名字们，多个以逗号分隔
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_send.CLIENT_NAMES
     *
     * @mbg.generated 2019-04-30 09:53:11
     */
    private String clientNames;

    /**
     * Database Column Remarks:
     *   发送目标类型
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_send.TARGET_TYPE
     *
     * @mbg.generated 2019-04-30 09:53:11
     */
    private String targetType;

    /**
     * Database Column Remarks:
     *   模板参数
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_send.TEMPLATE_PARAMS
     *
     * @mbg.generated 2019-04-30 09:53:11
     */
    private String templateParams;

    /**
     * Database Column Remarks:
     *   发送目标值
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_send.TARGET_VALUES
     *
     * @mbg.generated 2019-04-30 09:53:11
     */
    private String targetValues;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getSendUserNickname() {
        return sendUserNickname;
    }

    public void setSendUserNickname(String sendUserNickname) {
        this.sendUserNickname = sendUserNickname;
    }

    public String getClientIds() {
        return clientIds;
    }

    public void setClientIds(String clientIds) {
        this.clientIds = clientIds;
    }

    public String getClientNames() {
        return clientNames;
    }

    public void setClientNames(String clientNames) {
        this.clientNames = clientNames;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getTemplateParams() {
        return templateParams;
    }

    public void setTemplateParams(String templateParams) {
        this.templateParams = templateParams;
    }

    public String getTargetValues() {
        return targetValues;
    }

    public void setTargetValues(String targetValues) {
        this.targetValues = targetValues;
    }

    public com.feihua.framework.message.api.ApiBaseMessageSendPoService service() {
        return com.feihua.utils.spring.SpringContextHolder.getBean(com.feihua.framework.message.api.ApiBaseMessageSendPoService.class);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageId=").append(messageId);
        sb.append(", sendUserId=").append(sendUserId);
        sb.append(", sendUserNickname=").append(sendUserNickname);
        sb.append(", clientIds=").append(clientIds);
        sb.append(", clientNames=").append(clientNames);
        sb.append(", targetType=").append(targetType);
        sb.append(", templateParams=").append(templateParams);
        sb.append(", targetValues=").append(targetValues);
        sb.append("]");
        return sb.toString();
    }
}