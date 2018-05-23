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
    private static String HOST_DOMAIN = "http://wwww.baoxinwen.com";
    ICredentials iCredentials;
    protected Signer signer = new HmacSHA1Signer();
    static Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public OpenClient(ICredentials iCredentials) {

        this.iCredentials = iCredentials;
    }

    public OpenClient(String hostDamin, ICredentials iCredentials) {
        if (hostDamin != null && "".equals(hostDamin) == false) {
            HOST_DOMAIN = hostDamin;
        }
        this.iCredentials = iCredentials;
    }


    public <T extends ResponseModel> T doRequest(OpenRequest<T> request, boolean autoRetry, int maxRetryCounts) throws ClientException {
        HttpResponse httpResponse = this.doAction(request, iCredentials, autoRetry, maxRetryCounts);
        return getResponse(httpResponse, request.getResponseModelClass());
    }


    private <T extends ResponseModel> T getResponse(HttpResponse httpResponse, Class<T> clasz) {
        String responseContent = this.getResponseContent(httpResponse);
        return gson.fromJson(responseContent, clasz);
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
