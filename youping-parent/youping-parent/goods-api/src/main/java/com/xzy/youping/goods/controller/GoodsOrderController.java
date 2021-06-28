package com.xzy.youping.goods.controller;

import com.xzy.youping.entity.Response;
import com.xzy.youping.entity.ResponseCode;
import com.xzy.youping.goods.service.GoodsOrderService;
import com.xzy.youping.goods.service.vo.OrderVo;
import com.xzy.youping.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "订单模块")
@RestController
@RequestMapping("/order")
public class GoodsOrderController {

    @Autowired
    GoodsOrderService goodsOrderService;

    @ApiOperation("创建订单模块")
    @PostMapping("/save")
    public Response save(HttpServletRequest request, @RequestBody List<OrderVo> orderVoList) throws Exception {
        try {
            String userId = JwtUtils.getMemberIdByJwtToken(request);
            Long allTotalPrice = 0L;
            for (OrderVo orderVo : orderVoList) {
                allTotalPrice += goodsOrderService.save(userId, orderVo);
            }
            Map<String, Long> mapData = new HashMap<>();
            mapData.put("allTotalPrice", allTotalPrice);
            Response response = new Response();
            response.code(ResponseCode.SUCCESS).msg("订单创建成功").data(mapData);
            return response;
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
