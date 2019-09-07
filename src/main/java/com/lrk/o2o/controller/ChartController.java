package com.lrk.o2o.controller;

import com.lrk.o2o.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("shop/chart")
public class ChartController {
    @Autowired
    private ChartService chartService;

    @GetMapping("top5.html")
    public String toTop5() {
        return "chart/top5";
    }

    @GetMapping("order.html")
    public String toOrder() {
        return "chart/order";
    }

    @GetMapping("money.html")
    public String toMoney() {
        return "chart/money";
    }

    @GetMapping("moneyByType.html")
    public String toMoneyByType() {
        return "chart/moneyByType";
    }

    @GetMapping("top5Product")
    @ResponseBody
    public Object getTop5Product(@RequestParam(value = "month",required = false)String month,
                                 @RequestParam(value = "startTime",required = false)String startTime,
                                 @RequestParam(value = "endTime",required = false)String endTime){
        Map<String,Object> map=new HashMap<>();
        map.put("month",month);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        List<Map<String,Object>> getTop5Product=chartService.getTop5Product(map);
        return getTop5Product;
    }

    @GetMapping("orderStatus")
    @ResponseBody
    public Object getOrderStatus(@RequestParam(value = "month",required = false)String month,
                                 @RequestParam(value = "startTime",required = false)String startTime,
                                 @RequestParam(value = "endTime",required = false)String endTime){
        Map<String,Object> map=new HashMap<>();
        map.put("month",month);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        Map<String,Object> getOrderStatus=chartService.getOrderStatus(map);
        return getOrderStatus;
    }

    @GetMapping("money")
    @ResponseBody
    public Object getMoney(@RequestParam(value = "month",required = false)String month,
                                 @RequestParam(value = "startTime",required = false)String startTime,
                                 @RequestParam(value = "endTime",required = false)String endTime){
        Map<String,Object> map=new HashMap<>();
        map.put("month",month);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        List<Map<String,Object>> getMoney=chartService.getMoney(map);
        return getMoney;
    }

    @GetMapping("moneyByType")
    @ResponseBody
    public Object getMoneyByType(@RequestParam(value = "year",required = false)String year,
                                 @RequestParam(value = "startTime",required = false)String startTime,
                                 @RequestParam(value = "endTime",required = false)String endTime){
        Map<String,Object> map=new HashMap<>();
        map.put("year",year);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        List<Map<String,Object>> moneyByType=chartService.getMoneyByType(map);
        return moneyByType;
    }
}
