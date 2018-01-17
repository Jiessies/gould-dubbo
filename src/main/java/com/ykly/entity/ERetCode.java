package com.ykly.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by hongwei on 2016/11/23.
 */
public enum ERetCode {
    
    CHECKOUT_FAILURE(1,"入参校验失败"),
    
    //请求正常
    OK(10000, "请求正常"),
    //开发者发起请求时，传入的key不正确或者过期
    INVALID_USER_KEY(10001, "key不正确或过期"),
    //1.开发者没有权限使用相应的服务，例如：开发者申请了WEB定位功能的key，却使用该key访问逆地理编码功能时，就会返回该错误。反之亦然。
    //2.开发者请求接口的路径拼写错误。例如：正确的http://restapi.amap.com/v3/ip在程序中被拼装写了http://restapi.amap.com/vv3/ip"
    SERVICE_NOT_AVAILABLE(10002, "没有权限使用相应的服务或者请求接口的路径拼写错误"),
    //开发者的日访问量超限，被系统自动封停，第二天0:00会自动解封
    DAILY_QUERY_OVER_LIMIT(10003, "访问已超出日访问量"),
    //开发者的单位时间内（1分钟）访问量超限，被系统自动封停，下一分钟自动解封。
    ACCESS_TOO_FREQUENT(10004, "单位时间内访问过于频繁"),
    //开发者在LBS官网控制台设置的IP白名单不正确。白名单中未添加对应服务器的出口IP。可到"控制台>配置"  中设定IP白名单。
    INVALID_USER_IP(10005, "IP白名单出错，发送请求的服务器IP不在IP白名单内"),
    //开发者绑定的域名无效，需要在官网控制台重新设置
    INVALID_USER_DOMAIN(10006, "绑定域名无效"),
    //开发者签名未通过开发者在key控制台中，开启了“数字签名”功能，但没有按照指定算法生成“数字签名”。
    INVALID_USER_SIGNATURE(10007, "数字签名未通过验证"),
    //需要开发者判定key绑定的SHA1,package是否与sdk包里的一致
    INVALID_USER_SCODE(10008, "MD5安全码未通过验证"),
    //请求中使用的key与绑定平台不符，例如：开发者申请的是js api的key，却用来调web服务接口
    USERKEY_PLAT_NOMATCH(10009, "请求key与绑定平台不符"),
    //未设定IP白名单的开发者使用key发起请求，从单个IP向服务器发送的请求次数超出限制，被系统自动封停。封停后无法自动恢复，需要提交工单联系我们。
    IP_QUERY_OVER_LIMIT(10010, "IP访问超限"),
    //服务不支持https请求，如果需要申请支持，请提交工单联系我们
    NOT_SUPPORT_HTTPS(10011, "服务不支持https请求"),
    //由于不具备请求该服务的权限，所以服务被拒绝。
    INSUFFICIENT_PRIVILEGES(10012, "权限不足，服务请求被拒绝"),
    //开发者删除了key，key被删除后无法正常使用
    USER_KEY_RECYCLED(10013, "Key被删除"),
    //QPS超出限制，超出部分的请求被拒绝。限流阈值内的请求依旧会正常返回
    QPS_HAS_EXCEEDED_THE_LIMIT(10014, "云图服务QPS超限"),
    //受单机QPS限流限制时出现该问题，建议降低请求的QPS或在控制台提工单联系我们
    GATEWAY_TIMEOUT(10015, "受单机QPS限流限制"),
    //服务器负载过高，请稍后再试
    SERVER_IS_BUSY(10016, "服务器负载过高"),
    //所请求的资源不可用
    RESOURCE_UNAVAILABLE(10017, "所请求的资源不可用"),
    //QPS超出限制，超出部分的请求被拒绝。限流阈值内的请求依旧会正常返回
    CQPS_HAS_EXCEEDED_THE_LIMIT(10019, "使用的某个服务总QPS超限"),
    CKQPS_HAS_EXCEEDED_THE_LIMIT(10020, "某个Key使用某个服务接口QPS超出限制"),
    CIQPS_HAS_EXCEEDED_THE_LIMIT(10021, "来自于同一IP的访问，使用某个服务QPS超出限制"),
    CIKQPS_HAS_EXCEEDED_THE_LIMIT(10022, "某个Key，来自于同一IP的访问，使用某个服务QPS超出限制"),
    KQPS_HAS_EXCEEDED_THE_LIMIT(10023, "某个KeyQPS超出限制"),
    //请求参数的值没有按照规范要求填写。例如，某参数值域范围为[1,3],开发者误填了’4’
    INVALID_PARAMS(20000, "请求参数非法"),
    //缺少接口中要求的必填参数
    MISSING_REQUIRED_PARAMS(20001, "缺少必填参数"),
    //请求协议非法比如某接口仅支持get请求，结果用了POST方式
    ILLEGAL_REQUEST(20002, "请求协议非法"),
    //其他未知错误
    UNKNOWN_ERROR(20003, "其他未知错误"),
    //使用路径规划服务接口时可能出现该问题，规划点（包括起点、终点、途经点）不在中国陆地范围内
    OUT_OF_SERVICE(20800, "规划点（包括起点、终点、途经点）不在中国陆地范围内"),
    //使用路径规划服务接口时可能出现该问题，划点（起点、终点、途经点）附近搜不到路
    NO_ROADS_NEARBY(20801, "划点（起点、终点、途经点）附近搜不到路"),
    //使用路径规划服务接口时可能出现该问题，路线计算失败，通常是由于道路连通关系导致
    ROUTE_FAIL(20802, "路线计算失败，通常是由于道路连通关系导致"),
    //使用路径规划服务接口时可能出现该问题，路线计算失败，通常是由于道路起点和终点距离过长导致。
    OVER_DIRECTION_RANGE(20803, "起点终点距离过长"),
    //出现3开头的错误码，建议先检查传入参数是否正确，若无法解决，请详细描述错误复现信息，提工单给我们。
    //如，30001、30002、30003、32000、32001、32002、32003、32200、32201、32202、32203。
    ENGINE_RESPONSE_DATA_ERROR(300, "服务响应失败");
    
    private final int value;
    private final String msg;
    
    ERetCode(int v, String m) {
        value = v;
        msg = m;
    }
    
    /**
     * @JsonCreator -> 反序列化
     */
    @JsonCreator
    public static ERetCode fromValue(int typeCode) {
        for (ERetCode retCode : ERetCode.values()) {
            if (retCode.toValue() == typeCode) {
                return retCode;
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
    
    public String toString() {
        return String.valueOf(value);
    }
    
}
