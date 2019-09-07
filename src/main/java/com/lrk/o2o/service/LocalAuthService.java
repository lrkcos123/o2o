package com.lrk.o2o.service;

import com.lrk.o2o.entity.LocalAuth;

public interface LocalAuthService {
    LocalAuth login(LocalAuth localAuth);

    LocalAuth getUserById(String username);

    void regist(LocalAuth localAuth);

}
