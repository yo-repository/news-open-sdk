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
        requestM.setInstId("10000002");
        requestM.setCreatedTime("2019-03-01 18:19:41");
        requestM.setOriginId("1fb843839a853b68ae1814f6aa9180fe");
        requestM.setOrigin("搜狐");
        requestM.setOriginUrl("http://www.sohu.com/a/292634955_100237533");
        requestM.setTitle("这四个专业，对于女生来说都是“力气活”，报考时要注意");
        requestM.setUserId("18610008122");
        requestM.setContent("<p>这四个专业，对于女生来说都是“力气活”，报考时要注意_体力</p>\\r\\n<p>搜狐首页</p>\\r\\n<p>新闻</p>\\r\\n<p>体育</p>\\r\\n<p>汽车</p>\\r\\n<p>房产</p>\\r\\n<p>旅游</p>\\r\\n<p>教育</p>\\r\\n<p>时尚</p>\\r\\n<p>科技</p>\\r\\n<p>财经</p>\\r\\n<p>娱乐</p>\\r\\n<p>更多</p>\\r\\n<p>          母婴          健康          历史          军事          美食          文化          星座          专题          游戏          搞笑          动漫          宠物         </p>\\r\\n<p>     搜狐&gt;    教育&gt;    </p>\\r\\n<p><img title='' alt='' src='http://resource.zvn360.net:31820/y/net/text/souhu-souhujiaoyu/2019-01-31/0e2f66_1.jpeg'></p>\\r\\n<p> 卿晨说教育 </p>\\r\\n<p>        查看TA的文章&gt;       </p>\\r\\n<p> 原创 这四个专业，对于女生来说都是“力气活”，报考时要注意   </p>\\r\\n<p>          2019-01-31 17:42          来源:卿晨说教育           专业 </p>\\r\\n<p>/</p>\\r\\n<p>/</p>\\r\\n<p>原标题：这四个专业，对于女生来说都是“力气活”，报考时要注意</p>\\r\\n<p>高考上大学，女生选择专业的考虑，和男生的考虑，很多时候都不一样。有些专业特别适合女生，比如，护理专业、民航专业、教师专业，等等。也有一部分专业，对于女生来说意味着很考验体力。在报考这类专业的时候，就需要特别慎重。</p>\\r\\n<p><img title='' alt='' src='http://resource.zvn360.net:31820/y/net/text/souhu-souhujiaoyu/2019-01-31/0e2f66_2.jpeg'></p>\\r\\n<p>口腔医学专业</p>\\r\\n<p>口腔医学专业，近年来也是一个热门的专业。大家都知道，日常生活中有句话叫做“牙疼不是病，疼起来要人命”。因此，学习口腔医学专业，毕业后也非常有前途。但是，如果女生选择口腔医学专业，很多时候也考验女生的体力，比如，拔牙的时候，女生作为牙医，拔牙有时候真的特别艰难。小编有一次拔智齿，遇到的就是一个女医生，因为力气太小了，拔了好久才把智齿拔掉了，她累得大汗淋漓，我也不好受。因此，如果女生力气不够，选择当牙医要慎重。</p>\\r\\n<p><img title='' alt='' src='http://resource.zvn360.net:31820/y/net/text/souhu-souhujiaoyu/2019-01-31/0e2f66_3.jpeg'></p>\\r\\n<p>土木工程专业</p>\\r\\n<p>土木工程专业，对于女生而言，很多时候也不太适合。虽然说，选择土木工程专业，在现阶段的中国，也算是非常有前途的专业。但是，土木工程专业的主战场往往都是在室外而非室内。土木工程师很多时候需要跑工地，这对于女生来说，也多有不便。即便是主要做建筑设计，也免不了经常需要在室外工作。因此，对于女生而言，选择土木工程专业，值得谨慎考虑。</p>\\r\\n<p><img title='' alt='' src='http://resource.zvn360.net:31820/y/net/text/souhu-souhujiaoyu/2019-01-31/0e2f66_4.jpeg'></p>\\r\\n<p>地质专业</p>\\r\\n<p>地质学专业，通常招收男生的多，偶尔也有女生。这个专业，对于女生来说，真的不是特别友好，尤其是如果毕业后想要找对口的工作，工作的环境更是非常恶劣，长期呆在野外生活，很多男生都受不了，更何况女生。单单是从体力上来说，如果一个女生要常年在野外生活，常年在野外进行地质勘察，其实也是非常艰苦的。</p>\\r\\n<p><img title='' alt='' src='http://resource.zvn360.net:31820/y/net/text/souhu-souhujiaoyu/2019-01-31/0e2f66_5.jpeg'></p>\\r\\n<p>体育专业</p>\\r\\n<p>体育专业，顾名思义，对于个人的体力要求比较高，作为女生而言，选择这个专业，也需要有较强的体能。在高校体育系中，女生也比较少见，原因就是因为女生的体力普遍不如男生。因此，对于体育专业，女生在填报志愿的时候，一定要考虑好。</p>\\r\\n<p>责任编辑：</p>\\r\\n");
        Credentials credentials = new Credentials("00099FD49C804CDF87C0138C289094B6", "000AFA4725B84D1F8A72384F78646C02");
//        Credentials credentials = new Credentials("1116e98fd4222d76ac234242a07f032c", "1224e98f34532d76ac234242a07f032c");
        OpenClient openClient = new OpenClient("https://open.baoxinwen.com", credentials);
//        OpenClient openClient = new OpenClient("http://localhost:9010", credentials);
        AddClueRequest addClueRequest=new AddClueRequest("/open/zw/v1/clue/add", MethodType.POST);
        addClueRequest.setData(gson.toJson(requestM));
        String s = openClient.doRequest4Body(addClueRequest, true, 1);
        System.out.println(s);
    }
}
