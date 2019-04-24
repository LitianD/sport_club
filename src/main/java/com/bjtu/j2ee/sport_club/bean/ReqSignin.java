package com.bjtu.j2ee.sport_club.bean;

import java.io.Serializable;

public class ReqSignin implements Serializable {
    /**
     * username :
     * password :
     */

    private String username;
    private String password;

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
}
