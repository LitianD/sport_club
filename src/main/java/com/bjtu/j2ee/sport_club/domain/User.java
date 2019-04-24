package com.bjtu.j2ee.sport_club.domain;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotEmpty(message ="username is required")
	private String username;

	@NotEmpty(message ="password is required")
	private String password;

	@NotEmpty(message ="name is required")
	private String name;

	@NotEmpty(message ="mail is required")
	private String mail;

	@Size(min = 11, max = 11, message = "Mobile no. must be 11 digits.")
	private String phoneNumber;

	private Integer age;

	//0为普通用户 1为会员
	private Integer role;

	//1为男 0为女
	private Integer sex;

	@ManyToMany
	@JoinTable(name = "user_course",joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> CourseList;
}
