package com.ykly.service;

import com.ykly.entity.DistanceMeasurement;
import com.ykly.entity.GeoCoding;
import com.ykly.entity.ResMsg;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

/**
 * Created by huangmingjie on 2018/1/17.
 */
@Service
public interface GouldService {
    ResMsg getDistanceMeasurement(DistanceMeasurement distanceMeasurement, BindingResult bindingResult);
    
    ResMsg getGeoCoding(GeoCoding geoCoding);
    
    String getString();
    
    String setRedis(String key, String value);
    
    String redisLock(String key, String value);
}
