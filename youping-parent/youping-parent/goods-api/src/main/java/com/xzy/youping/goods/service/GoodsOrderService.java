package com.xzy.youping.goods.service;

import com.xzy.youping.entity.User;
import com.xzy.youping.goods.entity.Goods;
import com.xzy.youping.goods.entity.GoodsOrder;
import com.xzy.youping.goods.mapper.GoodsOrderMapper;
import com.xzy.youping.goods.service.vo.OrderVo;
import com.xzy.youping.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsOrderService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    GoodsService goodsService;


    @Autowired
    private GoodsCartService goodsCartService;

    @Autowired
    GoodsOrderMapper goodsOrderMapper;

    /**
     * 保存订单
     *
     * @param orderVo
     * @return
     */
    @Transactional
    public Long save(String userId, OrderVo orderVo) throws Exception {
        //1. 根据用户id查询用户的信息
        User user = userMapper.selectById(userId);

        //2.根据商品id查询商品详细信息
        Goods goods = goodsService.findById(orderVo.getGoodsId());

        if (goods.getStock() < orderVo.getBuyNum()) {
            throw new Exception(goods.getTitle() + "  库存不足");
        }

        GoodsOrder goodsOrder = new GoodsOrder();
        goodsOrder.setUId(userId);
        goodsOrder.setUName(user.getNickname());

        goodsOrder.setGId(orderVo.getGoodsId());
        goodsOrder.setGTitle(goods.getTitle());
        goodsOrder.setCurrentPrice(goods.getCurrentPrice());

        goodsOrder.setAddrId(orderVo.getAddrId());
        goodsOrder.setBuyNumber(orderVo.getBuyNum());
        goodsOrder.setStatus(0);
        goodsOrder.setTotalPrice(orderVo.getBuyNum() * goods.getCurrentPrice());
        //3. 删除购物车中的商品(逻辑删除)
        goodsCartService.updateStatusByUserIdAndGoodsId(1, user.getId(), goods.getId());
        //5. 给订单表写数据
        goodsOrderMapper.insert(goodsOrder);
        return goodsOrder.getTotalPrice();
    }
}
