package com.userservice.userService.service;

import com.userservice.userService.dto.CourseDto;
import com.userservice.userService.dto.UserCourseDto;
import com.userservice.userService.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {

    String addUserDetails(UserDto userDto);

    List<CourseDto> getAllCourses();

    CourseDto findByCourseId(Integer courseId);

    String userSelectsMultipleCourse(Integer userId, UserCourseDto courseList);


}
