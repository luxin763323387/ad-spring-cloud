package com.cn.lx.service.Impl;

import com.alibaba.fastjson.JSON;
import com.cn.lx.constant.Constants;
import com.cn.lx.dao.AdPlanRepository;
import com.cn.lx.dao.AdUserRepository;
import com.cn.lx.entity.AdPlan;
import com.cn.lx.entity.AdUser;
import com.cn.lx.exception.AdException;
import com.cn.lx.service.IAdPlanService;
import com.cn.lx.utils.CommonUtils;
import com.cn.lx.vo.AdPlanGetResquest;
import com.cn.lx.vo.AdPlanRequest;
import com.cn.lx.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author StevenLu
 * @date 2019-08-19 23:07
 */
@Service
@Slf4j
public class AdPlanServiceImpl implements IAdPlanService {

    @Resource
    private AdPlanRepository adPlanRepository;

    @Resource
    private AdUserRepository adUserRepository;


    @Override
    public AdPlanResponse createAdPlan(AdPlanRequest adPlanRequest) throws AdException {

        if(adPlanRequest.createValidate()){
            log.error("创建计划入参错误:{}", JSON.toJSON(adPlanRequest));
            throw new AdException(Constants.Errmsg.ERRORMSG);
        }

        //确保关联的User是存在的
        Optional<AdUser> adUser = adUserRepository.findById(adPlanRequest.getUserId());
        if(!adUser.isPresent()){
            throw new AdException(Constants.Errmsg.CANFFOUNDRECORD);
        }

        //确保不同adplan 不同名字
        AdPlan adPlan = adPlanRepository.findByUserIdAndPlanName(adPlanRequest.getUserId(), adPlanRequest.getPlanName());
        if(adPlan != null){
            log.error("具有相同id和名字的广告");
            throw new AdException(Constants.Errmsg.SAMENAME);
        }
        AdPlan adPlan1 = new AdPlan(adPlanRequest.getUserId(),adPlanRequest.getPlanName(),
                CommonUtils.String2Date(adPlanRequest.getStartDate()),
                CommonUtils.String2Date(adPlanRequest.getEndDate()));
        AdPlan newAdPlan = adPlanRepository.save(adPlan1);
        return  new AdPlanResponse(newAdPlan.getId(),newAdPlan.getPlanName());
    }

    @Override
    public AdPlanResponse getAdPlan(AdPlanGetResquest adPlanGetResquest) throws AdException {
        return null;
    }

    @Override
    public AdPlanResponse updateAdPlan(AdPlanRequest adPlanRequest) throws AdException {
        return null;
    }

    @Override
    public void deleteAdPlan(AdPlanRequest adPlanRequest) throws AdException {

    }
}
