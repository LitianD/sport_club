package com.bjtu.j2ee.sport_club.repository2;

import com.bjtu.j2ee.sport_club.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository2 extends CrudRepository<Course, Integer> {
    Iterable<Course> findAll(Sort sort);
    Page<Course> findAll(Pageable pageable);
}
