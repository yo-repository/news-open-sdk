package com.yo.news.open.sdk.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Author:JAN
 * Date:13:36 2018-5-15
 * Note:
 **/
public class HttpRequest {
    protected static final String CONTENT_TYPE = "Content-Type";
    protected static final String CONTENT_MD5 = "Content-MD5";
    protected static final String CONTENT_LENGTH = "Content-Length";
    protected static final String ACCEPT = "Accept";
    private String url = null;
    private MethodType method = MethodType.GET;
    protected FormatType httpContentType = null;
    protected byte[] httpContent = null;
    protected String encoding = "UTF-8";
    protected Map<String, String> headers = new HashMap();
    protected Integer connectTimeout = null;
    protected Integer readTimeout = null;


    public MethodType getMethod() {
        return this.method;
    }

    public void setMethod(MethodType method) {
        this.method = method;
    }

    public String getUrl() {
        return this.url;
    }

    protected void setUrl(String url) {
        this.url = url;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public FormatType getHttpContentType() {
        return this.httpContentType;
    }

    public void setHttpContentType(FormatType httpContentType) {
        this.httpContentType = httpContentType;
        if (null == this.httpContent && null == httpContentType) {
            this.headers.remove(CONTENT_TYPE);
        } else {
            this.headers.put(CONTENT_TYPE, this.getContentTypeValue(this.httpContentType, this.encoding));
        }
    }

    public byte[] getHttpContent() {
        return this.httpContent;
    }

    public String getHeaderValue(String name) {
        return (String) this.headers.get(name);
    }

    public Integer getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getReadTimeout() {
        return this.readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }

    public void putHeaderParameter(String name, String value) {
        if (null != name && null != value) {
            this.headers.put(name, value);
        }

    }

    public void setHttpContent(byte[] content, String encoding, FormatType format) {
        if (null == content) {
            this.headers.remove(CONTENT_MD5);
            this.headers.put(CONTENT_LENGTH, "0");
            this.headers.remove(CONTENT_TYPE);
            this.httpContentType = null;
            this.httpContent = null;
            this.encoding = null;
        } else {
            this.httpContent = content;
            this.encoding = encoding;
            String contentLen = String.valueOf(content.length);
            String strMd5 = ParameterHelper.md5Sum(content);
            if (null != format) {
                this.httpContentType = format;
            } else {
                this.httpContentType = FormatType.RAW;
            }
            this.headers.put(ACCEPT, FormatType.mapFormatToAccept(FormatType.JSON));
            this.headers.put(CONTENT_MD5, strMd5);
            this.headers.put(CONTENT_LENGTH, contentLen);
            this.headers.put(CONTENT_TYPE, this.getContentTypeValue(this.httpContentType, encoding));
        }
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.headers);
    }

    public HttpURLConnection buildHttpConnection() throws IOException {
        Map<String, String> mappedHeaders = this.headers;

        if (null == this.url) {
            throw new IllegalArgumentException("URL is null for HttpRequest.");
        }
        if (null == this.method) {
            throw new IllegalArgumentException("Method is not set for HttpRequest.");
        }
        URL httpURL = new URL(this.url);
        HttpURLConnection httpConn = (HttpURLConnection) httpURL.openConnection();
        httpConn.setRequestMethod(this.method.toString());
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        httpConn.setUseCaches(false);
        if (this.getConnectTimeout() != null) {
            httpConn.setConnectTimeout(this.getConnectTimeout());
        }
        if (this.getReadTimeout() != null) {
            httpConn.setReadTimeout(this.getReadTimeout());
        }
        Iterator itHeaders = mappedHeaders.entrySet().iterator();
        while (itHeaders.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) itHeaders.next();
            httpConn.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (null != this.getHeaderValue(CONTENT_TYPE)) {
            httpConn.setRequestProperty(CONTENT_TYPE, this.getHeaderValue(CONTENT_TYPE));
        } else {
            String contentTypeValue = this.getContentTypeValue(this.httpContentType, this.encoding);
            if (null != contentTypeValue) {
                httpConn.setRequestProperty(CONTENT_TYPE, contentTypeValue);
            }
        }
        return httpConn;
    }


    private String getContentTypeValue(FormatType contentType, String encoding) {
        if (null != contentType && null != encoding) {
            return FormatType.mapFormatToAccept(contentType) + ";charset=" + encoding.toLowerCase();
        } else {
            return null != contentType ? FormatType.mapFormatToAccept(contentType) : null;
        }
    }
}
