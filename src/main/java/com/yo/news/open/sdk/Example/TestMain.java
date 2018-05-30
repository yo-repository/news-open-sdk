package com.yo.news.open.sdk.Example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yo.news.open.sdk.OpenClient;
import com.yo.news.open.sdk.auth.Credentials;

import java.util.ArrayList;


/**
 * Author:JAN
 * Date:12:26 2018-5-23
 * Note:
 **/
public class TestMain {
    public static void main(String[] args) {
        //
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        Credentials credentials = new Credentials("99e09b4bd0bd4ae79fbc222b16692eec", "01c326c10dd141068bc7e30dcc43e05a");
        OpenClient openClient = new OpenClient("http://localhost:9010", credentials);
        TestRequest testRequest = new TestRequest();
//        testRequest.setParamter1("a");
//        testRequest.setParamter2(null);

        SendMsgRequestM sendMsgRequestM = new SendMsgRequestM();
        sendMsgRequestM.setFromLoginId("1131");
        sendMsgRequestM.setbNofity(false);
        sendMsgRequestM.setMsgContent("稿件审核通过");
        ArrayList list = new ArrayList(3);
        list.add("1");
        list.add("2");
        list.add("3");
        sendMsgRequestM.setToLoginIds(list);
        String data = gson.toJson(sendMsgRequestM);
        data = "{\"fromUserId\":\"1131\"}";
        testRequest.setData(data);
        TestResponseModel testResponseModel = openClient.doRequest(testRequest, true, 1);
        System.out.println(gson.toJson(testResponseModel));
    }
}
