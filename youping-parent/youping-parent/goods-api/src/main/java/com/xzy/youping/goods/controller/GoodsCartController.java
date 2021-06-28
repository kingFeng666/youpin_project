package com.xzy.youping.goods.controller;

import com.xzy.youping.entity.Response;
import com.xzy.youping.entity.ResponseCode;
import com.xzy.youping.goods.entity.Goods;
import com.xzy.youping.goods.entity.GoodsCart;
import com.xzy.youping.goods.mapper.GoodsCartMapper;
import com.xzy.youping.goods.service.GoodsCartService;
import com.xzy.youping.goods.service.GoodsService;
import com.xzy.youping.mapper.UserMapper;
import com.xzy.youping.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "购物车模块")
@RestController
@RequestMapping("/cart")
public class GoodsCartController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsCartMapper goodsCartMapper;

    @Autowired
    private GoodsCartService goodsCartService;

    @ApiOperation("把商品添加到购物车")
    @PostMapping("/save/{goodsId}/{count}")
    public Response save(HttpServletRequest request, @PathVariable String goodsId, @PathVariable Long count) throws Exception {
        Response response = new Response();
        try {
            //1. 解析请求对象中的token
            String userId = JwtUtils.getMemberIdByJwtToken(request);
            //2. 加入购物车
            //2.1 通过用户id获取用户名称
            String nickname = userMapper.selectById(userId).getNickname();
            Goods goods = goodsService.findById(goodsId);
            if (goods.getStock() <= 0) {
                response.code(ResponseCode.FAIL).msg("库存不足");
                return response;
            }
            //2.2 通过商品id获取商品标题
            String goodsTitle = goods.getTitle();
            GoodsCart goodsCart = new GoodsCart();
            goodsCart.setUId(userId);
            goodsCart.setUName(nickname);
            goodsCart.setGId(goodsId);
            goodsCart.setGTitle(goodsTitle);
            goodsCart.setGNumber(count);
            goodsCartMapper.insert(goodsCart);
        } catch (Exception e) {
            throw new Exception();
        }
        return response;
    }


    @ApiOperation("获取我的购物车的商品列表")
    @GetMapping("/list")
    public Response listByUserid(HttpServletRequest request) throws Exception {
        try {
            String userId = JwtUtils.getMemberIdByJwtToken(request);
            GoodsCart goodsCart = new GoodsCart();
            goodsCart.setUId(userId);
            goodsCart.setIsDelete(0);
            List<GoodsCart> goodsCartList = goodsCartService.listByGoodsCart(goodsCart);
            List<Goods> goodsList = new ArrayList<>();
            goodsCartList.forEach(gt -> {
                String goodsId = gt.getGId();
                Goods goods = goodsService.findById(goodsId);
                goodsList.add(goods);
            });

            Response response = new Response();
            response.data(goodsList);
            return response;
        } catch (Exception e) {
            throw new Exception();
        }
    }


    @ApiOperation("从我的购物车移除")
    @PostMapping("/remove/{goodsId}")
    public Response removeByGoodsIdAndUserId(HttpServletRequest httpServletRequest, @PathVariable String goodsId) throws Exception {

        try {
            String userId = JwtUtils.getMemberIdByJwtToken(httpServletRequest);
            //逻辑删除(标记删除)
            goodsCartService.updateStatusByUserIdAndGoodsId(1, userId, goodsId);
            Response response = new Response();
            return response;
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
