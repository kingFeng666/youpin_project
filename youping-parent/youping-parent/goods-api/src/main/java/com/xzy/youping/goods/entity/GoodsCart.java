package com.xzy.youping.goods.entity;

import java.io.Serializable;
import lombok.Data;
import java.util.Date;

@Data
public class GoodsCart  implements Serializable {

	private static final long serialVersionUID =  4453331429943102843L;

	/**
	 * 用户id
	 */
	private String uId;

	/**
	 * 用户昵称
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
	 * 加入购物车的商品数量
	 */
	private Long gNumber;

	/**
	 * 是否删除: 0: false  1:true
	 */
	private Integer isDelete;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModify;

}
