package com.cn.lx.service;

import com.cn.lx.exception.AdException;
import com.cn.lx.vo.CreateUserRequest;
import com.cn.lx.vo.CreateUserResponse;

/**
 * @author StevenLu
 * @date 2019-08-19 22:20
 */
public interface IUserService {

    /**
     * 创建推荐人
     * @param createUserRequest
     * @return
     * @throws AdException
     */
    CreateUserResponse createUser (CreateUserRequest createUserRequest) throws AdException;
}
