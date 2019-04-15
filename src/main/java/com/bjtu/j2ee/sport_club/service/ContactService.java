package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.domain.Contact;

public interface ContactService {
    Iterable<Contact> getAllContacts();
    Contact getContactById(Integer id);
    Contact saveContact(Contact contact);
    void deleteContact(Integer id);
}
