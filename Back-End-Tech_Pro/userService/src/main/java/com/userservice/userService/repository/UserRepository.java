package com.userservice.userService.repository;


import com.userservice.userService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

//   UserEntity findByUserId(Integer userId);

    UserEntity findByUserName(String username);
}
