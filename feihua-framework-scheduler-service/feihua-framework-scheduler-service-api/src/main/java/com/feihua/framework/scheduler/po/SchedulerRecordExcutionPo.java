package com.feihua.framework.scheduler.po;

import feihua.jdbc.api.pojo.BasePo;
import java.util.Date;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2019-04-24 09:03:49
 * Database Table Remarks:
 *   任务计划执行记录表
 *
 * This class corresponds to the database table scheduler_record_excution
 * @mbg.generated do_not_delete_during_merge 2019-04-24 09:03:49
*/
public class SchedulerRecordExcutionPo extends feihua.jdbc.api.pojo.BasePo<String> {
    /**
     * Database Column Remarks:
     *   任务计划表id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scheduler_record_excution.scheduler_id
     *
     * @mbg.generated 2019-04-24 09:03:49
     */
    private String schedulerId;

    /**
     * Database Column Remarks:
     *   批次号，同一个批次号标识是一组数组
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scheduler_record_excution.batch_no
     *
     * @mbg.generated 2019-04-24 09:03:49
     */
    private String batchNo;

    /**
     * Database Column Remarks:
     *   开始时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scheduler_record_excution.start_time
     *
     * @mbg.generated 2019-04-24 09:03:49
     */
    private Date startTime;

    /**
     * Database Column Remarks:
     *   结束时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scheduler_record_excution.end_time
     *
     * @mbg.generated 2019-04-24 09:03:49
     */
    private Date endTime;

    /**
     * Database Column Remarks:
     *   耗时单位ms
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scheduler_record_excution.duration
     *
     * @mbg.generated 2019-04-24 09:03:49
     */
    private String duration;

    public String getSchedulerId() {
        return schedulerId;
    }

    public void setSchedulerId(String schedulerId) {
        this.schedulerId = schedulerId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public com.feihua.framework.scheduler.api.ApiSchedulerRecordExcutionPoService service() {
        return com.feihua.utils.spring.SpringContextHolder.getBean(com.feihua.framework.scheduler.api.ApiSchedulerRecordExcutionPoService.class);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", schedulerId=").append(schedulerId);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", duration=").append(duration);
        sb.append("]");
        return sb.toString();
    }
}