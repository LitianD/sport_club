package com.bjtu.j2ee.sport_club.bean;

public class ResSignup {

    /**
     * code :
     * error_msg :
     * data : {"username":"","\u201cname\u201d":"","mail":"","phonenumber":"","age":"","sex":""}
     */

    private String code;
    private String error_msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * username :
         * “name” :
         * mail :
         * phonenumber :
         * age :
         * sex :
         */

        private String username;
        //@com.google.gson.annotations.SerializedName("“name”")
        private String _$Name133; // FIXME check this code
        private String mail;
        private String phonenumber;
        private String age;
        private String sex;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String get_$Name133() {
            return _$Name133;
        }

        public void set_$Name133(String _$Name133) {
            this._$Name133 = _$Name133;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
