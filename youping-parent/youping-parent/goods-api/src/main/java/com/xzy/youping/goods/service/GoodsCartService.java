package com.xzy.youping.goods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xzy.youping.goods.entity.GoodsCart;
import com.xzy.youping.goods.mapper.GoodsCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCartService {

    @Autowired
    private GoodsCartMapper goodsCartMapper;

    public List<GoodsCart> listByGoodsCart(GoodsCart goodsCart) {
        QueryWrapper<GoodsCart> queryWrapper = new QueryWrapper<>(goodsCart);
        List<GoodsCart> goodsCartList = goodsCartMapper.selectList(queryWrapper);
        return goodsCartList;
    }


    public void updateStatusByUserIdAndGoodsId(Integer status, String userId, String goodsId) {
        GoodsCart goodsCart = new GoodsCart();
        goodsCart.setIsDelete(status);
        UpdateWrapper<GoodsCart> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("u_id", userId);
        updateWrapper.eq("g_id", goodsId);
        goodsCartMapper.update(goodsCart, updateWrapper);
    }
}
