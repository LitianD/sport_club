package com.bjtu.j2ee.sport_club.repository;

import com.bjtu.j2ee.sport_club.domain.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer>{
    
}