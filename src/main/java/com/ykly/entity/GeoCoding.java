package com.ykly.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by huangmingjie on 2017/12/4.
 */
@ApiModel("地理编码入参类")
public class GeoCoding {
    @ApiModelProperty("请求服务权限标识")
    private String key;
    
    @ApiModelProperty("结构化地址信息")
    private String address;
    
    @ApiModelProperty("指定查询的城市")
    private String city;
    
    @ApiModelProperty("批量查询控制")
    private String batch = "false";
    
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
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getBatch() {
        return batch;
    }
    
    public void setBatch(String batch) {
        this.batch = batch;
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
