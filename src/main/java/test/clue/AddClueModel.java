package test.clue;

/**
 * @author:JAN
 * @date:9:20 2019-3-1
 * @note:
 **/
public class AddClueModel {

    /**
     *用户id
     **/
    private String userId;
    /**
     *标题
     **/
    private String title;
    /**
     *发布时间
     **/
    private String createdTime;
    /**
     *图文内容
     **/
    private String content;
    /**
     *来源名称
     **/
    private String origin;
    /**
     *来源Url地址
     **/
    private String originUrl;
    /**
     *对应知闻库的Id
     **/
    private String originId;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }
}
