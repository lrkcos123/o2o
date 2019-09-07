package com.lrk.o2o.service.impl;

import com.lrk.o2o.entity.LogLogin;
import com.lrk.o2o.mapper.LogLoginMapper;
import com.lrk.o2o.service.LogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogLoginServiceImpl implements LogLoginService {

    @Autowired
    private LogLoginMapper logLoginMapper;

    @Override
    public int addLog_login(LogLogin log_login) {
        return logLoginMapper.insert(log_login);
    }
}
