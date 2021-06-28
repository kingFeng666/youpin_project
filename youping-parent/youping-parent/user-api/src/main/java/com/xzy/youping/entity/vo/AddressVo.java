package com.xzy.youping.entity.vo;

import lombok.Data;

@Data
public class AddressVo {
    private String provinceId;//省份id
    private String cityId;//市id
    private String countyId;//县区id
    private String detail;//详情街道信息
}
