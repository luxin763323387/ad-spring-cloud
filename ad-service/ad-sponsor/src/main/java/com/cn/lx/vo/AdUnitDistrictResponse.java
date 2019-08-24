package com.cn.lx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author StevenLu
 * @date 2019-08-24 15:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitDistrictResponse {

    private List<Long> ids;
}
