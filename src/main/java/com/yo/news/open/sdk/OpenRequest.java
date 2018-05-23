package com.yo.news.open.sdk;


import com.yo.news.open.sdk.Signature.ISignerComposer;
import com.yo.news.open.sdk.Signature.Signer;
import com.yo.news.open.sdk.Signature.SignerComposer;
import com.yo.news.open.sdk.auth.ICredentials;
import com.yo.news.open.sdk.http.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Author:JAN
 * Date:18:00 2018-5-15
 * Note:
 **/
public abstract class OpenRequest<T extends ResponseModel> extends HttpRequest {
    private FormatType acceptFormat = FormatType.JSON;
    protected ISignerComposer composer = new SignerComposer();
    private final Map<String, String> queryParameters = new HashMap();
    private String requestUri;
    /**
     * json格式
     **/
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        this.putQueryParameter("data", data);
    }

    public OpenRequest(String requestUri, MethodType methodType, FormatType formatType) {

        if (requestUri == null || "".equals(requestUri)) {
            throw new RuntimeException("invalid requestUri");
        }
        this.requestUri = requestUri;
        if (methodType == null) {
            methodType = MethodType.GET;
        }
        super.setMethod(methodType);
        if (formatType == null) {
            formatType = FormatType.JSON;
        }
        this.setAcceptFormat(formatType);
    }

    public Map<String, String> getQueryParameters() {
        return Collections.unmodifiableMap(this.queryParameters);
    }

    protected void putQueryParameter(String name, String value) {
        if (null != queryParameters && null != name && null != value) {
            queryParameters.put(name, String.valueOf(value));
        }
    }

    public FormatType getAcceptFormat() {
        return this.acceptFormat;
    }

    public void setAcceptFormat(FormatType acceptFormat) {
        this.acceptFormat = acceptFormat;
        this.putHeaderParameter("Accept", FormatType.mapFormatToAccept(acceptFormat));
    }


    public HttpRequest signRequest(String hostName, Signer signer, ICredentials credentials) throws InvalidKeyException, IllegalStateException, UnsupportedEncodingException {
        Map<String, String> imutableMap = new HashMap(this.getQueryParameters());
        if (null != signer && null != credentials) {
            String accessKeyId = credentials.getAccessKeyId();
            String accessSecret = credentials.getAccessKeySecret();
            imutableMap = this.composer.refreshSignParameters(imutableMap, accessKeyId);
            String strToSign = this.composer.composeStringToSign(imutableMap, signer);
            String signature = signer.signString(strToSign, accessSecret);
            ((Map) imutableMap).put("signature", signature);
        }

        this.setUrl(this.composeUrl(hostName, imutableMap));
        return this;
    }

    public String composeUrl(String hostName, Map<String, String> queries) throws UnsupportedEncodingException {
        Map<String, String> mapQueries = queries == null ? this.getQueryParameters() : queries;
        StringBuilder urlBuilder = new StringBuilder(hostName);
        urlBuilder.append(requestUri);
        if (-1 == urlBuilder.indexOf("?")) {
            urlBuilder.append("?");
        }
        String query = concatQueryString(mapQueries);
        return urlBuilder.append(query).toString();
    }

    private String concatQueryString(Map<String, String> parameters) throws UnsupportedEncodingException {
        if (null == parameters) {
            return "";
        } else {
            StringBuilder urlBuilder = new StringBuilder("");
            for (Iterator iterator = parameters.entrySet().iterator(); iterator.hasNext(); urlBuilder.append("&")) {
                Map.Entry<String, String> entry = (Map.Entry) iterator.next();
                String key = entry.getKey();
                String val = entry.getValue();
                urlBuilder.append(URLEncoder.encode(key));
                if (val != null) {
                    urlBuilder.append("=").append(URLEncoder.encode(val));
                }
            }
            int strIndex = urlBuilder.length();
            if (parameters.size() > 0) {
                urlBuilder.deleteCharAt(strIndex - 1);
            }
            return urlBuilder.toString();
        }
    }

    public abstract Class<T> getResponseModelClass();


}
