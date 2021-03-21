package com.userservice.userService.repository;

import com.userservice.userService.entity.UsersCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseRepository extends JpaRepository<UsersCourseEntity, Integer> {

}
