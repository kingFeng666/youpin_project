package com.xzy.youping.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzy.youping.entity.Response;
import com.xzy.youping.entity.ResponseCode;
import com.xzy.youping.entity.User;
import com.xzy.youping.mapper.UserMapper;
import com.xzy.youping.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户模块")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("注册接口")
    @PostMapping("/regist")
    public Response regist(@RequestBody User user) {
        //对密码进行信息摘要加密(md5)
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.insert(user);
        Response response = new Response();
        response = response.code(ResponseCode.SUCCESS).msg("注册成功");
        return response;
    }

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public Response login(@RequestBody User user) {
        //把前台传递的数据中的密码进行加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        //使用Mybatis plus 提供的查询方法
        User respUser = userMapper.selectOne(queryWrapper);
        Response response = new Response();
        //org.freamWork提供的方法进行判空处理
        if (StringUtils.isEmpty(respUser)) {
            response.code(ResponseCode.FAIL).msg("登陆失败");
            return response;
        }
        String userId = respUser.getId();
        String jwtToken = JwtUtils.getJwtToken(userId);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwtToken);
        response.code(ResponseCode.SUCCESS).msg("登录成功").data(map);
        return response;
    }
}
