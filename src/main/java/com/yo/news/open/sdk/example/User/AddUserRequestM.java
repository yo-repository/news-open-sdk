package com.yo.news.open.sdk.example.User;


/**
 * Author:JAN
 * Date:15:34 2018-8-21
 * Note:
 **/
public class AddUserRequestM  {
    private AddUserModel user;

    public AddUserModel getUser() {
        return user;
    }

    public void setUser(AddUserModel user) {
        this.user = user;
    }

    public static class AddUserModel {
        private String userId3rd;// 第三方系统用户id，必填
        private String tel;         // 手机号码，必填
        private String pwd;         // 登录密码，必填
        private String email;     // 邮箱，选填
        private String nickname; // 用户昵称，必填
        private String trueName; // 用户真实姓名，必填
        private int sex;         // 用户性别，必填
//        private String headUrl;//用户头像

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getTrueName() {
            return trueName;
        }

        public void setTrueName(String trueName) {
            this.trueName = trueName;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getUserId3rd() {
            return userId3rd;
        }

        public void setUserId3rd(String userId3rd) {
            this.userId3rd = userId3rd;
        }
    }
}
