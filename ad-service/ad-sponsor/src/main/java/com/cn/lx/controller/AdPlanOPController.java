package com.cn.lx.controller;

import com.alibaba.fastjson.JSON;
import com.cn.lx.entity.AdPlan;
import com.cn.lx.exception.AdException;
import com.cn.lx.service.IAdPlanService;
import com.cn.lx.vo.AdPlanGetRequest;
import com.cn.lx.vo.AdPlanRequest;
import com.cn.lx.vo.AdPlanResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author StevenLu
 * @date 2019-08-24 22:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController
@Slf4j
public class AdPlanOPController{

    @Resource
    private IAdPlanService adPlanService;

    @PostMapping("/create/adPlan")
    public AdPlanResponse createAdPlan(
            @RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: createAdPlan -> {}",
                JSON.toJSONString(request));
        return adPlanService.createAdPlan(request);
    }

    @PostMapping("/get/adPlan")
    public List<AdPlan> getAdPlanByIds(
            @RequestBody AdPlanGetRequest request) throws AdException {
        log.info("ad-sponsor: getAdPlanByIds -> {}",
                JSON.toJSONString(request));
        return adPlanService.getAdPlan(request);
    }

    @PutMapping("/update/adPlan")
    public AdPlanResponse updateAdPlan(
            @RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: updateAdPlan -> {}",
                JSON.toJSONString(request));
        return adPlanService.updateAdPlan(request);
    }

    @DeleteMapping("/delete/adPlan")
    public void deleteAdPlan(
            @RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: deleteAdPlan -> {}",
                JSON.toJSONString(request));
        adPlanService.deleteAdPlan(request);
    }
}
