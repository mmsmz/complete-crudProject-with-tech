package com.userservice.userService.controller;

import com.userservice.userService.dto.CourseDto;
import com.userservice.userService.dto.ResponseDto;
import com.userservice.userService.dto.UserCourseDto;
import com.userservice.userService.dto.UserDto;
import com.userservice.userService.service.UserService;
import com.userservice.userService.util.UserCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/userService/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(name = "/addUserDetails", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseDto> addUserDetails(@RequestBody UserDto userDto){

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(UserCommon.SUCCESS);
        responseDto.setData(userService.addUserDetails(userDto));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @RequestMapping(name = "/getAllCourses", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ResponseDto> getAllCourses(){

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(UserCommon.SUCCESS);
        responseDto.setData(userService.getAllCourses());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping(value = "/findByCourseId", produces = "application/json")
    public ResponseEntity<ResponseDto> findByCourseId(@RequestParam Integer courseId){

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(UserCommon.SUCCESS);
        responseDto.setData(userService.findByCourseId(courseId));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/userSelectsMultipleCourse")
    public ResponseEntity<ResponseDto> userSelectsMultipleCourse(@RequestParam Integer userId, @RequestBody UserCourseDto courseList){

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(UserCommon.SUCCESS);

        responseDto.setData(userService.userSelectsMultipleCourse(userId,courseList));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
