package com.cn.lx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author StevenLu
 * @date 2019-08-24 21:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreativeUnitRequest {

    List<CreativeUniItem> creativeUniItems;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreativeUniItem{

        private Long creativeId;
        private Long unitId;
    }
}
