
package com.servlet;

/**
 * @author RecLusIve_F
 * @create --\
 */
public class ResponseInfo {
    private int status;
    private String responseMsg;

    public ResponseInfo(int status, String responseMsg) {
        this.status = status;
        this.responseMsg = responseMsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
