package com.yo.news.open.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.yo.news.open.sdk.Exception.ClientException;
import com.yo.news.open.sdk.Signature.HmacSHA1Signer;
import com.yo.news.open.sdk.Signature.Signer;
import com.yo.news.open.sdk.auth.ICredentials;
import com.yo.news.open.sdk.http.HttpRequest;
import com.yo.news.open.sdk.http.HttpResponse;
import com.yo.news.open.sdk.http.ResponseModel;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.security.InvalidKeyException;

/**
 * Author:JAN
 * Date:13:33 2018-5-15
 * Note:
 **/
public class OpenClient {
    private static String HOST_DOMAIN = "https://open.baoxinwen.com";
    ICredentials iCredentials;
    protected Signer signer = new HmacSHA1Signer();
    static Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public OpenClient(ICredentials iCredentials) {

        this.iCredentials = iCredentials;
    }

    /**
     * Author:JAN
     * Date:14:34 2018-5-30
     * Note: domain like https://open.baoxinwen.com
     **/
    public OpenClient(String hostDomain, ICredentials iCredentials) {
        if (hostDomain != null && "".equals(hostDomain) == false) {
            if (hostDomain.startsWith("http://") == false && hostDomain.startsWith("https://") == false) {
                throw new RuntimeException("hostDomain must start with http:// or https://");
            }
            HOST_DOMAIN = hostDomain;
        }

        this.iCredentials = iCredentials;
    }


    public <T extends ResponseModel> T doRequest(OpenRequest<T> request, boolean autoRetry, int maxRetryCounts) throws ClientException {
        HttpResponse httpResponse = this.doAction(request, iCredentials, autoRetry, maxRetryCounts);
        System.out.println(httpResponse.getUrl());
        if (request.getResponseModelClass() == null) {
            throw new RuntimeException("ResponseModelClass of OpenRequest required");
        }
        return getResponse(httpResponse, request.getResponseModelClass());
    }

    public <T extends ResponseModel> String doRequest4Body(OpenRequest<T> request, boolean autoRetry, int maxRetryCounts) throws ClientException {
        HttpResponse httpResponse = this.doAction(request, iCredentials, autoRetry, maxRetryCounts);
        System.out.println(httpResponse.getUrl());
        return this.getResponseContent(httpResponse);
    }

    private <T extends ResponseModel> T getResponse(HttpResponse httpResponse, Class<T> clasz) {
        String responseContent = this.getResponseContent(httpResponse);
        try {

            T t = gson.fromJson(responseContent, clasz);
            return t;
        } catch (Exception ex) {
            throw new RuntimeException("response Content is " + responseContent);
        }

    }

    private HttpResponse doAction(OpenRequest request, ICredentials credentials, boolean autoRetry, int maxRetryNumber) throws ClientException {
        try {
            boolean shouldRetry = true;
            for (int retryTimes = 0; shouldRetry; ++retryTimes) {
                shouldRetry = autoRetry && retryTimes < maxRetryNumber;
                HttpRequest httpRequest = request.signRequest(HOST_DOMAIN, signer, credentials);
                HttpResponse response = HttpResponse.getResponse(httpRequest);
                if (response.getHttpContent() == null) {
                    if (!shouldRetry) {
                        throw new ClientException("SDK.ConnectionReset", "Connection reset.");
                    }
                } else if (500 > response.getStatus() || !shouldRetry) {
                    return response;
                }
            }

        } catch (InvalidKeyException keyException) {
            throw new ClientException("SDK.InvalidAccessSecret", "Speicified access secret is not valid.");
        } catch (SocketTimeoutException socketTimeOutException) {
            throw new ClientException("SDK.ServerUnreachable", "SocketTimeoutException has occurred on a socket read or accept.");
        } catch (IOException iOException) {
            throw new ClientException("SDK.ServerUnreachable", "Server unreachable: " + iOException.toString());
        }
        return null;
    }

    private String getResponseContent(HttpResponse httpResponse) throws ClientException {
        String stringContent = null;

        try {
            if (null == httpResponse.getEncoding()) {
                stringContent = new String(httpResponse.getHttpContent());
            } else {
                stringContent = new String(httpResponse.getHttpContent(), httpResponse.getEncoding());
            }

            return stringContent;
        } catch (UnsupportedEncodingException var4) {
            throw new ClientException("SDK.UnsupportedEncoding", "Can not parse response due to un supported encoding.");
        }
    }
}
