package com.xzy.youping.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class County  implements Serializable {

	private static final long serialVersionUID =  171086000549639066L;

	/**
	 * 县id
	 */
    @TableId(type = IdType.ID_WORKER_STR)
	private String id;

	/**
	 * 县名称
	 */
	private String name;

	/**
	 * 市区id
	 */
	private String cId;

}
