package com.xzy.youping.goods.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class GoodsCategory implements Serializable {

    private static final long serialVersionUID = 4821337513304942068L;

    /**
     * 商品类别id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 类别标题
     */
    private String title;

    /**
     * 类别描述
     */
    private String descp;

}
