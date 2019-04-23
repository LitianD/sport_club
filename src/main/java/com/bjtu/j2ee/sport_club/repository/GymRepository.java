package com.bjtu.j2ee.sport_club.repository;

import com.bjtu.j2ee.sport_club.domain.Gym;
import org.springframework.data.repository.CrudRepository;

public interface GymRepository extends CrudRepository<Gym, Integer> {
}
