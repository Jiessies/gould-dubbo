package com.ykly.controller;

import com.ykly.entity.DistanceMeasurement;
import com.ykly.entity.ParmData;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by huangmingjie on 2018/1/17.
 */
@RestController
@RequestMapping("/gould")
@Api(value = "高德信息", description = "高德信息")
@Validated
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
    
    @RequestMapping(value = "/get/{name}",method = RequestMethod.POST)
    public ResMsg getString(@RequestHeader(value = "X-Request-Id", required = false, defaultValue = "") String requestId,
                            @PathVariable String name,
                            @RequestParam(value = "userId", required = true) String userId,
                            @NotNull(message = "Required String parameter 'cinemaNo' is not present") String cinemaNo,
                            String cinemaLinkId) {
        logger.info(requestId + name + userId + cinemaNo + cinemaLinkId);
        return gouldService.getString(name);
    }
    
    @RequestMapping(value = "/get1/{name}",method = RequestMethod.POST)
    public ResMsg getString1(@RequestHeader(value = "X-Request-Id", required = false, defaultValue = "") String requestId,
                             @PathVariable String name,
                             @RequestParam(value = "userId") String userId,
                             String cinemaNo,
                             String cinemaLinkId) {
        logger.info(requestId + name + userId + cinemaNo + cinemaLinkId);
        return ResMsg.succWithData("succ");
    }
    
    @RequestMapping(value = "/get2", method = RequestMethod.POST, consumes = "multipart/form-data", params = "mykey=myvalue", headers = "Referer=http://www.ifeng.com/", produces = "application/json")
    public ResMsg getStrin2(ParmData parmData) {
        System.out.println(parmData);
        return ResMsg.succWithData(parmData);
    }
    
    @RequestMapping(value = "/get3", method = RequestMethod.POST, consumes = "multipart/form-data", params = "mykey=myvalue", headers = "Referer=http://www.ifeng.com/", produces = "application/json")
    public ResMsg getStrin3(String userId, String cinemaNo, String cinemaLinkId) {
        System.out.println(userId + cinemaNo + cinemaLinkId);
        return ResMsg.succWithData("succ");
    }
    
    @RequestMapping(value = "/get4", method = RequestMethod.POST, consumes = "multipart/form-data", params = "mykey=myvalue", headers = "Referer=http://www.ifeng.com/", produces = "application/json")
    public ResMsg getStrin4(String userId, String cinemaNo, String cinemaLinkId) {
        System.out.println(userId + cinemaNo + cinemaLinkId);
        return ResMsg.succWithData("succ");
    }
    
    //@RequestBody consumes 必须为 "application/json" params也用不了
    @RequestMapping(value = "/get5", method = RequestMethod.POST, consumes = "application/json", headers = "Referer=http://www.ifeng.com/", produces = "application/json")
    public ResMsg getStrin5(@RequestBody ParmData parmData) {
        System.out.println(parmData);
        return ResMsg.succWithData(parmData);
    }
    
    @GetMapping("/hello2/{name}")
    public ResMsg index2(@PathVariable String name) {
        return gouldService2.getString(name);
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
