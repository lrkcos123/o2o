package com.lrk.o2o.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shop")
public class WorkBenchController {

    @GetMapping("workbench")
    public String workBench() {
        return "common/main";
    }
}