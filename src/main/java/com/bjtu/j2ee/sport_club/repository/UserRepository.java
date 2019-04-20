package com.bjtu.j2ee.sport_club.repository;

import com.bjtu.j2ee.sport_club.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findByUsername(String username);

}
