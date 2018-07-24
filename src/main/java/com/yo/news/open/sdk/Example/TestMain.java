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
        Credentials credentials = new Credentials(" ", " ");
//        Credentials credentials = new Credentials("13a3ca114b814cfe88febe60c4056ee9", "e1891f2266284b22aeb6007a51fe2488");
        OpenClient openClient = new OpenClient("https://open.baoxinwen.com", credentials);
//        OpenClient openClient = new OpenClient("http://localhost:9010", credentials);
        TestRequest testRequest = new TestRequest();
        SendMsgRequestM sendMsgRequestM = new SendMsgRequestM();
//        sendMsgRequestM.setFromLoginId("030004651");
        sendMsgRequestM.setFromLoginId("cdv");
        sendMsgRequestM.setbNofity(true);
        sendMsgRequestM.setMsgContent("cdv loginId 测试");
        ArrayList list = new ArrayList(3);
        list.add("yy2017");
//        list.add("03040482");
//        list.add("3");
        sendMsgRequestM.setToLoginIds(list);
        String data = gson.toJson(sendMsgRequestM);
//        data = "{\"fromUserId\":\"1131\"}";
        testRequest.setData(data);
        TestResponseModel testResponseModel = openClient.doRequest(testRequest, true, 1);
        System.out.println(gson.toJson(testResponseModel));
    }
}
