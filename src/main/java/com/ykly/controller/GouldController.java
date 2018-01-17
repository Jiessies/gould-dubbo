package com.ykly.controller;

import com.ykly.service.GouldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangmingjie on 2018/1/17.
 */
@RestController
@RequestMapping("/gould")
public class GouldController {
    
    @Autowired
    private GouldService gouldService;
    
    @GetMapping("/hello")
    public String index() {
        String hello = gouldService.getString();
        return hello;
    }
}
