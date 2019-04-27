package com.bjtu.j2ee.sport_club.bean;

import java.io.Serializable;

public class ReqMyCourse implements Serializable {

    /**
     * id :
     */

    private String usernmae;

    public String getUsername() {
        return usernmae;
    }

    public void setUsername(String usernmae) {
        this.usernmae = usernmae;
    }
}
