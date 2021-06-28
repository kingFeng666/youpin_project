package com.xzy.youping.goods.service.vo;

import lombok.Data;

@Data
public class OrderVo {
    private String goodsId;//商品id
    private String addrId;//地址id
    private Long buyNum;//购买数量
}
