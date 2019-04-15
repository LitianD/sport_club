package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.domain.Gym;

public interface gymService {

    Iterable<Gym> getAllGyms();
    Gym getGymById(Integer id);
    Gym saveGym(Gym contact);
    void deleteGym(Integer id);

}
