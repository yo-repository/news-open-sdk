package com.yo.news.open.sdk.Example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yo.news.open.sdk.OpenClient;
import com.yo.news.open.sdk.auth.Credentials;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Author:JAN
 * Date:12:26 2018-5-23
 * Note:
 **/
public class TestScriptMain {
    public static void main(String[] args) {
        //
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//        Credentials credentials = new Credentials(" ", " ");

        Credentials credentials = new Credentials("d4582c15061e42bc8be78fbe1df76f30", "294ad4bd62d4401498693256fc328bcc");
//        Credentials credentials = new Credentials("13a3ca114b814cfe88febe60c4056ee9", "e1891f2266284b22aeb6007a51fe2488");
        OpenClient openClient = new OpenClient("https://open.baoxinwen.com", credentials);
//        OpenClient openClient = new OpenClient("http://localhost:9010", credentials);
        ScriptInputRequestM requestM = new ScriptInputRequestM();
        requestM.setCallBackUrl("http://test/callbackurl");
        ScriptInputRequestM.ScriptInputScriptRequestM scriptRequestM = new ScriptInputRequestM.ScriptInputScriptRequestM();
        scriptRequestM.setBgUrl("http://img.baoxinwen.com/thing//default/user/20151119105627.jpg");
        scriptRequestM.setName("稿件名称");
        scriptRequestM.setOriginType(Byte.parseByte("2"));
        scriptRequestM.setTag("军事,娱乐");
        scriptRequestM.setTypes(Byte.parseByte("0"));
        scriptRequestM.setDescription("文稿描述");
        List<ScriptInputRequestM.ScriptInputClipRequestM> clipRequestMS = new ArrayList();
        ScriptInputRequestM.ScriptInputClipRequestM clipRequestM = new ScriptInputRequestM.ScriptInputClipRequestM();
        clipRequestM.setClipSize(1024L);
        clipRequestM.setName("测试素材入库1");
        clipRequestM.setDescription("素材描述");
        clipRequestM.setLength(10);
        clipRequestM.setDpi("300*200");
        clipRequestM.setShootTime("1527140747000");
        clipRequestM.setThumbUrl("http://img.baoxinwen.com/news/static/imgs/script/script_only_audio.jpg");
        clipRequestM.setTypes(Byte.parseByte("1"));
        clipRequestM.setUrl("http://img.baoxinwen.com/news/static/imgs/script/script_only_audio.jpg");
        clipRequestM.setPosition("北京五棵松");
        clipRequestMS.add(clipRequestM);
        scriptRequestM.setClips(clipRequestMS);
        requestM.setScript(scriptRequestM);

        requestM.setTaskId(UUID.randomUUID().toString());

        ScriptInputRequestM.ScriptInputUserRequestM userRequestM = new ScriptInputRequestM.ScriptInputUserRequestM();
        userRequestM.setNickName("一个人");
        userRequestM.setPwd("md5加密后的");
        userRequestM.setSex(Byte.parseByte("1"));
        userRequestM.setTel("123123123123");
        userRequestM.setUser3rdId("123222");
        userRequestM.setUserHead("http://img.baoxinwen.com/thing//default/user/20151119105627.jpg");
        userRequestM.setTrueName("真实姓名");

        requestM.setUser(userRequestM);

        requestM.setScript(scriptRequestM);
        String data = gson.toJson(requestM, ScriptInputRequestM.class);


        TestRequest testRequest = new TestRequest();
        testRequest.setData(data);
        TestResponseModel testResponseModel = openClient.doRequest(testRequest, true, 1);
        System.out.println(gson.toJson(testResponseModel));
    }
}
