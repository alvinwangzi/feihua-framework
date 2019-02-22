package com.feihua.framework.cms.po;

import feihua.jdbc.api.pojo.BasePo;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2018-12-24 13:42:45
 * Database Table Remarks:
 *   内容视频第三方播放表
 *
 * This class corresponds to the database table cms_content_video_other_player
 * @mbg.generated do_not_delete_during_merge 2018-12-24 13:42:45
*/
public class CmsContentVideoOtherPlayerPo extends feihua.jdbc.api.pojo.BasePo<String> {
    /**
     * Database Column Remarks:
     *   站点id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_video_other_player.SITE_ID
     *
     * @mbg.generated 2018-12-24 13:42:45
     */
    private String siteId;

    /**
     * Database Column Remarks:
     *   内容id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_video_other_player.CONTENT_ID
     *
     * @mbg.generated 2018-12-24 13:42:45
     */
    private String contentId;

    /**
     * Database Column Remarks:
     *   视频id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_video_other_player.VIDEO_ID
     *
     * @mbg.generated 2018-12-24 13:42:45
     */
    private String videoId;

    /**
     * Database Column Remarks:
     *   播放，字典
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_video_other_player.PLAYER
     *
     * @mbg.generated 2018-12-24 13:42:45
     */
    private String player;

    /**
     * Database Column Remarks:
     *   播放地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_video_other_player.URL
     *
     * @mbg.generated 2018-12-24 13:42:45
     */
    private String url;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public com.feihua.framework.cms.api.ApiCmsContentVideoOtherPlayerPoService service() {
        return com.feihua.utils.spring.SpringContextHolder.getBean(com.feihua.framework.cms.api.ApiCmsContentVideoOtherPlayerPoService.class);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", siteId=").append(siteId);
        sb.append(", contentId=").append(contentId);
        sb.append(", videoId=").append(videoId);
        sb.append(", player=").append(player);
        sb.append(", url=").append(url);
        sb.append("]");
        return sb.toString();
    }
}