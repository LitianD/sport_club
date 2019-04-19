package com.bjtu.j2ee.sport_club.controller;

import com.bjtu.j2ee.sport_club.domain.Contact;
import com.bjtu.j2ee.sport_club.domain.User;
import com.bjtu.j2ee.sport_club.domain.test;
import com.bjtu.j2ee.sport_club.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	private ContactService contactService;

	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	@RequestMapping(value = { "", "/", "/home" })
	@ResponseBody
	public String index(Model model) {
		Contact contact = new Contact();
		contact.setAddress("address");

		contact.setFirstName("zhang");
		contact.setLastName("litina");
		contact.setMobileNumber("13120019766");
		contactService.saveContact(contact);
		return "OK";
	}
	@RequestMapping(value = {"/test","/test/"})
	@ResponseBody
	public test test(@RequestBody test t)
	{
		test t2 = new test();
		t2.setAge("st");
		User u = new User();
		u.setMail("123123123");
		t2.setUser(u);
		return t2;
	}
}