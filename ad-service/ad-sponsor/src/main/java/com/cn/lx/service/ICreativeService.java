package com.cn.lx.service;

import com.cn.lx.exception.AdException;
import com.cn.lx.vo.CreativeResponse;
import com.cn.lx.vo.CreativeResquest;

/**
 * @author StevenLu
 * @date 2019-08-24 21:06
 */
public interface ICreativeService {

    /**
     * 创建创意单元
     * @param creativeResquest
     * @return
     * @throws AdException
     */
    CreativeResponse createCreative(CreativeResquest creativeResquest) throws AdException;

}
