package com.cn.lx.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author StevenLu
 * @date 2019-08-27 23:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlan {

    private Long id;
    private Long userId;
    private String planName;
    private Integer planStatus;
    private Date startDate;
    private Date endDate;
    private Date createTime;
    private Date updateTime;
}
