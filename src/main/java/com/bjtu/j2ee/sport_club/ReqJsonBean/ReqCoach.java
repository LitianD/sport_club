package com.bjtu.j2ee.sport_club.ReqJsonBean;

import java.io.Serializable;

public class ReqCoach implements Serializable {

    /**
     * id :
     * name :
     */

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
