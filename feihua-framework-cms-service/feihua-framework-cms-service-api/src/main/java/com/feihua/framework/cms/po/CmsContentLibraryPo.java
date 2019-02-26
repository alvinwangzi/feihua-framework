package com.feihua.framework.cms.po;

import feihua.jdbc.api.pojo.BasePo;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2018-12-06 15:42:29
 * Database Table Remarks:
 *   内容文库表
 *
 * This class corresponds to the database table cms_content_library
 * @mbg.generated do_not_delete_during_merge 2018-12-06 15:42:29
*/
public class CmsContentLibraryPo extends feihua.jdbc.api.pojo.BasePo<String> {
    /**
     * Database Column Remarks:
     *   站点id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_library.SITE_ID
     *
     * @mbg.generated 2018-12-06 15:42:29
     */
    private String siteId;

    /**
     * Database Column Remarks:
     *   内容id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_library.CONTENT_ID
     *
     * @mbg.generated 2018-12-06 15:42:29
     */
    private String contentId;

    /**
     * Database Column Remarks:
     *   名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_library.FILENAME
     *
     * @mbg.generated 2018-12-06 15:42:29
     */
    private String filename;

    /**
     * Database Column Remarks:
     *   附件地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_library.URL
     *
     * @mbg.generated 2018-12-06 15:42:29
     */
    private String url;

    /**
     * Database Column Remarks:
     *   附件类型，附件扩展名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_library.EXT
     *
     * @mbg.generated 2018-12-06 15:42:29
     */
    private String ext;

    /**
     * Database Column Remarks:
     *   附件类型，字典，word,excel,pdf,zip等
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_library.TYPE
     *
     * @mbg.generated 2018-12-06 15:42:29
     */
    private String type;

    /**
     * Database Column Remarks:
     *   下载次数
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_library.DWONLOAD_NUM
     *
     * @mbg.generated 2018-12-06 15:42:29
     */
    private Integer dwonloadNum;

    /**
     * Database Column Remarks:
     *   大小
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_library.SIZE
     *
     * @mbg.generated 2018-12-06 15:42:29
     */
    private String size;

    /**
     * Database Column Remarks:
     *   附件描述信息
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_library.DESCRIPTION
     *
     * @mbg.generated 2018-12-06 15:42:29
     */
    private String description;

    /**
     * Database Column Remarks:
     *   图片url
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_library.IMAGE_URL
     *
     * @mbg.generated 2018-12-06 15:42:29
     */
    private String imageUrl;

    /**
     * Database Column Remarks:
     *   图片描述信息
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_library.IMAGE_DES
     *
     * @mbg.generated 2018-12-06 15:42:29
     */
    private String imageDes;

    /**
     * Database Column Remarks:
     *   排序
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_content_library.SEQUENCE
     *
     * @mbg.generated 2018-12-06 15:42:29
     */
    private Integer sequence;

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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDwonloadNum() {
        return dwonloadNum;
    }

    public void setDwonloadNum(Integer dwonloadNum) {
        this.dwonloadNum = dwonloadNum;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageDes() {
        return imageDes;
    }

    public void setImageDes(String imageDes) {
        this.imageDes = imageDes;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public com.feihua.framework.cms.api.ApiCmsContentLibraryPoService service() {
        return com.feihua.utils.spring.SpringContextHolder.getBean(com.feihua.framework.cms.api.ApiCmsContentLibraryPoService.class);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", siteId=").append(siteId);
        sb.append(", contentId=").append(contentId);
        sb.append(", filename=").append(filename);
        sb.append(", url=").append(url);
        sb.append(", ext=").append(ext);
        sb.append(", type=").append(type);
        sb.append(", dwonloadNum=").append(dwonloadNum);
        sb.append(", size=").append(size);
        sb.append(", description=").append(description);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", imageDes=").append(imageDes);
        sb.append(", sequence=").append(sequence);
        sb.append("]");
        return sb.toString();
    }
}