package com.yo.news.open.sdk.example.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yo.news.open.sdk.OpenClient;
import com.yo.news.open.sdk.auth.Credentials;

/**
 * Author:JAN
 * Date:16:48 2018-8-21
 * Note:
 **/
public class TestUpdateUserMain {

    public static void main(String[] args) {
        //
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        Credentials credentials = new Credentials("13a3ca114b814cfe88febe60c4056ee9", "e1891f2266284b22aeb6007a51fe2488");
//        OpenClient openClient = new OpenClient("https://open.baoxinwen.com", credentials);
        OpenClient openClient = new OpenClient("http://localhost:9010", credentials);
        UpdateUserRequestM requestM = new UpdateUserRequestM();
        UpdateUserRequestM.UpdateUserModel updateUserModel = new UpdateUserRequestM.UpdateUserModel();
        updateUserModel.setEmail("testaa.mail.com1");
        updateUserModel.setNickname("lover1");
        updateUserModel.setSex(0);
        updateUserModel.setTrueName("JAN1");
        updateUserModel.setTel("18610008885");
        updateUserModel.setUserId3rd("1111111");
        requestM.setUser(updateUserModel);
        String data = gson.toJson(requestM, UpdateUserRequestM.class);
        UpdateUserRequest testRequest = new UpdateUserRequest();
        testRequest.setData(data);
        String body = openClient.doRequest4Body(testRequest, true, 1);
        System.out.println(body);
    }
}
