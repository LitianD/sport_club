package com.bjtu.j2ee.sport_club.repository2;

import com.bjtu.j2ee.sport_club.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findByUsername(String username);
	List<User> findByUsernameAndPassword(String username, String password);

}
