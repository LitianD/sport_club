package com.bjtu.j2ee.sport_club.repository;

import com.bjtu.j2ee.sport_club.domain.Contact;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Contact, Integer> {
}