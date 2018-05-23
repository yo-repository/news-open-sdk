package com.yo.news.open.sdk.auth;

/**
 * Author:JAN
 * Date:13:32 2018-5-15
 * Note:
 **/
public class Credentials implements ICredentials {
    private String accessKeyId;
    private String accessSecret;

    public Credentials(String keyId, String secret) {
        this.accessKeyId = keyId;
        this.accessSecret = secret;
    }

    @Override
    public String getAccessKeyId() {
        return accessKeyId;
    }

    @Override
    public String getAccessKeySecret() {
        return accessSecret;
    }
}
