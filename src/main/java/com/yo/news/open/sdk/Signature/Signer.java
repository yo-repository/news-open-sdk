package com.yo.news.open.sdk.Signature;

/**
 * Author:JAN
 * Date:14:31 2018-5-15
 * Note:
 **/
public abstract class Signer {
    public Signer() {
    }

 

    public abstract String signString(String stringToSign, String accessKeySecret);

    public abstract String getSignerName();

    public abstract String getSignerVersion();

    public abstract String getSignerType();
}
