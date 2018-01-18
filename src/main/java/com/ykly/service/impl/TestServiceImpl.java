package com.ykly.service.impl;

import com.ykly.annotation.LogAnalysis;
import com.ykly.entity.DistanceMeasurement;
import com.ykly.entity.ResMsg;
import com.ykly.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

/**
 * Created by huangmingjie on 2018/1/17.
 */
@Service
public class TestServiceImpl implements TestService{
    @Override
    @LogAnalysis
    public ResMsg getString(String name) {
        return ResMsg.succWithData(name);
    }
    
    @Override
    public ResMsg getDistanceMeasurement(DistanceMeasurement distanceMeasurement, BindingResult bindingResult) {
        return null;
    }
}
