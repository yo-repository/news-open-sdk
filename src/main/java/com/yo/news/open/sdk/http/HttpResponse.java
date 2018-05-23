package com.yo.news.open.sdk.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Author:JAN
 * Date:14:15 2018-5-15
 * Note:
 **/
public class HttpResponse extends HttpRequest {
    private int status;

    public HttpResponse(String strUrl) {

    }


    public void setHttpContent(byte[] content, String encoding, FormatType format) {
        this.httpContent = content;
        this.encoding = encoding;
        this.httpContentType = format;
    }

    public String getHeaderValue(String name) {
        String value = (String) this.headers.get(name);
        if (null == value) {
            value = (String) this.headers.get(name.toLowerCase());
        }

        return value;
    }

    /**
     * Author:JAN
     * Date:9:39 2018-5-16
     * Note:读取Http的InputStream中的内容
     **/
    private static byte[] readContent(InputStream content) throws IOException {
        if (content == null) {
            return null;
        } else {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];

            while (true) {
                int read = content.read(buff);
                if (read == -1) {
                    return outputStream.toByteArray();
                }
                outputStream.write(buff, 0, read);
            }
        }
    }

    private static void pasrseHttpConn(HttpResponse response, HttpURLConnection httpConn, InputStream content) throws IOException {
        byte[] buff = readContent(content);
        response.setStatus(httpConn.getResponseCode());
        Map<String, List<String>> headers = httpConn.getHeaderFields();
        Iterator iterator = headers.entrySet().iterator();

        while (true) {
            Map.Entry entry;
            String key;
            do {
                if (!iterator.hasNext()) {
                    String type = response.getHeaderValue("Content-Type");
                    if (null != buff && null != type) {
                        response.setEncoding("UTF-8");
                        String[] split = type.split(";");
                        response.setHttpContentType(FormatType.mapAcceptToFormat(split[0].trim()));
                        if (split.length > 1 && split[1].contains("=")) {
                            String[] codings = split[1].split("=");
                            response.setEncoding(codings[1].trim().toUpperCase());
                        }
                    }

                    response.setStatus(httpConn.getResponseCode());
                    response.setHttpContent(buff, response.getEncoding(), response.getHttpContentType());
                    return;
                }

                entry = (Map.Entry) iterator.next();
                key = (String) entry.getKey();
            } while (null == key);

            List<String> values = (List) entry.getValue();
            StringBuilder builder = new StringBuilder((String) values.get(0));

            for (int i = 1; i < values.size(); ++i) {
                builder.append(",");
                builder.append(values.get(i));
            }

            response.putHeaderParameter(key, builder.toString());
        }
    }

    public static HttpResponse getResponse(HttpRequest request) throws IOException {
        OutputStream out = null;
        InputStream content = null;

        HttpURLConnection httpConn = request.buildHttpConnection();
        HttpResponse httpResponse;
        try {
            httpConn.connect();
            if (null != request.getHttpContent() && request.getHttpContent().length > 0) {
                out = httpConn.getOutputStream();
                out.write(request.getHttpContent());
            }
            content = httpConn.getInputStream();
            httpResponse = new HttpResponse(httpConn.getURL().toString());
            pasrseHttpConn(httpResponse, httpConn, content);
            return httpResponse;
        } catch (IOException var10) {
            content = httpConn.getErrorStream();
            httpResponse = new HttpResponse(httpConn.getURL().toString());
            pasrseHttpConn(httpResponse, httpConn, content);

        } finally {
            if (content != null) {
                content.close();
            }
            httpConn.disconnect();
        }
        return httpResponse;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return 200 <= this.status && 300 > this.status;
    }
}
