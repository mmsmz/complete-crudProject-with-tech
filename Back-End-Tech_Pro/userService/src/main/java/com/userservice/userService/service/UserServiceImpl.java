package com.userservice.userService.service;


import com.userservice.userService.dto.CourseDto;
import com.userservice.userService.dto.UserCourseDto;
import com.userservice.userService.dto.UserDto;
import com.userservice.userService.entity.CourseEntity;
import com.userservice.userService.entity.UserEntity;
import com.userservice.userService.entity.UsersCourseEntity;
import com.userservice.userService.repository.CourseRepository;
import com.userservice.userService.repository.UserCourseRepository;
import com.userservice.userService.repository.UserRepository;
import com.userservice.userService.util.UserCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserCourseRepository userCourseRepository;

    @Override
    public String addUserDetails(UserDto userDto) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDto.getUserId());
        userEntity.setUserName(userDto.getUserName());
        userEntity.setMobileNo(userDto.getMobileNo());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setUserType(userDto.getUserType());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setLoginStatus((byte) 1); // static
        userRepository.save(userEntity);
        return UserCommon.INSERTED;
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<CourseEntity> courseEntity = courseRepository.findAll();
        List<CourseDto> courseList = new ArrayList<>();

        try {
            for (CourseEntity users : courseEntity) {
                CourseDto courseDto = new CourseDto();
                courseDto.setCourseId(users.getCourseId());
                courseDto.setCourseName(users.getCourseName());
                courseDto.setCourseType(users.getCourseType());
                courseDto.setCoursePrice(users.getCoursePrice());
                courseDto.setOrderStatus(users.getOrderStatus());
                courseList.add(courseDto);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return courseList;
    }


    @Override
    public CourseDto findByCourseId(Integer courseId) {

        CourseEntity courseEntity = courseRepository.findById(courseId).get();

        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(courseEntity.getCourseId());
        courseDto.setCourseName(courseEntity.getCourseName());
        courseDto.setCourseType(courseEntity.getCourseType());
        courseDto.setCoursePrice(courseEntity.getCoursePrice());
        courseDto.setOrderStatus(courseEntity.getOrderStatus());

        return courseDto;
    }

    @Override
    public String userSelectsMultipleCourse(Integer userId, UserCourseDto courseList) {

        for (Integer userCourseDto : courseList.getCourseId()) {
            UsersCourseEntity courseEntity = new UsersCourseEntity();
            courseEntity.setUserId(userId);
            courseEntity.setCourseId(userCourseDto);
            userCourseRepository.save(courseEntity);
        }

        return UserCommon.SUCCESS;
    }


}
