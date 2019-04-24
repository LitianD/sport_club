package com.bjtu.j2ee.sport_club.domain;


import com.bjtu.j2ee.sport_club.repository.CoachRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Id;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Coach implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "username is required.")
    private String username;
    @NotEmpty(message = "Name is required.")
    private String name;
    @NotEmpty(message = "password is required.")
    private String password;

    private Integer age;

    //1为男 0为女
    private Integer sex;
    @Size(min = 11, max = 11, message = "mobile no . must be 11 digits")
    private String phoneNumber;
    @NotEmpty(message = "E-Mail is required.")
    private String mail;
    @NotEmpty(message = "Content is required.")
    private String content;


    @OneToMany(mappedBy = "id",cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    private List<Course> courseList;


    @CreatedDate
    private Date createAt;

    @LastModifiedDate
    private Date updateAt;

}
