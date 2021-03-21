package com.userservice.userService.service;

import com.adminservice.adminService.dto.CourseDto;
import com.adminservice.adminService.entity.CourseEntity;
import com.adminservice.adminService.repository.CourseRepository;
import com.adminservice.adminService.util.AdminCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String addCourseDetails(CourseDto courseDto) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseId(courseDto.getCourseId());
        courseEntity.setCourseName(courseDto.getCourseName());
        courseEntity.setCourseType(courseDto.getCourseType());
        courseEntity.setCoursePrice(courseDto.getCoursePrice());
        courseEntity.setOrderStatus((byte) 1); // static
        courseRepository.save(courseEntity);
        return AdminCommon.INSERTED;
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
    public String updateCourse(CourseDto courseDto) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseId(courseDto.getCourseId());
        courseEntity.setCourseName(courseDto.getCourseName());
        courseEntity.setCourseType(courseDto.getCourseType());
        courseEntity.setCoursePrice(courseDto.getCoursePrice());
        courseEntity.setOrderStatus(courseDto.getOrderStatus());

        courseRepository.save(courseEntity);
        return AdminCommon.UPDATED;
    }

    @Override
    public String deleteCourse(Integer courseId) {
        CourseEntity courseEntity = courseRepository.findById(courseId).get();
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(courseEntity.getCourseId());
        courseRepository.delete(courseEntity);

        return AdminCommon.DELETED;
    }

    @Override
    public String updateOrderStatus(Integer courseId, Byte orderStatus) {
        CourseEntity courseEntity = courseRepository.findById(courseId).get();

        CourseEntity course  = new CourseEntity();
        course.setCourseId(courseEntity.getCourseId());
        course.setCourseName(courseEntity.getCourseName());
        course.setCourseType(courseEntity.getCourseType());
        course.setCoursePrice(courseEntity.getCoursePrice());
        course.setOrderStatus(orderStatus);

        courseRepository.save(course);
        return AdminCommon.LOGINSTATUS;
    }

}
