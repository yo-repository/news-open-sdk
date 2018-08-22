package com.yo.news.open.sdk.Example.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yo.news.open.sdk.Example.ScriptInputRequestM;
import com.yo.news.open.sdk.Example.TestRequest;
import com.yo.news.open.sdk.Example.TestResponseModel;
import com.yo.news.open.sdk.OpenClient;
import com.yo.news.open.sdk.auth.Credentials;

/**
 * Author:JAN
 * Date:16:48 2018-8-21
 * Note:
 **/
public class TestAddUserMain {

    public static void main(String[] args) {
        //
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        Credentials credentials = new Credentials("13a3ca114b814cfe88febe60c4056ee9", "e1891f2266284b22aeb6007a51fe2488");
//        OpenClient openClient = new OpenClient("https://open.baoxinwen.com", credentials);
        OpenClient openClient = new OpenClient("http://localhost:9010", credentials);
        AddUserRequestM requestM = new AddUserRequestM();
        AddUserRequestM.AddUserModel addUserModel = new AddUserRequestM.AddUserModel();
        addUserModel.setEmail("testaa.mail.com");
        addUserModel.setNickname("lover");
        addUserModel.setPwd(AppMD5Util.getMD5("111111"));
        addUserModel.setSex(1);
        addUserModel.setTrueName("JAN");
        addUserModel.setTel("18610008888");
        addUserModel.setUserId3rd("12312312312");
        requestM.setUser(addUserModel);
        String data = gson.toJson(requestM, AddUserRequestM.class);


        AddUserRequest testRequest = new AddUserRequest();
        testRequest.setData(data);
        String body = openClient.doRequest4Body(testRequest, true, 1);
        System.out.println(body);
    }
}
