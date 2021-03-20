package com.homeservice.homeservice.repository;

import com.homeservice.homeservice.dto.CourseDTO;
import com.homeservice.homeservice.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {


}
