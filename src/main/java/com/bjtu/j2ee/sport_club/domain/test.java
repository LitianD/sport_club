package com.bjtu.j2ee.sport_club.domain;

public class test {

	/**
	 * username : zlt
	 * password : 123123
	 * repasswordd : 123123
	 * “name” : zlt
	 * mail : @
	 * phonenumber :
	 * age :
	 * sex :
	 */

	private String username;
	private String password;
	private String repasswordd;
	private String name; // FIXME check this code
	private String mail;
	private String phonenumber;
	private String age;
	private String sex;
	private User u;

	public void setUser(User u)
	{
		this.u = u;
	}

	public User getUser() {
		return u;
	}

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

	public String getRepasswordd() {
		return repasswordd;
	}

	public void setRepasswordd(String repasswordd) {
		this.repasswordd = repasswordd;
	}

	public String getName() {
		return name;
	}

	public void setName(String _$Name145) {
		this.name =name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
