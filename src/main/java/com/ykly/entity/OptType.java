package com.ykly.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by huangmingjie on 2017/10/17.
 */
public enum OptType {
    IF_FlightQuery(1, "国内航班查询"),
    IF_BackChangeQuery(2, "退改签查询"),
    IF_OneWayTicketInquiry(3, "单程特价机票查询"),
    IF_ShengpiziQuery(4, "生僻字查询"),
    IF_TicketDetails(5, "机票详情"),
    IF_StopOver(6, "经停"),
    IF_CreateTicketOrder(7, "创建机票订单"),
    IF_CancellationOfOrder(8, "订单取消"),
    IF_SubmitOrder(9, "出票"),
    IF_QueryRefundFee(10, "退票费查询"),
    IF_RefundOrder(11, "退票"),
    OF_FlightQuery(20, "国际航班查询"),
    
    GOULD_GEO_CODING(30, "地理编码"),
    GOULD_DISTANCE_MEASUREMENT(31, "距离测量");
    
    
    private final int value;
    private final String msg;
    
    OptType(int v, String m) {
        value = v;
        msg = m;
    }
    
    /**
     * @param typeCode
     * @return
     * @JsonCreator -> 反序列化
     */
    @JsonCreator
    public static OptType fromValue(int typeCode) {
        for (OptType optType : OptType.values()) {
            if (optType.toValue() == typeCode) {
                return optType;
            }
        }
        throw new IllegalArgumentException("Invalid type code: " + typeCode);
    }
    
    /**
     * @JsonValue -> 指定json序列化该值
     */
    @JsonValue
    public int toValue() {
        return value;
    }
    
    public String toMsg() {
        return msg;
    }
}
