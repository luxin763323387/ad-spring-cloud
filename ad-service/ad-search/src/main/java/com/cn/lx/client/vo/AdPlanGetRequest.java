package com.cn.lx.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author StevenLu
 * @date 2019-08-27 23:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanGetRequest {

    private Long userId;
    private List<Long> ids;
}
