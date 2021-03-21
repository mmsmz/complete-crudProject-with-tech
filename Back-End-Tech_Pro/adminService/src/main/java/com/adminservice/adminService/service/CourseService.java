package com.adminservice.adminService.service;

import com.adminservice.adminService.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    String addCourseDetails(CourseDto courseDto);

    List<CourseDto> getAllCourses();

    CourseDto findByCourseId(Integer courseId);

    String updateCourse(CourseDto courseDto);

    String deleteCourse(Integer courseId);

    String updateOrderStatus(Integer courseId, Byte orderStatus);

}
