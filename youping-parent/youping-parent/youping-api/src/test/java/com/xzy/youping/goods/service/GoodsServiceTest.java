package com.xzy.youping.goods.service;

import com.xzy.youping.entity.PageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsServiceTest {

    @Autowired
    GoodsService goodsService;

    @Test
    public void testListByTitleWithNgram() {
        PageResponse pageResponse = goodsService.listByTitleWithNgram(1L, 5L, "oppo");
        System.out.println(pageResponse);
    }
}
