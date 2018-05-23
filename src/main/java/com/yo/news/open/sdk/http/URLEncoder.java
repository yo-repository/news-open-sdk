package com.yo.news.open.sdk.http;

import java.io.UnsupportedEncodingException;

/**
 * Author:JAN
 * Date:11:06 2018-5-21
 * Note:
 **/
public class URLEncoder {
    public static final String URL_ENCODING = "UTF-8";

    public URLEncoder() {
    }
    public static String encode(String value) throws UnsupportedEncodingException {
        return java.net.URLEncoder.encode(value, URL_ENCODING);
    }
    public static String percentEncode(String value) throws UnsupportedEncodingException {
        return value != null ? java.net.URLEncoder.encode(value, URL_ENCODING).replace("+", "%20").replace("*", "%2A").replace("%7E", "~") : null;
    }
}
