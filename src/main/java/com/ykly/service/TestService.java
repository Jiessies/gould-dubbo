package com.ykly.service;

import com.ykly.entity.DistanceMeasurement;
import com.ykly.entity.ResMsg;
import org.springframework.validation.BindingResult;

/**
 * Created by huangmingjie on 2018/1/17.
 */
public interface TestService {
    ResMsg getString(String name);
    
    ResMsg getDistanceMeasurement(DistanceMeasurement distanceMeasurement, BindingResult bindingResult);
}
