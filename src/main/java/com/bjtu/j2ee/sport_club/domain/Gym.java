package com.bjtu.j2ee.sport_club.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Gym implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotEmpty(message = "Name is required.")
    private String name;

    @NotEmpty(message = "Address is required.")
    private String address;


    @OneToMany(mappedBy = "gym",cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    private List<Course> courseList;

    @CreatedDate
    private Date createAt;

    @LastModifiedDate
    private Date updateAt;
}
