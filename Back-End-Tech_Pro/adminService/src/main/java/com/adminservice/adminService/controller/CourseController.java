package com.adminservice.adminService.controller;

import com.adminservice.adminService.dto.CourseDto;
import com.adminservice.adminService.dto.ResponseDto;
import com.adminservice.adminService.service.CourseService;
import com.adminservice.adminService.util.AdminCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adminService/Course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(name = "/addCourseDetails", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseDto> addCourseDetails(@RequestBody CourseDto courseDto){

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(AdminCommon.SUCCESS);
        responseDto.setData(courseService.addCourseDetails(courseDto));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @RequestMapping(name = "/getAllCourses", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ResponseDto> getAllCourses(){

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(AdminCommon.SUCCESS);
        responseDto.setData(courseService.getAllCourses());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping(value = "/findByCourseId", produces = "application/json")
    public ResponseEntity<ResponseDto> findByCourseId(@RequestParam Integer courseId){

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(AdminCommon.SUCCESS);
        responseDto.setData(courseService.findByCourseId(courseId));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping(value = "/updateCourse", produces = "application/json")
    public ResponseEntity<ResponseDto> updateCourse(@RequestBody CourseDto courseDto) {
        ResponseDto responseDTO = new ResponseDto();
        responseDTO.setMessage("Success");
        responseDTO.setData(courseService.updateCourse(courseDto));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteCourse", produces = "application/json")
    public ResponseEntity<ResponseDto> deleteCourse(@RequestParam Integer courseId) {
        ResponseDto responseDTO = new ResponseDto();
        responseDTO.setMessage("Success");
        responseDTO.setData(courseService.deleteCourse(courseId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/updateOrderStatus", produces = "application/json")
    public ResponseEntity<ResponseDto> updateOrderStatus(@RequestParam Integer courseId, Byte orderStatus) {
        ResponseDto responseDTO = new ResponseDto();
        responseDTO.setMessage("Success");
        responseDTO.setData(courseService.updateOrderStatus(courseId, orderStatus));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
