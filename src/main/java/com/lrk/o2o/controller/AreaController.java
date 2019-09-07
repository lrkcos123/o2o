package com.lrk.o2o.controller;

import com.lrk.o2o.entity.Area;
import com.lrk.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("shop/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping("list")
    @ResponseBody
    public Object getAreas(){
        List<Area> areas=areaService.getAreas();
        return areas;
    }
}
