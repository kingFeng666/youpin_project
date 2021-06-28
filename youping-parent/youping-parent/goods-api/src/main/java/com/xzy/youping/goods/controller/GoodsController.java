package com.xzy.youping.goods.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xzy.youping.entity.PageResponse;
import com.xzy.youping.entity.Response;
import com.xzy.youping.entity.ResponseCode;
import com.xzy.youping.goods.entity.Goods;
import com.xzy.youping.goods.mapper.GoodsMapper;
import com.xzy.youping.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Api(tags = "商品模块")
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsService goodsService;

    @ApiOperation("添加商品")
    @PostMapping("/save")
    public Response save(@RequestParam(value = "goodsImage", required = false) MultipartFile multipartFile, Goods goods) throws IOException {
        Response response = goodsService.save(multipartFile, goods, goods.getSpecStrList());
        return response;
    }


    @ApiOperation("获取通过审批的商品列表")
    @GetMapping("/list/passed")
    public PageResponse listPassedGoods(Long current, Long size) {
        Goods goods = new Goods();
        goods.setStatus(1);
        PageResponse pageResponse = goodsService.listByGoods(current, size, goods);
        return pageResponse;
    }

    @ApiOperation("获取未通过的商品列表")
    @GetMapping("/list/refused")
    public PageResponse listRefusedGoods(Long current, Long size) {
        Goods goods = new Goods();
        goods.setStatus(2);
        PageResponse pageResponse = goodsService.listByGoods(current, size, goods);
        return pageResponse;
    }

    @ApiOperation("获取待审批的商品列表")
    @GetMapping("/list/wait")
    public PageResponse waitAllGoods(Long current, Long size) {
        Goods goods = new Goods();
        goods.setStatus(0);
        PageResponse pageResponse = goodsService.listByGoods(current, size, goods);
        return pageResponse;
    }

    @ApiOperation("获取全部的商品列表")
    @GetMapping("/list/all")
    public PageResponse listAllGoods(Long current, Long size) {
        PageResponse pageResponse = goodsService.listByGoods(current, size, null);
        return pageResponse;
    }

    @ApiOperation("部门领导通过商品审批")
    @PostMapping("/pass/{goodsId}")
    public Response pass(@PathVariable String goodsId) {
        Goods goods = new Goods();
        goods.setId(goodsId);
        goods.setStatus(1);
        goods.setGmtModify(new Date());
        goodsMapper.updateById(goods);
        Response response = new Response();
        response.code(ResponseCode.SUCCESS).msg("通过审批成功");
        return response;
    }

    /**
     * @param current
     * @param size
     * @param cid     商品的分类id
     * @return
     */
    @ApiOperation("根据商品分类的id查询所属分类的列表")
    @GetMapping("/category")
    public PageResponse listGoodsByCategory(Long current, Long size, String cid) {
        PageResponse pageResponse = goodsService.listGoodsByCategory(current, size, cid);
        return pageResponse;
    }


    @ApiOperation("根据商品id查询商品详情")
    @GetMapping("/detail/{goodsId}")
    public Response findById(@PathVariable("goodsId") String goodsId) {
        Goods goods = goodsService.findById(goodsId);
        Response response = new Response();
        response.code(ResponseCode.SUCCESS).msg("成功").data(goods);
        return response;
    }


    @ApiOperation("根据商品标题搜索商品列表")
    @GetMapping("/title/search")
    public PageResponse listByTitleWithNgram(Long current, Long size, String title) {
        return goodsService.listByTitleWithNgram(current, size, title);
    }

    @ApiOperation("根据商品id修改商品信息")
    @PostMapping("/modify/{goodsId}")
    public Response modifyById(@PathVariable String goodsId, @RequestBody Goods goods) {
        goods.setId(goodsId);
        goods.setGmtModify(new Date());
        goodsMapper.updateById(goods);
        Response response = new Response();
        response.code(ResponseCode.SUCCESS).msg("成功");
        return response;
    }


    @ApiOperation("使用商品id删除商品")
    @PostMapping("/delete/{goodsId}")
    public Response removeById(@PathVariable String goodsId) {
        goodsMapper.deleteById(goodsId);
        Response response = new Response();
        return response;
    }

}
