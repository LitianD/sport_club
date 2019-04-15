package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.domain.Coach;

public interface coachService {

    Iterable<Coach> getAllCoachs();
    Coach getCoachById(Integer id);
    Coach saveCoach(Coach contact);
    void deleteCoach(Integer id);

}
