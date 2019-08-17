package com.cn.lx.dao;

import com.cn.lx.entity.Creative;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author StevenLu
 * @date 2019/7/21
 */
public interface CreativeRepository extends JpaRepository<Creative, Long> {
}
