package com.bjtu.j2ee.sport_club.ResJsonBean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UrlData extends ResponseJson implements Serializable {


    @Data
    public static  class  links extends ResponseJson implements Serializable{
        private List<String> hrefs;
    }

    links _links;

}
