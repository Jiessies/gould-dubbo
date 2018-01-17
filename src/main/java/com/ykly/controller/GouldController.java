package com.ykly.controller;

import com.ykly.service.GouldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(GouldController.class);
    
    @Autowired
    private GouldService gouldService;
    
    @GetMapping("/hello")
    public String index() {
        String hello = gouldService.getString();
        logger.info(hello);
        return hello;
    }
}
