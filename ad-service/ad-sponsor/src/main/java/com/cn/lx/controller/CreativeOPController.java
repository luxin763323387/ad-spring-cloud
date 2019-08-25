package com.cn.lx.controller;

import com.alibaba.fastjson.JSON;
import com.cn.lx.exception.AdException;
import com.cn.lx.service.ICreativeService;
import com.cn.lx.vo.CreativeResponse;
import com.cn.lx.vo.CreativeResquest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author StevenLu
 * @date 2019-08-26 01:05
 */
@RestController
@Slf4j
public class CreativeOPController {

    @Resource
    private ICreativeService creativeService;

    /**
     * 创建创意单元
     * @param creativeResquest
     * @return
     * @throws AdException
     */
    @PostMapping("/create/creative")
    public CreativeResponse creatCreative(@RequestBody CreativeResquest creativeResquest) throws AdException{
        log.info("创建创意入参:{}", JSON.toJSON(creativeResquest));
        CreativeResponse creative = creativeService.createCreative(creativeResquest);
        log.info("创建创意响应:{}",JSON.toJSON(creative));
        return creative;
    }
}
