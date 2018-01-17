package com.ykly.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by huangmingjie on 2018/1/17.
 */
@Configuration
@ImportResource({"classpath:dubbo-consume.xml"})
public class DubboConfig {
}
