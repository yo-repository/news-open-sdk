package com.yo.news.open.sdk.example.Toc;

import com.yo.news.open.sdk.example.TestResponseModel;
import com.yo.news.open.sdk.OpenRequest;
import com.yo.news.open.sdk.http.MethodType;

/**
 * Author:JAN
 * Date:13:49 2019-1-8
 * Note:
 **/
public class TestTocRequest extends OpenRequest<TestResponseModel> {
    public TestTocRequest(String requestUri, MethodType methodType) {
        super(requestUri, methodType);
    }

    public Class<TestResponseModel> getResponseModelClass() {
        return null;
    }
}
