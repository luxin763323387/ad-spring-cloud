package com.cn.lx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author StevenLu
 * @date 2019-08-24 21:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreativeUnitResponse {

    private List<Long> ids;
}
