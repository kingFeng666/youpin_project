package com.xzy.youping.goods.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class GoodsOrder implements Serializable {

    private static final long serialVersionUID = 4845157896670290863L;

    /**
     * 订单id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 用户id
     */
    private String uId;

    /**
     * 用户名
     */
    private String uName;

    /**
     * 商品id
     */
    private String gId;

    /**
     * 商品标题
     */
    private String gTitle;

    /**
     * 收货地址id
     */
    private String addrId;

    /**
     * 购买数量
     */
    private Long buyNumber;

    /**
     * 商品单价
     */
    private Long currentPrice;

    /**
     * 订单总价
     */
    private Long totalPrice;

    /**
     * 订单状态  0:未支付  1:已支付
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModify;

}
