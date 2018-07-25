package com.yo.news.open.sdk.Example;

import java.util.List;

/**
 * Author:JAN
 * Date:15:46 2018-7-24
 * Note:
 **/
public class ScriptInputRequestM {
    //任务Id，保证一次任务不被多次处理
    private String taskId;
    //入库的稿件对应的用户信息
    private ScriptInputUserRequestM user;
    //入库的稿件信息
    private ScriptInputScriptRequestM script;
    //入库的回调地址
    private String callBackUrl;

    public ScriptInputUserRequestM getUser() {
        return user;
    }

    public void setUser(ScriptInputUserRequestM user) {
        this.user = user;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public ScriptInputScriptRequestM getScript() {
        return script;
    }

    public void setScript(ScriptInputScriptRequestM script) {
        this.script = script;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }


    public static class ScriptInputUserRequestM {
        //第三方Id，如果是newsphere则对应的是loginId
        private String user3rdId;
        //用户真实姓名
        private String trueName;
        //用户头像的Url地址
        private String userHead;
        //用户的昵称
        private String nickName;
        //用户性别，0：女，1：男
        private Byte sex;
        //用户的电话
        private String tel;

        //自定义的密码
        private String pwd;

        public String getUser3rdId() {
            return user3rdId;
        }

        public void setUser3rdId(String user3rdId) {
            this.user3rdId = user3rdId;
        }

        public String getTrueName() {
            return trueName;
        }

        public void setTrueName(String trueName) {
            this.trueName = trueName;
        }

        public String getUserHead() {
            return userHead;
        }

        public void setUserHead(String userHead) {
            this.userHead = userHead;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public Byte getSex() {
            return sex;
        }

        public void setSex(Byte sex) {
            this.sex = sex;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }
    }

    public static class ScriptInputScriptRequestM {
        //稿件标题
        private String name;
        //新闻片类型，0：新闻（粗编），1：视频（精编） 2:图文排版，3：协同图文（整篇文章作为一个素材）
        private Byte types;
        //标签以逗号分隔
        private String tag;
        //稿件的背景图url地址
        private String bgUrl;
        //0:线索 1：选题 2：报道
        private Byte originType;
        //稿件正文内容
        private String description;
        //素材集合
        private List<ScriptInputClipRequestM> clips;

        public List<ScriptInputClipRequestM> getClips() {
            return clips;
        }

        public void setClips(List<ScriptInputClipRequestM> clips) {
            this.clips = clips;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getBgUrl() {
            return bgUrl;
        }

        public void setBgUrl(String bgUrl) {
            this.bgUrl = bgUrl;
        }

        public Byte getTypes() {
            return types;
        }

        public void setTypes(Byte types) {
            this.types = types;
        }

        public Byte getOriginType() {
            return originType;
        }

        public void setOriginType(Byte originType) {
            this.originType = originType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class ScriptInputClipRequestM {
        //素材名称
        private String name;
        //素材类型 0：视频，1：图片，2：文本,3:音频
        private Byte types;
        //素材缩略图url地址
        private String thumbUrl;
        //素材物理原文件访问的Url地址
        private String url;
        //如果是图片或者视频，则它的分辨率是多少，单位像素，格式  300*200
        private String dpi;
        //素材的拍摄位置
        private String position;
        //素材物理文件大小  类型Long
        private Long clipSize;
        //描述
        private String description;
        //拍摄时间
        private String shootTime;
        //单位秒
        private Integer length;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Byte getTypes() {
            return types;
        }

        public void setTypes(Byte types) {
            this.types = types;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDpi() {
            return dpi;
        }

        public void setDpi(String dpi) {
            this.dpi = dpi;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public Long getClipSize() {
            return clipSize;
        }

        public void setClipSize(Long clipSize) {
            this.clipSize = clipSize;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getShootTime() {
            return shootTime;
        }

        public void setShootTime(String shootTime) {
            this.shootTime = shootTime;
        }

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }
    }
}
