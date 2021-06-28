package com.xzy.youping.goods.service;

import com.xzy.youping.goods.entity.GoodsSpec;
import com.xzy.youping.goods.mapper.GoodsSpecMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsSpecService {

    @Autowired
    private GoodsSpecMapper goodsSpecMapper;

    public Integer save(GoodsSpec goodsSpec) {
        return goodsSpecMapper.insert(goodsSpec);
    }


}
