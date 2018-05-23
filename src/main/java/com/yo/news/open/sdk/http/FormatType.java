package com.yo.news.open.sdk.http;

import java.util.Arrays;

/**
 * Author:JAN
 * Date:13:59 2018-5-15
 * Note:
 **/
public enum FormatType {
    JSON(new String[]{"application/json", "text/json"}),
    XML(new String[]{"application/xml", "text/xml"}),
    RAW(new String[]{"application/octet-stream"}),
    FORM(new String[]{"application/x-www-form-urlencoded"});

    private String[] formats;

    FormatType(String[] formats) {
        this.formats = formats;
    }

    public static String mapFormatToAccept(FormatType format) {
        return format.formats[0];
    }

    public static FormatType mapAcceptToFormat(String accept) {
        FormatType[] values = values();
        int length = values.length;

        for (int i = 0; i < length; ++i) {
            FormatType value = values[i];
            if (Arrays.asList(value.formats).contains(accept)) {
                return value;
            }
        }

        return JSON;
    }
}
