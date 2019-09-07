package com.lrk.o2o.service;

import com.lrk.o2o.entity.PersonInfo;

public interface PersonInfoService {

    PersonInfo getPerson_info(PersonInfo personInfo);

    Integer sign(PersonInfo personInfo);
}
