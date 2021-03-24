package com.homeservice.homeservice.service;


import com.homeservice.homeservice.dto.CourseDTO;
import com.homeservice.homeservice.dto.ImgLocationDTO;
import com.homeservice.homeservice.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HomeService {

    List<ImgLocationDTO> getAllImageLocation();

    List<CourseDTO> getAllCourseList();

    String register(UserDto userDto);

}
