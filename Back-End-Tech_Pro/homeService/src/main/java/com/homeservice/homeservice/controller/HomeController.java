package com.homeservice.homeservice.controller;

import com.homeservice.homeservice.dto.ResponseDTO;
import com.homeservice.homeservice.service.HomeService;
import com.homeservice.homeservice.util.HomeConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;


    @RequestMapping(name = "/getAllImageLocation", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ResponseDTO> getAllImageLocation(){

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(HomeConstant.SUCCESS);
        responseDTO.setData(homeService.getAllImageLocation());

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllCourseDetails")
    public ResponseEntity<ResponseDTO>  getAllCourseDetails(){

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(HomeConstant.SUCCESS);
        responseDTO.setData(homeService.getAllCourseList());

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }



}
