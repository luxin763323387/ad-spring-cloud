package com.cn.lx.service.Impl;

import com.alibaba.fastjson.JSON;
import com.cn.lx.dao.CreativeRepository;
import com.cn.lx.entity.Creative;
import com.cn.lx.exception.AdException;
import com.cn.lx.service.ICreativeService;
import com.cn.lx.vo.CreativeResponse;
import com.cn.lx.vo.CreativeResquest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author StevenLu
 * @date 2019-08-24 21:08
 */
@Slf4j
@Service
public class CreativeServiceImpl implements ICreativeService {

    @Resource
    private CreativeRepository creativeRepository;

    @Override
    public CreativeResponse createCreative(CreativeResquest creativeResquest) throws AdException {

        log.info("创建创意单元入餐:{}", JSON.toJSON(creativeResquest));
        Creative creative = creativeRepository.save(creativeResquest.convertToEntity());
        log.info("创建创意单元入库参数:{]",JSON.toJSON(creative));
        return new CreativeResponse(creative.getId(),creative.getName());
    }
}
