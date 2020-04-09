package com.servlet;

import java.util.List;

/**
 * @author RecLusIve_F
 * @create --\
 */
public class ResponseInfo {
    private int status;
    private String responseMsg;
    private List<BookInfo> bookInfos;

    public ResponseInfo(int status, String responseMsg) {
        this.status = status;
        this.responseMsg = responseMsg;
    }

    public ResponseInfo(int status, List<BookInfo> bookInfos) {
        this.status = status;
        this.bookInfos = bookInfos;
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

    public List<BookInfo> getBookInfos() {
        return bookInfos;
    }

    public void setBookInfos(List<BookInfo> bookInfos) {
        this.bookInfos = bookInfos;
    }
}
