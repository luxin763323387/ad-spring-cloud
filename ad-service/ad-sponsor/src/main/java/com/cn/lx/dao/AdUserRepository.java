package com.cn.lx.dao;

import com.cn.lx.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author StevenLu
 * @date 2019/7/21
 */
public interface AdUserRepository extends JpaRepository<AdUser, Long> {

    /**
     * <h2>根据用户名查找用户记录</h2>
     * */
    AdUser findByUsername(String username);
}
