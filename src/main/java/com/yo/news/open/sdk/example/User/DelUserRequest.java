package com.yo.news.open.sdk.example.User;

import com.yo.news.open.sdk.OpenRequest;
import com.yo.news.open.sdk.http.MethodType;

/**
 * Author:JAN
 * Date:17:06 2018-8-22
 * Note:
 **/
public class DelUserRequest extends OpenRequest {

    public DelUserRequest() {
        super("/open/tob/user/v1/del.json", MethodType.POST);
    }

    public DelUserRequest(String requestUri, MethodType methodType) {
        super(requestUri, methodType);
    }



    public Class getResponseModelClass() {
        return null;
    }
}
