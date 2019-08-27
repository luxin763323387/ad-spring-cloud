package com.cn.lx.client;

import com.cn.lx.client.vo.AdPlan;
import com.cn.lx.client.vo.AdPlanGetRequest;
import com.cn.lx.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 使用feign调用其他模块的接口
 * @author StevenLu
 * @date 2019-08-27 23:39
 */
@FeignClient(value = "eureka-client-ad-sponsor",fallback = SponsorClientHystrix.class)
public interface SponsorClient {

    @RequestMapping("")
    CommonResponse<List<AdPlan>> getPlan (@RequestBody AdPlanGetRequest adPlanGetRequest);

}
