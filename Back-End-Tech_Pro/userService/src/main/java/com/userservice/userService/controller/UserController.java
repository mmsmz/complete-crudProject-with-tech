package com.userservice.userService.controller;

import com.userservice.userService.dto.ResponseDto;
import com.userservice.userService.dto.UserDto;
import com.userservice.userService.service.UserService;
import com.userservice.userService.util.UserCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adminService/User")
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

    @RequestMapping(name = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ResponseDto> getAllUsers(){

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(UserCommon.SUCCESS);
        responseDto.setData(userService.getAllUsers());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping(value = "/findByUserId", produces = "application/json")
    public ResponseEntity<ResponseDto> findByUserId(@RequestParam Integer userid){

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(UserCommon.SUCCESS);
        responseDto.setData(userService.findByUserId(userid));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping(value = "/updateUser", produces = "application/json")
    public ResponseEntity<ResponseDto> updateUser(@RequestBody UserDto userDto) {
        ResponseDto responseDTO = new ResponseDto();
        responseDTO.setMessage("Success");
        responseDTO.setData(userService.updateUser(userDto));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser", produces = "application/json")
    public ResponseEntity<ResponseDto> deleteUser(@RequestParam Integer userid) {
        ResponseDto responseDTO = new ResponseDto();
        responseDTO.setMessage("Success");
        responseDTO.setData(userService.deleteUser(userid));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/updateLoginStatus", produces = "application/json")
    public ResponseEntity<ResponseDto> updateLoginStatus(@RequestParam Integer userId, Byte loginStatus) {
        ResponseDto responseDTO = new ResponseDto();
        responseDTO.setMessage("Success");
        responseDTO.setData(userService.updateLoginStatus(userId, loginStatus));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
