package com.yo.news.open.sdk.example.Toc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yo.news.open.sdk.OpenClient;
import com.yo.news.open.sdk.auth.Credentials;
import com.yo.news.open.sdk.http.MethodType;

/**
 * Author:JAN
 * Date:13:48 2019-1-8
 * Note:
 **/
public class TestDemo {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        //        Credentials credentials = new Credentials(" ", " ");
        Credentials credentials = new Credentials("003c1efa74bc4b3ab24f098378249e8f", "0054041E09B545B7A0ECDD8920A57CF3");
//        OpenClient openClient = new OpenClient("https://open.baoxinwen.com", credentials);
        OpenClient openClient = new OpenClient("http://localhost:9995", credentials);
        TestTocRequest testTocRequest = new TestTocRequest("/open/signature", MethodType.GET);

        String data = gson.toJson(testTocRequest);

//        TestResponseModel testResponseModel = openClient.doRequest(testTocRequest, true, 1);
//        System.out.println(gson.toJson(testResponseModel));
        String s = openClient.doRequest4Body(testTocRequest, true, 1);
        System.out.println(s);
    }
}
