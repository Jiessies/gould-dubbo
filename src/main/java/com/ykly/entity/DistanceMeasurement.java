package com.ykly.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by huangmingjie on 2017/12/2.
 */
@ApiModel("距离测量入参类")
public class DistanceMeasurement {
    
    @ApiModelProperty("请求服务权限标识")
    private String key;
    
    @NotBlank(message = "出发点不能为空")
    @ApiModelProperty("出发点")
    private String origins;
    
    @NotBlank(message = "目的地不能为空")
    @ApiModelProperty("目的地")
    private String destination;
    
    @ApiModelProperty("路径计算的方式和方法")
    private int type = 1;
    
    @ApiModelProperty("数字签名")
    private String sig;
    
    @ApiModelProperty("返回数据格式类型")
    private String output;
    
    @ApiModelProperty("回调函数")
    private String callback;
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getOrigins() {
        return origins;
    }
    
    public void setOrigins(String origins) {
        this.origins = origins;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public String getSig() {
        return sig;
    }
    
    public void setSig(String sig) {
        this.sig = sig;
    }
    
    public String getOutput() {
        return output;
    }
    
    public void setOutput(String output) {
        this.output = output;
    }
    
    public String getCallback() {
        return callback;
    }
    
    public void setCallback(String callback) {
        this.callback = callback;
    }
}
