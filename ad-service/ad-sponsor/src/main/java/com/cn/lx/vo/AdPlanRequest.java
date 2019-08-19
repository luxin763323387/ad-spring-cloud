package com.cn.lx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * @author StevenLu
 * @date 2019-08-19 22:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanRequest {

    private Long id;
    private Long userId;
    private String planName;
    private String startDate;
    private String endDate;

    //创建判空
    public boolean createValidate(){
        return userId != null && !StringUtils.isEmpty(planName)
                && !StringUtils.isEmpty(startDate) && !StringUtils.isEmpty(endDate);
    }

    //更新判空
    public boolean updateValidate(){
        return id != null && userId != null;
    }

    //删除判空
    public boolean deleteValidate(){
        return id != null && userId != null;
    }
}
