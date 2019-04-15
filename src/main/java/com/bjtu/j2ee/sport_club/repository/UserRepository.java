package com.bjtu.j2ee.sport_club.repository;

import com.bjtu.j2ee.sport_club.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
