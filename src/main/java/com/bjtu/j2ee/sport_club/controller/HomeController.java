package com.bjtu.j2ee.sport_club.controller;

import com.bjtu.j2ee.sport_club.domain.Contact;
import com.bjtu.j2ee.sport_club.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}