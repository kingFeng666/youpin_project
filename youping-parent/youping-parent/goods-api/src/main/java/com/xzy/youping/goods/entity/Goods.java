package com.xzy.youping.goods.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Goods implements Serializable {

    private static final long serialVersionUID = 8901979776178950643L;

    /**
     * 主键(商品id)
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品描述
     */
    private String descp;

    /**
     * 商品原价(分)
     */
    private Long originPrice;

    /**
     * 商品现价(分)
     */
    private Long currentPrice;

    /**
     * 商品图片地址
     */
    private String imageUrl;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 商品状态 0:待审批  1:以上架  2:已拒绝
     */
    private Integer status;

    /**
     * 商品分类id
     */
    private String cId;

    /**
     * 库存
     */
    private Long stock;

    /**
     * 商品创建时间
     */
    private Date gmtCreate;

    /**
     * 商品修改日期
     */
    private Date gmtModify;


    /**
     * 商品规格字符串
     */
    @TableField(exist = false)
    private List<String> specStrList;
}
