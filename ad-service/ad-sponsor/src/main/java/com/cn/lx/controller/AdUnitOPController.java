package com.cn.lx.controller;

import com.alibaba.fastjson.JSON;
import com.cn.lx.entity.unit_condition.AdUnitDistrict;
import com.cn.lx.exception.AdException;
import com.cn.lx.service.IAdUnitService;
import com.cn.lx.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author StevenLu
 * @date 2019-08-26 00:07
 */
@Slf4j
@RestController
public class AdUnitOPController {

    @Resource
    private IAdUnitService adUnitService;

    /**
     * 创建广告单元
     * @param adUnitRequest
     * @return
     * @throws AdException
     */
    @PostMapping("/create/adUnit")
    public AdUnitResponse createAdUnit(@RequestBody AdUnitRequest adUnitRequest) throws AdException{
        log.info("创建广告单元入餐:{}", JSON.toJSON(adUnitRequest));
        AdUnitResponse adUnit = adUnitService.createAdUnit(adUnitRequest);
        log.info("创建广告单元响应:{}",JSON.toJSON(adUnit));
        return adUnit;
    }

    /**
     * 创建关键字单元
     * @param adUnitKeywordRequest
     * @return
     * @throws AdException
     */
    @PostMapping("/create/unitKeyword")
    public AdUnitKeywordResponse createUnitKeyword(@RequestBody AdUnitKeywordRequest adUnitKeywordRequest) throws AdException{
        log.info("创建关键字单元入参:{}",JSON.toJSON(adUnitKeywordRequest));
        AdUnitKeywordResponse adUnitKeyword = adUnitService.createAdUnitKeyword(adUnitKeywordRequest);
        log.info("创建关键字单元响应:{}",JSON.toJSON(adUnitKeyword));
        return adUnitKeyword;
    }

    /**
     * 创建想法单元
     * @param adUnitItRequest
     * @return
     * @throws AdException
     */
    @PostMapping("/create/unitIt")
    public AdUnitItResponse createUnitIt(@RequestBody AdUnitItRequest adUnitItRequest) throws AdException{
        log.info("创建想法单元入参:{}",JSON.toJSON(adUnitItRequest));
        AdUnitItResponse adUnitIt = adUnitService.createAdUnitIt(adUnitItRequest);
        log.info("创建想法单元响应:{}", JSON.toJSON(adUnitIt));
        return adUnitIt;
    }

    /**
     * 创建城市描述单元
     * @param adUnitDistrictRequest
     * @return
     * @throws AdException
     */
    @PostMapping("/create/unitDistrict")
    public AdUnitDistrictResponse createUnitDistrict(@RequestBody AdUnitDistrictRequest adUnitDistrictRequest) throws AdException{
        log.info("创建描述单元入参:{}",JSON.toJSON(adUnitDistrictRequest));
        AdUnitDistrictResponse adUnitDistrict = adUnitService.createAdUnitDistrict(adUnitDistrictRequest);
        log.info("创建描述单元响应:{}", JSON.toJSON(adUnitDistrict));
        return adUnitDistrict;
    }

    /**
     * 创建创意和单元关联
     * @param creativeUnitRequest
     * @return
     * @throws AdException
     */
    @PostMapping("/create/creativeUnit")
    public CreativeUnitResponse createCreativeUnit(@RequestBody CreativeUnitRequest creativeUnitRequest)
        throws AdException{
        log.info("创建创意和单元关联入参:{}",JSON.toJSON(creativeUnitRequest));
        CreativeUnitResponse creativeUnit = adUnitService.createCreativeUnit(creativeUnitRequest);
        log.info("创建创意和单元关联响应:{}", JSON.toJSON(creativeUnit));
        return creativeUnit;
    }
}
