package com.xzy.youping.goods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzy.youping.entity.PageResponse;
import com.xzy.youping.entity.Response;
import com.xzy.youping.entity.ResponseCode;
import com.xzy.youping.goods.entity.Goods;
import com.xzy.youping.goods.entity.GoodsSpec;
import com.xzy.youping.goods.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;


    @Autowired
    private GoodsSpecService goodsSpecService;

    @Transactional
    public Response save(MultipartFile multipartFile, Goods goods, List<String> specStrList) throws IOException {
        //1. 添加商品
        //文件上传
        String originalFilename = multipartFile.getOriginalFilename();
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originalFilename;
        File toFile = new File("f:/upload");
        if (!toFile.exists()) {
            toFile.mkdirs();
        }
        multipartFile.transferTo(new File(toFile.getPath() + "/" + fileName));
        goods.setImageUrl(fileName);
        goodsMapper.insert(goods);
        //2. 添加商品规格
        specStrList.forEach(specStr -> {
            GoodsSpec goodsSpec = new GoodsSpec();
            goodsSpec.setGId(goods.getId());
            goodsSpec.setGTitle(goods.getTitle());
            goodsSpec.setTitle(specStr);
            goodsSpecService.save(goodsSpec);
        });

        Response response = new Response();
        response.code(ResponseCode.SUCCESS).msg("添加商品成功");
        return response;
    }


    public PageResponse listByGoods(Long current, Long size, Goods goods) {
        IPage<Goods> page = new Page<>(current, size);
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>(goods);
        page = goodsMapper.selectPage(page, queryWrapper);
        PageResponse pageResponse = new PageResponse();
        pageResponse.code(ResponseCode.SUCCESS).msg("成功");
        pageResponse.current(current).size(size).total(page.getTotal()).data(page.getRecords());
        return pageResponse;
    }

    public PageResponse listGoodsByCategory(Long current, Long size, String cid) {
        IPage<Goods> iPage = new Page<>(current, size);

        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c_id", cid);
        iPage = goodsMapper.selectPage(iPage, queryWrapper);
        PageResponse pageResponse = new PageResponse();
        pageResponse.code(ResponseCode.SUCCESS).msg("成功");
        pageResponse.current(current).size(size).total(iPage.getTotal()).data(iPage.getRecords());
        return pageResponse;
    }
    public Goods findById(String goodsId) {
        Goods goods = goodsMapper.selectById(goodsId);
        return goods;
    }


    /**
     * @param current
     * @param size
     * @param title   商品标题
     * @return
     */
    public PageResponse listByTitleWithNgram(Long current, Long size, String title) {
        Long start = (current - 1) * size;
        List<Goods> goodsList = goodsMapper.listByTitleWithNgam(start, size, title);
        Long total = goodsMapper.totalByTitleWithNgam(title);

        PageResponse pageResponse = new PageResponse();
        pageResponse.code(ResponseCode.SUCCESS).msg("成功").data(goodsList);
        pageResponse.current(current).size(size).total(total);
        return pageResponse;
    }
    /**
     * @param title 商品标题
     * @return
     */
    public Long totalByTitleWithNgram(String title) {
        Long total = goodsMapper.totalByTitleWithNgam(title);
        return total;
    }
}
