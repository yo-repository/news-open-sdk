package test.clue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yo.news.open.sdk.OpenClient;
import com.yo.news.open.sdk.auth.Credentials;
import com.yo.news.open.sdk.http.MethodType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

/**
 * @author:JAN
 * @date:9:14 2019-3-1
 * @note:
 **/
public class TestClue {
    @Before
    public void setUp() {

    }
    @After
    public void down() {

    }
    @Test
    public void addClue()
    {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        AddClueModel requestM=new AddClueModel();
        requestM.setCreatedTime("2019-02-28 17:28:00");
        requestM.setOriginId("1fb843839a853b68ae1814f6aa9180fe");
        requestM.setOrigin("东方头条-社会新闻");
        requestM.setOriginUrl("http://mini.eastday.com/a/190228172858847.html");
        requestM.setTitle("邢台市污水处理二厂美能超滤膜系统交付使用");
        requestM.setUserId("10008599");
        requestM.setContent("<p>近日，河北省邢台市污水处理二厂一期工程美能超滤膜系统顺利通过业主验收，正式交付使用。该项目也是中信环境技术首个新建的改良A2/O脱氮除磷工艺+浸没式超滤膜工艺+臭氧接触脱色工艺的项目。 </p> ");
        Credentials credentials = new Credentials("1116e98fd4222d76ac234242a07f032c", "1224e98f34532d76ac234242a07f032c");
//        OpenClient openClient = new OpenClient("https://open.baoxinwen.com", credentials);
        OpenClient openClient = new OpenClient("http://localhost:9010", credentials);
        AddClueRequest addClueRequest=new AddClueRequest("/open/zw/v1/clue/add", MethodType.POST);
        addClueRequest.setData(gson.toJson(requestM));
        String s = openClient.doRequest4Body(addClueRequest, true, 1);
        System.out.println(s);
    }
}
