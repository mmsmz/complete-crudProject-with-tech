package com.homeservice.homeservice.repository;

import com.homeservice.homeservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    //   UserEntity findByUserId(Integer userId);
//    UserEntity findByUserName(String username);

    List<UserEntity> findByEmail(String email);



}
