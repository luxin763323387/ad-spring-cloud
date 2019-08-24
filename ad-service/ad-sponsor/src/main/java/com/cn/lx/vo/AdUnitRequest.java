package com.cn.lx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * 广告但单元
 *
 * @author StevenLu
 * @date 2019-08-24 09:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitRequest {

    private Long planId;
    private String unitName;

    /**
     * 广告贴片位置
     */
    private Integer positionType;

    /**
     *预算
     */
    private Long budget;


    public boolean createValidate(){
        return (planId != null && !StringUtils.isEmpty(unitName) &&
                positionType != null && budget != null);
    }

    public boolean updateValidate(){
        return (planId != null && !StringUtils.isEmpty(unitName));
    }

}
