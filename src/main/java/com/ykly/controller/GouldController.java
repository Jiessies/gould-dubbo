package com.ykly.controller;

import com.ykly.entity.DistanceMeasurement;
import com.ykly.entity.ResMsg;
import com.ykly.service.GouldService;
import com.ykly.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by huangmingjie on 2018/1/17.
 */
@RestController
@RequestMapping("/gould")
@Api(value = "高德信息", description = "高德信息")
public class GouldController {
    private static final Logger logger = LoggerFactory.getLogger(GouldController.class);
    
    @Autowired
    private TestService testService;
    
    @Autowired
    @Qualifier(value = "gouldService")
    private GouldService gouldService;
    
    @Autowired
    @Qualifier(value = "gouldService2")
    private GouldService gouldService2;
    
    @GetMapping("/hello/{name}")
    public String index(@PathVariable String name) {
        String hello = gouldService.getString(name);
        logger.info(hello);
        return hello;
    }
    
    @GetMapping("/hello2/{name}")
    public String index2(@PathVariable String name) {
        String hello = gouldService2.getString(name);
        logger.info(hello);
        return hello;
    }
    
    @GetMapping("/test/{name}")
    public ResMsg test(@PathVariable String name) {
        return testService.getString(name);
    }
    
    @PostMapping(value = "/distance")
    @ApiOperation(value = "查询坐标点距离", notes = "查询坐标点距离")
    public ResMsg getDistanceMeasurement(@Valid DistanceMeasurement distanceMeasurement, BindingResult bindingResult) {
        return testService.getDistanceMeasurement(distanceMeasurement, bindingResult);
    }
}
