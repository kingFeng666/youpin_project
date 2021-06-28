package com.xzy.youping.controller;

import com.xzy.youping.entity.Response;
import com.xzy.youping.entity.ResponseCode;
import com.xzy.youping.entity.vo.AddressVo;
import com.xzy.youping.service.AddressService;
import com.xzy.youping.utils.JwtUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "收货地址模块")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/save")
    public Response save(HttpServletRequest request, @RequestBody AddressVo addressVo) throws Exception {
        try {
            String userId = JwtUtils.getMemberIdByJwtToken(request);
            addressService.save(userId, addressVo.getProvinceId(), addressVo.getCityId(), addressVo.getCountyId(), addressVo.getDetail());
            Response response = new Response();
            response.code(ResponseCode.SUCCESS).msg("添加收货地址成功");
            return response;
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
