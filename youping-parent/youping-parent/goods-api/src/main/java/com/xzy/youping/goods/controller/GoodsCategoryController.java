package com.xzy.youping.goods.controller;

import com.xzy.youping.entity.Response;
import com.xzy.youping.entity.ResponseCode;
import com.xzy.youping.goods.entity.GoodsCategory;
import com.xzy.youping.goods.mapper.GoodsCategoryMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品分类模块")
@RestController
@RequestMapping("/category")
public class GoodsCategoryController {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @ApiOperation("添加商品分类")
    @PostMapping("/save")
    public Response save(@RequestBody GoodsCategory goodsCategory) {
        goodsCategoryMapper.insert(goodsCategory);
        Response response = new Response();
        response.code(ResponseCode.SUCCESS).msg("成功");
        return response;
    }


    @ApiOperation("获取全部的分类列表")
    @GetMapping("/listAll")
    public Response listAll() {
        List<GoodsCategory> categoryList = goodsCategoryMapper.selectList(null);
        Response response = new Response();
        response.code(ResponseCode.SUCCESS).msg("成功").data(categoryList);
        return response;
    }

}
