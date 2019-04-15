package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.domain.Contact;
import com.bjtu.j2ee.sport_club.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;
    
    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    
    @Override
    public Iterable<Contact> getAllContacts() {
        return this.contactRepository.findAll();
    }
    
    @Override
    public Contact getContactById(Integer id) {
        return this.contactRepository.findById(id).orElse(null);
    }
    
    @Override
    public Contact saveContact(Contact contact) {
        return this.contactRepository.save(contact);
    }
    
    @Override
    public void deleteContact(Integer id) {
        this.contactRepository.deleteById(id);
    }
    
}
