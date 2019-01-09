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
//        Credentials credentials = new Credentials(" ", " ");
        Credentials credentials = new Credentials("1116e98fd4222d76ac234242a07f032c", "1224e98f34532d76ac234242a07f032c");
        OpenClient openClient = new OpenClient("https://open.baoxinwen.com", credentials);
//        OpenClient openClient = new OpenClient("http://localhost:9010", credentials);
        TestRequest testRequest = new TestRequest();
        SendMsgRequestM sendMsgRequestM = new SendMsgRequestM();
//        sendMsgRequestM.setFromLoginId("030004651");
        sendMsgRequestM.setFromLoginId("yy2017");
        sendMsgRequestM.setbNofity(true);
        sendMsgRequestM.setMsgContent("cdv loginId 测试");
        ArrayList list = new ArrayList(3);
        list.add("yy2018");
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
