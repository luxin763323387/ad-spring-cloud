package com.cn.lx.service;

import com.cn.lx.entity.AdPlan;
import com.cn.lx.exception.AdException;
import com.cn.lx.vo.AdPlanGetResquest;
import com.cn.lx.vo.AdPlanRequest;
import com.cn.lx.vo.AdPlanResponse;

import java.util.List;

/**
 * @author StevenLu
 * @date 2019-08-19 22:51
 */
public interface IAdPlanService {

    /**
     * 创建推广计划
     * @param adPlanRequest
     * @return
     */
    AdPlanResponse createAdPlan(AdPlanRequest adPlanRequest) throws AdException;

    /**
     * 查询推广计划
     * @param adPlanGetResquest
     * @return
     */
    List<AdPlan> getAdPlan(AdPlanGetResquest adPlanGetResquest)throws AdException;

    /**
     * 更新推广计划
     * @param adPlanRequest
     * @return
     */
    AdPlanResponse updateAdPlan(AdPlanRequest adPlanRequest)throws AdException;

    /**
     * 删除推广计划
     * @param adPlanRequest
     */
    void deleteAdPlan(AdPlanRequest adPlanRequest)throws AdException;
}
