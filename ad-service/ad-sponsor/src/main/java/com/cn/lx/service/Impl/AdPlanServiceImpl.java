package com.cn.lx.service.Impl;

import com.alibaba.fastjson.JSON;
import com.cn.lx.constant.CommonStatus;
import com.cn.lx.constant.Constants;
import com.cn.lx.dao.AdPlanRepository;
import com.cn.lx.dao.AdUserRepository;
import com.cn.lx.entity.AdPlan;
import com.cn.lx.entity.AdUser;
import com.cn.lx.exception.AdException;
import com.cn.lx.service.IAdPlanService;
import com.cn.lx.utils.CommonUtils;
import com.cn.lx.vo.AdPlanGetRequest;
import com.cn.lx.vo.AdPlanRequest;
import com.cn.lx.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
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

        if(!adPlanRequest.createValidate()){
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
    public List<AdPlan> getAdPlan(AdPlanGetRequest adPlanGetRequest) throws AdException {

        if(!adPlanGetRequest.validate()){
            throw new AdException(Constants.Errmsg.REQUEST_PARAM_ERROR);
        }
        return adPlanRepository.findAllByIdInAndUserId(adPlanGetRequest.getIds(),
                adPlanGetRequest.getUserId());
    }

    @Override
    public AdPlanResponse updateAdPlan(AdPlanRequest adPlanRequest) throws AdException {

        if(!adPlanRequest.updateValidate()){
            throw new AdException(Constants.Errmsg.REQUEST_PARAM_ERROR);
        }

        AdPlan adPlan = adPlanRepository.findByIdAndUserId(adPlanRequest.getId(), adPlanRequest.getUserId());
        if (adPlan == null){
            throw new AdException(Constants.Errmsg.CANFFOUNDRECORD);
        }

        //如果名字,起始时间,结束时间不为空则更新
        if(adPlan.getPlanName() != null){
            adPlan.setPlanName(adPlanRequest.getPlanName());
        }
        if(adPlan.getStartDate() != null){
            adPlan.setStartDate(CommonUtils.String2Date(adPlanRequest.getStartDate()));
        }
        if(adPlan.getEndDate() != null){
            adPlan.setEndDate(CommonUtils.String2Date(adPlanRequest.getEndDate()));
        }
        adPlan.setUpdateTime(new Date());
        AdPlan adPlanResult = adPlanRepository.save(adPlan);
        return new AdPlanResponse(adPlanResult.getId(),adPlanResult.getPlanName());
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteAdPlan(AdPlanRequest adPlanRequest) throws AdException {

        if(!adPlanRequest.deleteValidate()){
            throw new AdException(Constants.Errmsg.REQUEST_PARAM_ERROR);
        }

        AdPlan plan = adPlanRepository.findByIdAndUserId(adPlanRequest.getId(), adPlanRequest.getUserId());
        if(plan == null){
            throw new AdException(Constants.Errmsg.CANFFOUNDRECORD);
        }

        plan.setPlanStatus(CommonStatus.INVALID.getStatus());
        plan.setUpdateTime(new Date());

        adPlanRepository.save(plan);
    }
}
