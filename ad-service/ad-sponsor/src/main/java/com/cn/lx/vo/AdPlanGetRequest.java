package com.cn.lx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author StevenLu
 * @date 2019-08-19 23:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanGetRequest {

    private Long userId;
    private List<Long> ids;

    //判空
    public boolean validate(){
        return userId != null && !CollectionUtils.isEmpty(ids);
    }
}
