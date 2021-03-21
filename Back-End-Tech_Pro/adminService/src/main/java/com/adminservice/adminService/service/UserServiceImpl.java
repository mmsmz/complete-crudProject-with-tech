package com.adminservice.adminService.service;

import com.adminservice.adminService.dto.UserDto;
import com.adminservice.adminService.entity.UserEntity;
import com.adminservice.adminService.repository.UserRepository;
import com.adminservice.adminService.util.AdminCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUserDetails(UserDto userDto) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDto.getUserId());
        userEntity.setUserName(userDto.getUserName());
        userEntity.setMobileNo(userDto.getMobileNo());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setUserType(userDto.getUserType());
        userEntity.setLoginStatus((byte) 1); // static
        userRepository.save(userEntity);
        return AdminCommon.INSERTED;
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<UserEntity> userEntity = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        try {
            for (UserEntity users : userEntity) {
                UserDto userDto = new UserDto();
                userDto.setUserId(users.getUserId());
                userDto.setUserName(users.getUserName());
                userDto.setMobileNo(users.getMobileNo());
                userDto.setEmail(users.getEmail());
                userDto.setUserType(users.getUserType());
                userDto.setLoginStatus(users.getLoginStatus());
                userDtos.add(userDto);

            }
        } catch (Exception e) {
            e.getMessage();
        }

        return userDtos;
    }

    @Override
    public UserDto findByUserId(Integer userId) {

        UserEntity userEntity = userRepository.findById(userId).get();
        UserDto userDto = new UserDto();

        userDto.setUserId(userEntity.getUserId());
        userDto.setUserName(userEntity.getUserName());
        userDto.setMobileNo(userEntity.getMobileNo());
        userDto.setEmail(userEntity.getEmail());
        userDto.setUserType(userEntity.getUserType());
        userDto.setLoginStatus(userEntity.getLoginStatus());

        return userDto;
    }

    @Override
    public String updateUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(userDto.getUserId());
        userEntity.setUserName(userDto.getUserName());
        userEntity.setMobileNo(userDto.getMobileNo());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setUserType(userDto.getUserType());
        userEntity.setLoginStatus(userDto.getLoginStatus());

        userRepository.save(userEntity);
        return AdminCommon.UPDATED;
    }

    @Override
    public String deleteUser(Integer userId) {
        UserEntity userEntity = userRepository.findById(userId).get();
        UserDto userDto = new UserDto();
        userDto.setUserId(userEntity.getUserId());
//        userDto.setUserName(userEntity.getUserName());
//        userDto.setMobileNo(userEntity.getMobileNo());
//        userDto.setEmail(userEntity.getEmail());
//        userDto.setUserType(userEntity.getUserType());
//        userDto.setLoginStatus(userEntity.getLoginStatus());
        userRepository.delete(userEntity);

        return AdminCommon.DELETED;
    }

    @Override
    public String updateLoginStatus(Integer userId, Byte loginStatus) {

        UserEntity userEntity = userRepository.findById(userId).get();

        UserEntity userDto = new UserEntity();
        userDto.setUserId(userEntity.getUserId());
        userDto.setUserName(userEntity.getUserName());
        userDto.setMobileNo(userEntity.getMobileNo());
        userDto.setEmail(userEntity.getEmail());
        userDto.setUserType(userEntity.getUserType());
        userDto.setLoginStatus(loginStatus);

        userRepository.save(userDto);
        return AdminCommon.LOGINSTATUS;
    }

}
