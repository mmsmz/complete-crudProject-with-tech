package com.adminservice.adminService.service;

import com.adminservice.adminService.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    String addUserDetails(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto findByUserId(Integer userId);

    String updateUser(UserDto userDto);

    String deleteUser(Integer userId);

    String updateLoginStatus(Integer userId, Byte loginStatus);

}
