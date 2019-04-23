package com.bjtu.j2ee.sport_club.repository;

import com.bjtu.j2ee.sport_club.domain.Coach;
import org.springframework.data.repository.CrudRepository;

public interface CoachRepository extends CrudRepository<Coach, Integer> {
}
