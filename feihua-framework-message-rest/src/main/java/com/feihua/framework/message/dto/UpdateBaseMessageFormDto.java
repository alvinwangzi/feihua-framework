package com.feihua.framework.message.dto;

import com.feihua.framework.rest.dto.UpdateFormDto;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table base_message
 *
 * @mbg.generated 2018-10-29 19:58:54
*/
public class UpdateBaseMessageFormDto extends UpdateFormDto {
    private String title;

    private String profile;

    private String content;

    private String msgType;

    private String msgState;

    private String messageTemplateId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgState() {
        return msgState;
    }

    public void setMsgState(String msgState) {
        this.msgState = msgState;
    }

    public String getMsgLevel() {
        return msgLevel;
    }

    public void setMsgLevel(String msgLevel) {
        this.msgLevel = msgLevel;
    }

    private String msgLevel;

    public String getMessageTemplateId() {
        return messageTemplateId;
    }

    public void setMessageTemplateId(String messageTemplateId) {
        this.messageTemplateId = messageTemplateId;
    }
}