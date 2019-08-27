package com.cn.lx.client;

import com.cn.lx.client.SponsorClient;
import com.cn.lx.client.vo.AdPlan;
import com.cn.lx.client.vo.AdPlanGetRequest;
import com.cn.lx.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 熔断器
 * @author StevenLu
 * @date 2019-08-27 23:52
 */
@Component
public class SponsorClientHystrix implements SponsorClient {
    @Override
    public CommonResponse<List<AdPlan>> getPlan(AdPlanGetRequest adPlanGetRequest) {
        return new CommonResponse<>(-1,"eureka-client-ad-sponsor error");
    }
}
