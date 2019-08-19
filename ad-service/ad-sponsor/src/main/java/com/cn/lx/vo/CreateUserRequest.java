package com.cn.lx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * @author StevenLu
 * @date 2019-08-19 22:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String userName;

    //判空
    public boolean validate(){
        return StringUtils.isEmpty(userName);
    }
}
