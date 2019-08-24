package com.cn.lx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author StevenLu
 * @date 2019-08-24 14:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitKeywordRequest {

    private List<UnitKeyword> unitKeywords;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UnitKeyword{

        private Long unitId;
        private String keyword;
    }
}
