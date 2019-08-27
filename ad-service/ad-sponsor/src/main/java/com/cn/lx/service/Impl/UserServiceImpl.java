package com.cn.lx.service.Impl;

import com.alibaba.fastjson.JSON;
import com.cn.lx.constant.Constants;
import com.cn.lx.dao.AdUserRepository;
import com.cn.lx.entity.AdUser;
import com.cn.lx.exception.AdException;
import com.cn.lx.service.IUserService;
import com.cn.lx.utils.CommonUtils;
import com.cn.lx.vo.CreateUserRequest;
import com.cn.lx.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author StevenLu
 * @date 2019-08-19 22:28
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private AdUserRepository adUserRepository;

    /**
     * 创建用户
     * @param createUserRequest
     * @return
     * @throws AdException
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) throws AdException {

        if(createUserRequest.validate()){
            log.error("用户名为空");
            throw new AdException(Constants.Errmsg.ERRORMSG);
        }
        log.info("创造用户日志:{}", JSON.toJSON(createUserRequest));
        AdUser oldUsername = adUserRepository.findByUsername(createUserRequest.getUserName());
        if(oldUsername != null){
            log.error("数据库中存在相同用户");
            throw new AdException(Constants.Errmsg.SAMENAME);
        }

        AdUser save = adUserRepository.save(new AdUser(
                createUserRequest.getUserName(), CommonUtils.getToken(createUserRequest.getUserName())
                ));

        return new CreateUserResponse(save.getId(),save.getUsername(),
                save.getToken(),new Date(),new Date());
    }
}
