package com.wwd.service.impl;

import com.feihua.framework.base.modules.dict.api.ApiBaseDictPoService;
import com.feihua.framework.base.modules.dict.po.BaseDictPo;
import com.feihua.framework.constants.DictEnum;
import com.feihua.framework.utils.AliOssClientHelper;
import com.feihua.utils.calendar.CalendarUtils;
import com.feihua.utils.graphic.ImageUtils;
import com.feihua.utils.http.httpServletRequest.RequestUtils;
import com.feihua.utils.http.httpServletResponse.ResponseCode;
import com.feihua.utils.http.httpclient.HttpClientUtils;
import com.feihua.utils.io.StreamUtils;
import com.github.pagehelper.Page;
import com.wwd.service.modules.wwd.api.*;
import com.wwd.service.modules.wwd.dto.*;
import com.wwd.service.modules.wwd.po.WwdUserCardPo;
import feihua.jdbc.api.pojo.BasePo;
import feihua.jdbc.api.pojo.PageResultDto;
import feihua.jdbc.api.service.impl.ApiBaseServiceImpl;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2018-11-01 10:44:36
 */
@Service
public class ApiWwdUserCardPoServiceImpl extends ApiBaseServiceImpl<WwdUserCardPo, WwdUserCardDto, String> implements ApiWwdUserCardPoService {
    @Autowired
    com.wwd.service.mapper.WwdUserCardPoMapper WwdUserCardPoMapper;
    @Autowired
    private AliOssClientHelper aliOssClientHelper;
    @Autowired
    private ApiBaseDictPoService apiBaseDictPoService;
    @Autowired
    private ApiWwdUserTagPoService apiWwdUserTagPoService;

    @Autowired
    private ApiWwdUserPoService apiWwdUserPoService;
    @Autowired
    private ApiWwdUserPicPoService apiWwdUserPicPoService;
    @Autowired
    private ApiWwdUserAreaPoService apiWwdUserAreaPoService;

    public ApiWwdUserCardPoServiceImpl() {
        super(WwdUserCardDto.class);
    }

    @Override
    public PageResultDto<WwdUserCardDto> searchWwdUserCardsDsf(com.wwd.service.modules.wwd.dto.SearchWwdUserCardsConditionDto dto, feihua.jdbc.api.pojo.PageAndOrderbyParamDto pageAndOrderbyParamDto) {
        Page p = super.pageAndOrderbyStart(pageAndOrderbyParamDto);
        List<com.wwd.service.modules.wwd.dto.WwdUserCardDto> list = this.wrapDtos(WwdUserCardPoMapper.searchWwdUserCards(dto));
        return new PageResultDto(list, this.wrapPage(p));
    }

    @Override
    public WwdUserCardPo generateCard(String userId) {

        WwdUserDto wwdUserDto = apiWwdUserPoService.selectByUserId(userId);

        if (wwdUserDto == null) {

            return null;
        }else {

            // 获取图片
            List<WwdUserPicDto> userPicDtos = apiWwdUserPicPoService.selectByWwdUserId(wwdUserDto.getId());
            Map<String, String> userPicMap = new HashMap<>();
            if (userPicDtos != null) {
                int putIndex = 1;
                for (int i = 0; i < userPicDtos.size(); i++) {
                    WwdUserPicDto picDto = userPicDtos.get(i);
                    if ("main".equals(picDto.getType())) {
                        userPicMap.put("main", picDto.getPicOriginUrl());
                    } else {
                        userPicMap.put(putIndex + "", picDto.getPicOriginUrl());
                        putIndex++;
                    }

                }
            }

            String wwdcardbgPath = RequestUtils.getRequest().getSession().getServletContext().getRealPath("") + File.separator + "WEB-INF" + File.separator + "wwdcardbg";
            String bgPath = "";
            Color textColor = null;
            if (DictEnum.Gender.female.name().equals(wwdUserDto.getGender())) {
                bgPath = wwdcardbgPath + File.separator + "female.png";

                textColor = new Color(0, 0, 0);
            } else {
                textColor = new Color(255, 255, 255);
                bgPath = wwdcardbgPath + File.separator + "male.png";
            }

            try {
                BufferedImage bgImage = ImageUtils.createImage(bgPath);


                // 添加图片
                // 主图
                String mainUrl = userPicMap.get("main");
                if (StringUtils.isNotEmpty(mainUrl)) {
                    BufferedImage pressImg = ImageUtils.inputStreamToBufferedImage(download(mainUrl));
                    int width = 280;
                    if (pressImg.getWidth() > width) {
                        pressImg = Thumbnails.of(pressImg).scale((new Double(width)).doubleValue() / (double) pressImg.getWidth()).asBufferedImage();
                    }
                    int height = 310;
                    if (pressImg.getHeight() > height) {
                        pressImg = ImageUtils.cutImage(pressImg, 0, (pressImg.getHeight() - height) / 2, pressImg.getWidth(), height);
                    }
                    ImageUtils.pressImage(bgImage, pressImg, 400, 150, 1.0f);
                }
                // 小图
                int imgY = 615;
                int imgX = 90;
                int height = 270;
                for (int i = 0; i < 3; i++) {
                    String url = userPicMap.get(i + 1 + "");
                    if (StringUtils.isNotEmpty(url)) {
                        BufferedImage pressImg = ImageUtils.inputStreamToBufferedImage(download(url));
                        int width = 200;
                        if (pressImg.getWidth() > width) {

                            pressImg = Thumbnails.of(pressImg).scale((new Double(width)).doubleValue() / (double) pressImg.getWidth()).asBufferedImage();
                        }
                        if (pressImg.getHeight() > height) {
                            pressImg = ImageUtils.cutImage(pressImg, 0, (pressImg.getHeight() - height) / 2, pressImg.getWidth(), height);
                        }
                        ImageUtils.pressImage(bgImage, pressImg, imgX, imgY, 1.0f);
                        imgX += width + 30;
                    }
                }


                WwdUserAreaDto userAreaDto = apiWwdUserAreaPoService.selectByWwdUserId(wwdUserDto.getId());
                String now = "";
                String home = "";
                if (userAreaDto != null) {
                    now = userAreaDto.getNowProvinceName() + " " + userAreaDto.getNowDistrictName();
                    home = userAreaDto.getHomeProvinceName() + " " + userAreaDto.getHomeCityName();
                }
                List<WwdUserTagDto> userTagDtos = apiWwdUserTagPoService.selectByWwdUserId(wwdUserDto.getId());
                String hobbyType = "";
                if (userTagDtos != null) {
                    for (WwdUserTagDto userTagDto : userTagDtos) {
                        if ("hobby_type".equals(userTagDto.getType())) {
                            hobbyType = userTagDto.getContent();
                        }
                    }
                }

                int x = 100;
                int x_center = bgImage.getWidth() / 2 - 70;
                int y = 90;
                int titleFontSize = 20;
                int textFontSize = 16;
                int lineHeight = 30;
                bgImage = ImageUtils.pressText(bgImage, "个人介绍", "宋体", Font.BOLD, textColor, titleFontSize, x_center, y, 1);
                y = 120;
                bgImage = ImageUtils.pressText(bgImage, "昵称/微信：" + wwdUserDto.getName(), "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "性别：" + apiBaseDictPoService.selectDictLabel("gender", wwdUserDto.getGender()), "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "身高：" + wwdUserDto.getHeight(), "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "体重：" + wwdUserDto.getWeight(), "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);

                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "婚姻：" + apiBaseDictPoService.selectDictLabel("married_status", wwdUserDto.getMaritalStatus()), "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "家乡在：" + home, "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "目前在：" + now, "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "生日：" + CalendarUtils.dateToString(wwdUserDto.getBirthDay()), "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "学历：" + apiBaseDictPoService.selectDictLabel("education_level", wwdUserDto.getEducation()), "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "房：" + apiBaseDictPoService.selectDictLabel("has_hourse_status", wwdUserDto.getHasHourse()), "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "车：" + apiBaseDictPoService.selectDictLabel("has_car_status", wwdUserDto.getHasCar()), "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "抽烟：" + apiBaseDictPoService.selectDictLabel("smoking_status", wwdUserDto.getSmoking()), "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "喝酒：" + apiBaseDictPoService.selectDictLabel("drinking_status", wwdUserDto.getDrinking()), "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                y += lineHeight;
                bgImage = ImageUtils.pressText(bgImage, "标签信息：" + hobbyType, "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                String _description = "补充介绍：" + wwdUserDto.getDescription();
                int descriptionLength = _description.length();

                String lineDescription = "";
                for (int i = 0; i < descriptionLength; i++) {
                    lineDescription += _description.charAt(i);
                    if (lineDescription.length() == 38 || i + 1 == descriptionLength) {
                        y += lineHeight;
                        bgImage = ImageUtils.pressText(bgImage, lineDescription, "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                        lineDescription = "";
                    }
                }

                y = 910;
                bgImage = ImageUtils.pressText(bgImage, "择偶标准/理想类型", "宋体", Font.BOLD, textColor, titleFontSize, x_center, y, 1);
                y += 30;
                lineDescription = "";
                String _stardard = "  " + wwdUserDto.getStandard();
                descriptionLength = _stardard.length();
                for (int i = 0; i < descriptionLength; i++) {
                    lineDescription += _stardard.charAt(i);
                    if (lineDescription.length() == 38 || i + 1 == descriptionLength) {
                        y += lineHeight;
                        bgImage = ImageUtils.pressText(bgImage, lineDescription, "宋体", Font.BOLD, textColor, textFontSize, x, y, 1);
                        lineDescription = "";
                    }
                }


                String resultPath = aliOssClientHelper.getAbsolutePath(aliOssClientHelper.uploadFile("/wwdcard", wwdUserDto.getId() + ".png", ImageUtils.bufferedImageToInputStream(bgImage, "png"), null));

                // 判断是否已存在，
                WwdUserCardPo userCardPodb =  selectByWwdUserId(wwdUserDto.getId());
                if (userCardPodb != null) {
                    // 更新
                    userCardPodb.setPicOriginUrl(resultPath);
                    this.updateByPrimaryKeySelective(userCardPodb);
                }else {
                    //直接添加
                    userCardPodb = new WwdUserCardPo();
                    userCardPodb.setPicOriginUrl(resultPath);
                    userCardPodb.setWwdUserId(wwdUserDto.getId());
                    this.preInsert(userCardPodb,userId);
                    this.insertSelective(userCardPodb);
                }

            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
            return this.selectByWwdUserId(wwdUserDto.getId());
        }
    }

    @Override
    public WwdUserCardPo selectByWwdUserId(String wwdUserId) {
        WwdUserCardPo wwdUserCardPo = new WwdUserCardPo();
        wwdUserCardPo.setWwdUserId(wwdUserId);
        wwdUserCardPo.setDelFlag(BasePo.YesNo.N.name());
        return this.selectOneSimple(wwdUserCardPo);
    }

    @Override
    public WwdUserCardDto wrapDto(WwdUserCardPo po) {
        if (po == null) {
            return null;
        }
        WwdUserCardDto wwdUserCardDto = new WwdUserCardDto();
        wwdUserCardDto.setSequence(po.getSequence());
        wwdUserCardDto.setDescribtion(po.getDescribtion());
        wwdUserCardDto.setPicOriginUrl(po.getPicOriginUrl());
        wwdUserCardDto.setPicThumbUrl(po.getPicThumbUrl());
        wwdUserCardDto.setType(po.getType());
        wwdUserCardDto.setDataOfficeId(po.getDataOfficeId());
        wwdUserCardDto.setDataUserId(po.getDataUserId());
        wwdUserCardDto.setDataAreaId(po.getDataAreaId());
        wwdUserCardDto.setId(po.getId());
        wwdUserCardDto.setUpdateAt(po.getUpdateAt());
        wwdUserCardDto.setDataType(po.getDataType());
        return super.wrapDto(po);
    }

    private ByteArrayInputStream download(String url) throws IOException {
        HttpClient client = HttpClientUtils.getClient();
        HttpGet get = new HttpGet(url + "?x-oss-process=image/auto-orient,1");

        HttpResponse httpResponse =  client.execute(get);
        InputStream inputStream = httpResponse.getEntity().getContent();

        return StreamUtils.inputStreamToByteArrayInputStream(inputStream);
    }
}