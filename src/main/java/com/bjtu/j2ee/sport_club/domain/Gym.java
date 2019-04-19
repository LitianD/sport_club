package com.bjtu.j2ee.sport_club.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @NotEmpty(message = "Address is required.")
    private String address;


    @OneToMany(mappedBy = "id",cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    private List<Course> courseList;
}
