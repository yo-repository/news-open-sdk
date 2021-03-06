package com.yo.news.open.sdk.example;

import com.yo.news.open.sdk.OpenRequest;
import com.yo.news.open.sdk.http.MethodType;

/**
 * Author:JAN
 * Date:12:20 2018-5-23
 * Note:
 **/
public class TestRequest extends OpenRequest<TestResponseModel> {
    public TestRequest() {
        super("/open/newsphere/v1/msg/send.json", MethodType.POST);
    }
//    public TestRequest() {
//        super("/open/script/v1/addFromUrl.json", MethodType.POST);
//    }
//    public TestRequest() {
//        super("/open/tob/user/v1/add.json", MethodType.POST);
//    }

//    private String paramter1;
//    private String paramter2;
    private String data;

    @Override
    public Class getResponseModelClass() {
        return TestResponseModel.class;
    }

//    public String getParamter1() {
//        return paramter1;
//    }
//
//    public void setParamter1(String paramter1) {
//        this.paramter1 = paramter1;
//        this.putQueryParameter("paramter1", paramter1);
//
//    }
//
//    public String getParamter2() {
//        return paramter2;
//    }
//
//    public void setParamter2(String paramter2) {
//        this.paramter2 = paramter2;
//        this.putQueryParameter("paramter2", paramter2);
//    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public void setData(String data) {
        this.data = data;
        this.putQueryParameter("data", data);
    }
}
