package com.feihua.framework.base.modules.loginclient.api;

import com.feihua.framework.base.modules.loginclient.dto.BaseLoginClientDto;
import com.feihua.framework.base.modules.loginclient.po.BaseLoginClientPo;
import feihua.jdbc.api.pojo.BasePo;
import feihua.jdbc.api.pojo.PageResultDto;

import java.util.List;

/**
 * This class was generated by MyBatis Generator.
 * @author yangwei 2019-04-04 11:42:32
 */
public interface ApiBaseLoginClientPoService extends feihua.jdbc.api.service.ApiBaseService<BaseLoginClientPo, BaseLoginClientDto, String> {
    /**
     *
     * @param dto
     * @param pageAndOrderbyParamDto
     * @return
     */
    PageResultDto<BaseLoginClientDto> searchBaseLoginClientsDsf(com.feihua.framework.base.modules.loginclient.dto.SearchBaseLoginClientsConditionDto dto, feihua.jdbc.api.pojo.PageAndOrderbyParamDto pageAndOrderbyParamDto);

    /**
     * 根据客户端编码查询
     * @param clientCode 客户端编码 如：pc
     * @return 如果参数为空返回null,否则根据查询结果返回
     */
    BaseLoginClientPo selectByClientCode(String clientCode);

    List<BaseLoginClientPo> selectByIsVirtual(BasePo.YesNo yesNo);
}