package com.yo.news.open.sdk.Exception;


/**
 * Author:JAN
 * Date:14:26 2018-5-15
 * Note:
 **/
public class ClientException extends RuntimeException {

    private String requestId;
    private String errCode;
    private String errMsg;

    public ClientException(String errCode, String errMsg, String requestId) {
        this(errCode, errMsg);
        this.requestId = requestId;
    }

    public ClientException(String errCode, String errMsg) {
        super(errCode + " : " + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;

    }

    public ClientException(String message) {
        super(message);
    }

    public ClientException(Throwable cause) {
        super(cause);
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }


    public String getMessage() {
        return super.getMessage() + (null == this.getRequestId() ? "" : "\r\nRequestId : " + this.getRequestId());
    }
}
