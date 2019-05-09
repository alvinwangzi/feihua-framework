package com.feihua.framework.message.po;

import feihua.jdbc.api.pojo.BasePo;
import java.util.Date;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2019-04-26 15:40:43
 * Database Table Remarks:
 *   用户消息关系表
 *
 * This class corresponds to the database table base_message_user
 * @mbg.generated do_not_delete_during_merge 2019-04-26 15:40:43
*/
public class BaseMessageUserPo extends feihua.jdbc.api.pojo.BasePo<String> {
    /**
     * Database Column Remarks:
     *   消息表主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_user.MESSAGE_ID
     *
     * @mbg.generated 2019-04-26 15:40:43
     */
    private String messageId;

    /**
     * Database Column Remarks:
     *   用户id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_user.USER_ID
     *
     * @mbg.generated 2019-04-26 15:40:43
     */
    private String userId;

    /**
     * Database Column Remarks:
     *   是否已读，Y=已读，N=未读
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_user.IS_READ
     *
     * @mbg.generated 2019-04-26 15:40:43
     */
    private String isRead;

    /**
     * Database Column Remarks:
     *   是否可以查看该消息，Y=可以，N=不可以，如果为N则该用户将会看不到该消息
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_user.IS_CAN_READ
     *
     * @mbg.generated 2019-04-26 15:40:43
     */
    private String isCanRead;

    /**
     * Database Column Remarks:
     *   读取的客户端id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_user.READ_CLIENT_ID
     *
     * @mbg.generated 2019-04-26 15:40:43
     */
    private String readClientId;

    /**
     * Database Column Remarks:
     *   读取时间，标记为已读的时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_message_user.READ_TIME
     *
     * @mbg.generated 2019-04-26 15:40:43
     */
    private Date readTime;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getIsCanRead() {
        return isCanRead;
    }

    public void setIsCanRead(String isCanRead) {
        this.isCanRead = isCanRead;
    }

    public String getReadClientId() {
        return readClientId;
    }

    public void setReadClientId(String readClientId) {
        this.readClientId = readClientId;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public com.feihua.framework.message.api.ApiBaseMessageUserPoService service() {
        return com.feihua.utils.spring.SpringContextHolder.getBean(com.feihua.framework.message.api.ApiBaseMessageUserPoService.class);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageId=").append(messageId);
        sb.append(", userId=").append(userId);
        sb.append(", isRead=").append(isRead);
        sb.append(", isCanRead=").append(isCanRead);
        sb.append(", readClientId=").append(readClientId);
        sb.append(", readTime=").append(readTime);
        sb.append("]");
        return sb.toString();
    }
}