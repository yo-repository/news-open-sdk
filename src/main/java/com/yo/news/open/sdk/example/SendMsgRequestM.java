package com.yo.news.open.sdk.example;

import java.util.List;

/**
 * Author:JAN
 * Date:16:13 2018-5-24
 * Note:
 **/
public class SendMsgRequestM {
    private String fromLoginId;
    private List<String> toLoginIds;
    private boolean bNofity;
    private String msgContent;


    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public List<String> getToLoginIds() {
        return toLoginIds;
    }

    public void setToLoginIds(List<String> toLoginIds) {
        this.toLoginIds = toLoginIds;
    }

    public String getFromLoginId() {
        return fromLoginId;
    }

    public void setFromLoginId(String fromLoginId) {
        this.fromLoginId = fromLoginId;
    }

    public boolean isbNofity() {
        return bNofity;
    }

    public void setbNofity(boolean bNofity) {
        this.bNofity = bNofity;
    }
}
