package com.cn.lx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author StevenLu
 * @date 2019-08-19 22:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {

    private Long userId;
    private String userName;
    private String token;
    private Date createTime;
    private Date updateTime;
}
