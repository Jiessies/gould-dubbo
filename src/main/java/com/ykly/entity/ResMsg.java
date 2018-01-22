package com.ykly.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResMsg<T> {

    private final static String SUCC_MSG = "succ";
    private final static String SUCC_CODE = "0";

    private String ret;
    private String sub;
    private String msg;
    private T data;

    public static ResMsg succ() {
        return ResMsg.builder().ret(ERetCode.OK.toString()).sub(SUCC_CODE).msg(SUCC_MSG).build();
    }

    public static ResMsg succWithData(Object data) {
        return ResMsg.builder().ret(ERetCode.OK.toString()).sub(SUCC_CODE).msg(SUCC_MSG).data(data).build();
    }

    public static ResMsg fail(ERetCode ret, String sub, String msg) {
        return ResMsg.builder().ret(ret.toString()).sub(sub).msg(msg).build();
    }

    public static ResMsg unknowWithMsg(String msg) {
        return ResMsg.builder().ret(ERetCode.UNKNOWN_ERROR.toString())
                .sub(StringUtils.EMPTY).msg(msg).build();
    }

}
