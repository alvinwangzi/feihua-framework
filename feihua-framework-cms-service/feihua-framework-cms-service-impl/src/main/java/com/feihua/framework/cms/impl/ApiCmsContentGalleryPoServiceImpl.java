package com.feihua.framework.cms.impl;

import com.feihua.exception.ParamInvalidException;
import com.feihua.framework.cms.api.ApiCmsContentGalleryPoService;
import com.feihua.framework.cms.dto.CmsContentGalleryDto;
import com.feihua.framework.cms.po.CmsContentGalleryPo;
import feihua.jdbc.api.pojo.BasePo;
import feihua.jdbc.api.service.impl.ApiBaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2018-12-06 15:41:23
 */
@Service
public class ApiCmsContentGalleryPoServiceImpl extends ApiBaseServiceImpl<CmsContentGalleryPo, CmsContentGalleryDto, String> implements ApiCmsContentGalleryPoService {
    @Autowired
    com.feihua.framework.cms.mapper.CmsContentGalleryPoMapper CmsContentGalleryPoMapper;

    public ApiCmsContentGalleryPoServiceImpl() {
        super(CmsContentGalleryDto.class);
    }

    @Override
    public List<CmsContentGalleryPo> selectBySiteIdAndContentId(String siteId, String contentId) {
        if (StringUtils.isEmpty(siteId)) {
            return null;
        }
        CmsContentGalleryPo cmsContentGalleryPo = new CmsContentGalleryPo();
        cmsContentGalleryPo.setSiteId(siteId);
        cmsContentGalleryPo.setContentId(contentId);
        cmsContentGalleryPo.setDelFlag(BasePo.YesNo.N.name());
        return this.selectListSimple(cmsContentGalleryPo);
    }

    @Override
    public int deleteBySiteIdAndContentId(String siteId, String contentId, String currentUserId) {
        if (StringUtils.isAnyEmpty(siteId,contentId,currentUserId)) {
            throw new ParamInvalidException("siteId,contentId,currentUserId can not be null or empty");
        }
        CmsContentGalleryPo cmsContentGalleryPo = new CmsContentGalleryPo();
        cmsContentGalleryPo.setSiteId(siteId);
        cmsContentGalleryPo.setContentId(contentId);
        cmsContentGalleryPo.setDelFlag(BasePo.YesNo.N.name());
        return this.deleteFlagSelectiveWithUpdateUser(cmsContentGalleryPo,currentUserId);
    }

    @Override
    public CmsContentGalleryDto wrapDto(CmsContentGalleryPo po) {
        if (po == null) { return null; }
        CmsContentGalleryDto dto = new CmsContentGalleryDto();
        dto.setId(po.getId());
        dto.setContentId(po.getContentId());
        dto.setImageUrl(po.getImageUrl());
        dto.setImageThumbnailUrl(po.getImageThumbnailUrl());
        dto.setImageDes(po.getImageDes());
        dto.setSiteId(po.getSiteId());
        dto.setDataUserId(po.getDataUserId());
        dto.setDataOfficeId(po.getDataOfficeId());
        dto.setDataType(po.getDataType());
        dto.setDataAreaId(po.getDataAreaId());
        dto.setUpdateAt(po.getUpdateAt());
        dto.setSequence(po.getSequence());
        return dto;
    }

}