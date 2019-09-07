package com.lrk.o2o.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrk.o2o.entity.PersonInfo;
import com.lrk.o2o.mapper.PersonInfoMapper;
import com.lrk.o2o.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private PersonInfoMapper personInfoMapper;

    @Override
    public PersonInfo getPerson_info(PersonInfo personInfo) {

        QueryWrapper<PersonInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",personInfo.getUserId());
        return personInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public Integer sign(PersonInfo personInfo) {
        return personInfoMapper.insert(personInfo);
    }
}
