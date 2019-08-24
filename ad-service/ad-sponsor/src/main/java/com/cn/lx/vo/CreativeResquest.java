package com.cn.lx.vo;

import com.cn.lx.constant.CommonStatus;
import com.cn.lx.entity.Creative;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author StevenLu
 * @date 2019-08-24 20:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreativeResquest {

    /**
     *创意名字
     */
    private String name;

    /**
     *创意类型
     */
    private Integer type;

    /**
     *物料的类型, 比如图片可以是 bmp, jpg等等
     */
    private Integer materialType;

    /**
     *高度
     */
    private Integer height;

    /**
     *宽度
     */
    private Integer width;

    /**
     *物料大小
     */
    private Long size;

    /**
     *持续时长, 只有视频不为0
     */
    private Integer duration;

    /**
     *使用者id
     */
    private Long userId;

    /**
     *地址
     */
    private String url;


    public Creative convertToEntity(){

        Creative creative = new Creative();
        creative.setName(name);
        creative.setType(type);
        creative.setMaterialType(materialType);
        creative.setHeight(height);
        creative.setWidth(width);
        creative.setSize(size);
        creative.setDuration(duration);
        creative.setAuditStatus(CommonStatus.VALID.getStatus());
        creative.setUserId(userId);
        creative.setUrl(url);
        return creative;
    }
}
