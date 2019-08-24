package com.cn.lx.service.Impl;

import com.alibaba.fastjson.JSON;
import com.cn.lx.constant.Constants;
import com.cn.lx.dao.AdPlanRepository;
import com.cn.lx.dao.AdUnitRepository;
import com.cn.lx.dao.unit_condition.AdUnitItRepository;
import com.cn.lx.dao.unit_condition.AdUnitKeywordRepository;
import com.cn.lx.entity.AdPlan;
import com.cn.lx.entity.AdUnit;
import com.cn.lx.entity.unit_condition.AdUnitIt;
import com.cn.lx.entity.unit_condition.AdUnitKeyword;
import com.cn.lx.exception.AdException;
import com.cn.lx.service.IAdUnitService;
import com.cn.lx.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableServer.POAPackage.AdapterAlreadyExists;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author StevenLu
 * @date 2019-08-24 11:59
 */
@Slf4j
@Service
public class AdUnitServiceImpl implements IAdUnitService {

    @Resource
    private AdUnitRepository adUnitRepository;

    @Resource
    private AdPlanRepository adPlanRepository;

    @Resource
    private AdUnitKeywordRepository adUnitKeywordRepository;

    @Resource
    private AdUnitItRepository adUnitItRepository;

    @Override
    public AdUnitResponse createAdUnit(AdUnitRequest adUnitRequest) throws AdException {

        log.info("创建广告单元入餐:{}", JSON.toJSON(adUnitRequest));
        if(!adUnitRequest.createValidate()){
            throw new AdException(Constants.Errmsg.REQUEST_PARAM_ERROR);
        }

        //查看广告计划是否为空
        Optional<AdPlan> plan = adPlanRepository.findById(adUnitRequest.getPlanId());
        if (plan.isPresent()){
            throw new AdException(Constants.Errmsg.CANT_FOUND_RECORD);
        }

        //查看广告单元是否为空
        AdUnit unit = adUnitRepository.findByPlanIdAndUnitName(adUnitRequest.getPlanId(), adUnitRequest.getUnitName());
        if(unit != null){
            throw new AdException(Constants.Errmsg.SAME_UNIT_NAME);
        }

        AdUnit adUnit = new AdUnit(
                unit.getPlanId(), unit.getUnitName(), unit.getPositionType(), unit.getBudget()
        );
        AdUnit result = adUnitRepository.save(adUnit);
        return new AdUnitResponse(result.getPlanId(),result.getUnitName());
    }

    @Override
    public AdUnitKeywordResponse createAdUnitKeyword(
            AdUnitKeywordResquest adUnitKeywordResquest) throws AdException {

        List<Long> unitKeywords = adUnitKeywordResquest.getUnitKeywords().stream()
                .map(AdUnitKeywordResquest.UnitKeyword::getUnitId)
                .collect(Collectors.toList());


        if(CollectionUtils.isEmpty(unitKeywords)){
            throw new AdException(Constants.Errmsg.REQUEST_PARAM_ERROR);
        }

        //遍历unitkeywords
        List<AdUnitKeyword> adUnitKeywordList = new ArrayList<>();
        adUnitKeywordResquest.getUnitKeywords()
                .forEach(i -> adUnitKeywordList.add(new AdUnitKeyword(i.getUnitId(),i.getKeyword())));

        //关键字单元入库
        List<Long> ids = adUnitKeywordRepository.saveAll(adUnitKeywordList).stream()
                .map(AdUnitKeyword::getId)
                .collect(Collectors.toList());

        return new AdUnitKeywordResponse(ids);
    }

    @Override
    public AdUnitItResponse createAdUnitIt(AdUnitItResquest adUnitItResquest) throws AdException {

        log.info("创建广单元想法:{}",JSON.toJSON(adUnitItResquest));
        List<Long> unitIts = adUnitItResquest.getUnitIts().stream()
                .map(AdUnitItResquest.UnitIt::getUnitId)
                .collect(Collectors.toList());

        if(CollectionUtils.isEmpty(unitIts)){
            throw new AdException(Constants.Errmsg.REQUEST_PARAM_ERROR);
        }

        //遍历unitIts
        List<AdUnitIt> adUnitIts = new ArrayList<>();
        adUnitItResquest.getUnitIts()
                .forEach(e -> adUnitIts.add(new AdUnitIt(e.getUnitId(),e.getItTag())));

        //unitIts入数据库
        List<Long> ids = adUnitItRepository.saveAll(adUnitIts)
                .stream().map(AdUnitIt::getId)
                .collect(Collectors.toList());
        return new AdUnitItResponse(ids);
    }


}
