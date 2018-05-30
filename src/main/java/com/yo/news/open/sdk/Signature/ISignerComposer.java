package com.yo.news.open.sdk.Signature;

import java.util.Map;

/**
 * Author:JAN
 * Date:10:20 2018-5-23
 * Note:
 **/
public interface ISignerComposer {
    Map<String, String> refreshSignParameters(Map<String, String> parameters, String accessKeyId,Signer signer);

    String composeStringToSign(Map<String, String> queries, Signer signer);
}
