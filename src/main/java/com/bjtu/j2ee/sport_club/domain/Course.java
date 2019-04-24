package com.bjtu.j2ee.sport_club.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="coach")//设置在article表中的关联字段(外键)
    private Coach coach;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="gym")//设置在article表中的关联字段(外键)
    private Gym gym;

    @NotEmpty(message = "cost is required.")
    @Size(min = 0, message = "cost must be bigger or equal to zero")
    private Double cost;

    @NotEmpty(message = "Content is required.")
    private String content;

    @NotEmpty(message = "Time is required.")
    private String Time;

    @ManyToMany(mappedBy = "CourseList")
    private List<User> userList;

}
