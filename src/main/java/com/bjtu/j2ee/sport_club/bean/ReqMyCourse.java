package com.bjtu.j2ee.sport_club.bean;

import java.io.Serializable;

public class ReqMyCourse implements Serializable {

    /**
     * id :
     */

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
