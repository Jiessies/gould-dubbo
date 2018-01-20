package com.ykly.controller;

import com.ykly.entity.ResMsg;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Created by huangmingjie on 2018/1/20.
 */
@RestController
@Validated
@RequestMapping(value = "/test")
public class TestController {
    
    @RequestMapping(value = "/get6", method = RequestMethod.GET)
    public ResMsg getStrin6(@NotNull(message = "Required String parameter 'cinemaNo' is not present") String cinemaNo) {
        System.out.println(cinemaNo);
        return ResMsg.succWithData(cinemaNo);
    }
}
