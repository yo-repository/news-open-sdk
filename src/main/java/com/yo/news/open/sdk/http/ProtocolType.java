package com.yo.news.open.sdk.http;

/**
 * Author:JAN
 * Date:18:03 2018-5-15
 * Note:
 **/
public enum ProtocolType {
    HTTP("http"),
    HTTPS("https");

    private final String protocol;

    private ProtocolType(String protocol) {
        this.protocol = protocol;
    }

    public String toString() {
        return this.protocol;
    }
}
