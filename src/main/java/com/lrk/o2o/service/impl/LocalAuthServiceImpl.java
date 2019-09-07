package com.lrk.o2o.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrk.o2o.entity.LocalAuth;
import com.lrk.o2o.entity.PersonInfo;
import com.lrk.o2o.enums.Person_infoFlag;
import com.lrk.o2o.mapper.PersonInfoMapper;
import com.lrk.o2o.mapper.LocalAuthMapper;
import com.lrk.o2o.service.LocalAuthService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class LocalAuthServiceImpl implements LocalAuthService {
    @Autowired
    private LocalAuthMapper localauthMapper;
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Override
    public LocalAuth login(LocalAuth localAuth) {
        QueryWrapper<LocalAuth> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_name",localAuth.getUserName());
        String password=localAuth.getPassword();
        String newPwd= DigestUtils.md5DigestAsHex(password.getBytes());
        queryWrapper.eq("password",newPwd);
        return localauthMapper.selectOne(queryWrapper);
    }
//查询名字是否存在
    @Override
    public LocalAuth getUserById(String username) {
        QueryWrapper<LocalAuth> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_name",username);
        return localauthMapper.selectOne(queryWrapper);
    }
//注册获取person的userid
    @Override
    public void regist(LocalAuth localAuth) {
        PersonInfo personInfo=new PersonInfo();
        personInfo.setCustomerFlag(Person_infoFlag.CUSTOMER.getCode());
        personInfo.setShopOwnerFlag(Person_infoFlag.SHOPOWNER.getCode());
        personInfo.setAdminFlag(Person_infoFlag.ADMIN.getCode());

        personInfo.setCreateTime(new Date());

        personInfoMapper.insert(personInfo);
    }


}
