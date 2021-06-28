package com.xzy.youping.service;

import com.xzy.youping.entity.*;
import com.xzy.youping.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CountyMapper countyMapper;

    @Transactional
    public void save(String userId, String pId, String cId, String coId, String detailAddress) {
        User user = userMapper.selectById(userId);

        Province province = provinceMapper.selectById(pId);
        City city = cityMapper.selectById(cId);
        County county = countyMapper.selectById(coId);


        Address address = new Address();
        address.setPId(pId);
        address.setPName(province.getName());

        address.setCId(cId);
        address.setCName(city.getName());

        address.setCoId(coId);
        address.setCoName(county.getName());

        address.setDetail(detailAddress);

        address.setUId(userId);
        address.setUName(user.getNickname());

        addressMapper.insert(address);
    }

}
