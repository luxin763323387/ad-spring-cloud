package com.cn.lx.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author StevenLu
 * @date 2019/7/21
 */
@Getter
@AllArgsConstructor
public enum CommonStatus {

    VALID(1,"有效状态"),
    INVALID(0,"无效状态")
    ;

    private Integer status;
    private String message;

}
