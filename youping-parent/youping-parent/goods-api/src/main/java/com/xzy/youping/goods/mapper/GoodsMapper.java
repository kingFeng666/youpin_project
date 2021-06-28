package com.xzy.youping.goods.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzy.youping.goods.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    List<Goods> listByTitleWithNgam(@Param("start") Long start, @Param("size") Long size, @Param("title") String title);

    Long totalByTitleWithNgam(@Param("title") String title);
}
