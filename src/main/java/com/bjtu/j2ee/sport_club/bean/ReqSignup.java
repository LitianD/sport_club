package com.bjtu.j2ee.sport_club.bean;

public class ReqSignup {

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
    private String repassword;
    //@com.google.gson.annotations.SerializedName("“name”")
    private String Name; // FIXME check this code
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

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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
