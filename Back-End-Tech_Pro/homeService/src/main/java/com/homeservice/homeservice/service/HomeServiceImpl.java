package com.homeservice.homeservice.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeservice.homeservice.dto.CourseDTO;
import com.homeservice.homeservice.dto.EmailMessageDto;
import com.homeservice.homeservice.dto.ImgLocationDTO;
import com.homeservice.homeservice.dto.UserDto;
import com.homeservice.homeservice.entity.CourseEntity;
import com.homeservice.homeservice.entity.ImgLocationEntity;
import com.homeservice.homeservice.entity.UserEntity;
import com.homeservice.homeservice.repository.CourseRepository;
import com.homeservice.homeservice.repository.ImgLocationRepository;

import com.homeservice.homeservice.repository.UserRepository;
import com.homeservice.homeservice.util.HomeConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private ImgLocationRepository imgLocationRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ImgLocationDTO> getAllImageLocation() {

        // get the data from the entity
        List<ImgLocationEntity> imgLocationEntity = imgLocationRepository.findAll();
        // loop the data and add it to imgLocationDTOS
        List<ImgLocationDTO> imgLocationDTOS = new ArrayList<>();

        for (ImgLocationEntity imgLEntity : imgLocationEntity) {
            ImgLocationDTO imgLDTO = new ImgLocationDTO();
            imgLDTO.setImgId(imgLEntity.getImgId());
            imgLDTO.setImgPath(imgLEntity.getImgPath());
            imgLocationDTOS.add(imgLDTO);
        }

        return imgLocationDTOS;
    }

    @Override
    public List<CourseDTO> getAllCourseList() {

        List<CourseEntity> courseEntities = courseRepository.findAll();
        List<CourseDTO> courseDTOS = new ArrayList<>();

        for (CourseEntity crsEntities : courseEntities) {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setCourseId(crsEntities.getCourseId());
            courseDTO.setCourseName(crsEntities.getCourseName());
            courseDTO.setCourseType(crsEntities.getCourseType());
            courseDTO.setCoursePrice(crsEntities.getCoursePrice());
            courseDTOS.add(courseDTO);
        }

        return courseDTOS;
    }

    @Override
    public String register(UserDto studentDto) throws JsonProcessingException {

        List<UserEntity> checkEmail = userRepository.findByEmail(studentDto.getEmail());
        if (checkEmail.isEmpty()) {
            UserEntity student = new UserEntity();
            student.setUserId(studentDto.getUserId());
            student.setUserName(studentDto.getUserName());
            student.setEmail(studentDto.getEmail());
            student.setMobileNo(studentDto.getMobileNo());
            student.setUserType(HomeConstant.TYPE_STUDENT);
            student.setPassword(studentDto.getPassword());
            student.setLoginStatus(HomeConstant.ACTIVATE);
            userRepository.save(student);

            // OTP Mail
            EmailMessageDto emailMessageDto = new EmailMessageDto();
            emailMessageDto.setToAddress(studentDto.getEmail());
            emailMessageDto.setSubject("TESTING");
            emailMessageDto.setBody("YOUR ACCOUNT IS ACTIVATED");

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(emailMessageDto);
            Map<String, Object> jsonVal = new ObjectMapper().readValue(json, HashMap.class);
            HttpEntity<Map> entity = new HttpEntity<>(jsonVal);


            // enter the mail service Url (API)
            String url = "http://localhost:8097/mailcontroller/send";
            restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();

            return HomeConstant.SUCCESS;
        }

        else {
            return "already email exists";
        }
    }
}
