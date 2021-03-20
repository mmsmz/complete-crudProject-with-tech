package com.homeservice.homeservice.service;


import com.homeservice.homeservice.dto.CourseDTO;
import com.homeservice.homeservice.dto.ImgLocationDTO;
import com.homeservice.homeservice.entity.CourseEntity;
import com.homeservice.homeservice.entity.ImgLocationEntity;
import com.homeservice.homeservice.repository.CourseRepository;
import com.homeservice.homeservice.repository.ImgLocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private ImgLocationRepository imgLocationRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<ImgLocationDTO> getAllImageLocation() {

        // get the data from the entity
       List<ImgLocationEntity> imgLocationEntity =  imgLocationRepository.findAll();
       // loop the data and add it to imgLocationDTOS
       List<ImgLocationDTO> imgLocationDTOS = new ArrayList<>();

        for (ImgLocationEntity imgLEntity: imgLocationEntity){
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
        List<CourseDTO> courseDTOS  =  new ArrayList<>();

        for (CourseEntity crsEntities : courseEntities)
        {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setCourseId(crsEntities.getCourseId());
            courseDTO.setCourseName(crsEntities.getCourseName());
            courseDTO.setCourseType(crsEntities.getCourseType());
            courseDTO.setCoursePrice(crsEntities.getCoursePrice());
            courseDTOS.add(courseDTO);
        }

        return courseDTOS;
    }
}
