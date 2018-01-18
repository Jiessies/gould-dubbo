/**
 * Project Name:bis-dx
 * File Name:DxException.java
 * Package Name:com.wepiao.utils
 * Date:2016年11月25日下午3:25:24
 */

package com.ykly.entity;


public class SyncException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private ResMsg resMsg;

    public SyncException() {
        super();
    }

    public SyncException(ResMsg resMsg) {
        super(resMsg.getMsg());
        this.resMsg = resMsg;
    }

    public ResMsg getBisResponse() {
        return resMsg;
    }
}
