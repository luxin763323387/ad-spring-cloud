package com.cn.lx.service;

import com.cn.lx.exception.AdException;
import com.cn.lx.vo.*;

/**
 * @author StevenLu
 * @date 2019-08-24 11:57
 */
public interface IAdUnitService {

    /**
     * 创建广告单元
     * @param adUnitRequest
     * @return
     */
    AdUnitResponse createAdUnit(AdUnitRequest adUnitRequest) throws AdException;

    /**
     * 创建关键字单元
     * @param adUnitKeywordResquest
     * @return
     * @throws AdException
     */
    AdUnitKeywordResponse createAdUnitKeyword(AdUnitKeywordRequest adUnitKeywordResquest) throws AdException;

    /**
     * 创建想法单元
     * @param adUnitItRequest
     * @return
     * @throws AdException
     */
    AdUnitItResponse createAdUnitIt(AdUnitItRequest adUnitItRequest) throws AdException;


    CreativeUnitResponse createCreativeUnit(CreativeUnitResquest creativeUnitResquest) throws AdException;
}
