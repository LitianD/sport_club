package com.bjtu.j2ee.sport_club.bean;

public class ReqUpdate {

    /**
     * username :
     * password :
     * repasswordd :
     * “name” :
     * mail :
     * phonenumber :
     * age :
     * sex :
     */

    private String username;
    private String password;
    private String repasswordd;
    //@com.google.gson.annotations.SerializedName("“name”")
    private String _$Name270; // FIXME check this code
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepasswordd() {
        return repasswordd;
    }

    public void setRepasswordd(String repasswordd) {
        this.repasswordd = repasswordd;
    }

    public String get_$Name270() {
        return _$Name270;
    }

    public void set_$Name270(String _$Name270) {
        this._$Name270 = _$Name270;
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
