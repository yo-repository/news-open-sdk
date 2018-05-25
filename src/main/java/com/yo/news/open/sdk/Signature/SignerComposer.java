package com.yo.news.open.sdk.Signature;

import com.yo.news.open.sdk.http.ParameterHelper;
import com.yo.news.open.sdk.http.URLEncoder;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;

/**
 * Author:JAN
 * Date:16:54 2018-5-21
 * Note:
 **/
public class SignerComposer implements ISignerComposer {

    protected static final String QUERY_SEPARATOR = "&";
    protected static final String HEADER_SEPARATOR = "\n";

    public Map<String, String> refreshSignParameters(Map<String, String> parameters, String accessKeyId) {
        parameters.put("timestamp", ParameterHelper.getISO8601Time(null));
        parameters.put("signNonce", ParameterHelper.getUniqueNonce());
        parameters.put("accessKeyId", accessKeyId);
        return parameters;
    }

    /**
     * Author:JAN
     * Date:10:28 2018-5-23
     * Note:将查询的参数进行处理
     * 先排序按字典升序排列，
     * 后拼接,(key=value)用&拼接起来
     **/
    public String composeStringToSign(Map<String, String> queries, Signer signer) {
        String[] sortedKeys = queries.keySet().toArray(new String[0]);
        Arrays.sort(sortedKeys);
        StringBuilder contactQueryString = new StringBuilder(sortedKeys.length);
        try {

            int length = sortedKeys.length;
            for (int i = 0; i < length; ++i) {
                String key = sortedKeys[i];
//                contactQueryString.append(QUERY_SEPARATOR).append(URLEncoder.percentEncode(key)).append("=").append(URLEncoder.percentEncode(queries.get(key)));
                contactQueryString.append(QUERY_SEPARATOR).append(key).append("=").append(queries.get(key));
            }
            System.out.println(contactQueryString.toString().substring(1));
            return URLEncoder.percentEncode(contactQueryString.toString().substring(1));
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("UTF-8 encoding is not supported.");
        }
    }

}
