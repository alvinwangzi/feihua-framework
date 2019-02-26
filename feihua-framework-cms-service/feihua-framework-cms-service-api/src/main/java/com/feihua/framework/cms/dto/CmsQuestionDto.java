package com.feihua.framework.cms.dto;

import feihua.jdbc.api.pojo.BaseDbDto;
import java.util.Date;
import java.util.List;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table cms_question
 *
 * @mbg.generated 2019-01-17 14:00:41
*/
public class CmsQuestionDto extends BaseDbDto<String> {
    private String id;

    private String surveyId;

    private String name;

    private String type;

    private String br;

    private Integer sequence;

    private String dataUserId;

    private String dataOfficeId;

    private String dataType;

    private String dataAreaId;

    private String delFlag;

    private Date createAt;

    private String createBy;

    private Date updateAt;

    private String updateBy;

    private List<CmsQuestionOptionsDto> options;

    public List<CmsQuestionOptionsDto> getOptions() {
        return options;
    }

    public void setOptions(List<CmsQuestionOptionsDto> options) {
        this.options = options;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBr() {
        return br;
    }

    public void setBr(String br) {
        this.br = br;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getDataUserId() {
        return dataUserId;
    }

    public void setDataUserId(String dataUserId) {
        this.dataUserId = dataUserId;
    }

    public String getDataOfficeId() {
        return dataOfficeId;
    }

    public void setDataOfficeId(String dataOfficeId) {
        this.dataOfficeId = dataOfficeId;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataAreaId() {
        return dataAreaId;
    }

    public void setDataAreaId(String dataAreaId) {
        this.dataAreaId = dataAreaId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}