package com.adminservice.adminService.controller;

import com.adminservice.adminService.dto.ResponseDto;
import com.adminservice.adminService.dto.UserDto;
import com.adminservice.adminService.service.UserService;
import com.adminservice.adminService.util.AdminCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adminService")
@CrossOrigin(origins = "*")
public class UserController {

   //Implementing the following APIs
    /*   addUserDetails
         getAllUsers
         findByUserId
         updateUsers
         deleteUsers
         updateLoginStatus  : deactivate/activate users which means users cant login to the system */

    @Autowired
    private UserService userService;

    // @RequestMapping(name = "/addUserDetails", method = RequestMethod.POST, produces = "application/json")
    @PostMapping(value = "/addUserDetails", produces = "application/json")
    public ResponseEntity<ResponseDto> addUserDetails(@RequestBody UserDto userDto){

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(AdminCommon.SUCCESS);
        responseDto.setData(userService.addUserDetails(userDto));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

//    @RequestMapping(name = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
    @GetMapping(value = "/getAllUsers", produces = "application/json")
    public ResponseEntity<ResponseDto> getAllUsers(){

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(AdminCommon.SUCCESS);
        responseDto.setData(userService.getAllUsers());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping(value = "/findByUserId", produces = "application/json")
    public ResponseEntity<ResponseDto> findByUserId(@RequestParam Integer userid){

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(AdminCommon.SUCCESS);
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
