package com.xzy.youping.goods.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class GoodsSpec implements Serializable {

    private static final long serialVersionUID = 7208755066499515154L;

    /**
     * 商品规格id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 规格名称
     */
    private String title;

    /**
     * 商品id
     */
    private String gId;

    /**
     * 商品标题
     */
    private String gTitle;

}
