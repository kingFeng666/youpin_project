package com.xzy.youping.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Province implements Serializable {

    private static final long serialVersionUID = 814455085946578702L;

    /**
     * 省份id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 身份名称
     */
    private String name;

}
