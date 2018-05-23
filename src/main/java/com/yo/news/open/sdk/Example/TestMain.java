package com.yo.news.open.sdk.Example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yo.news.open.sdk.OpenClient;
import com.yo.news.open.sdk.auth.Credentials;


/**
 * Author:JAN
 * Date:12:26 2018-5-23
 * Note:
 **/
public class TestMain {
    public static void main(String[] args) {
        //
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        Credentials credentials = new Credentials("13123", "4234234");
        OpenClient openClient = new OpenClient("http://localhost:8084", credentials);
        TestRequest testRequest = new TestRequest();
        testRequest.setParamter1("a");
        testRequest.setParamter2(null);
        TestResponseModel testResponseModel = openClient.doRequest(testRequest, true, 1);
        System.out.println(gson.toJson(testResponseModel));
    }
}
