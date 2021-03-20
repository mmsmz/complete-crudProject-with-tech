package com.homeservice.homeservice.repository;

import com.homeservice.homeservice.entity.ImgLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImgLocationRepository extends JpaRepository<ImgLocationEntity, Integer> {


}
