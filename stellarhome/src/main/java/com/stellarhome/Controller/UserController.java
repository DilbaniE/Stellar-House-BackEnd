package com.stellarhome.controller;

import com.stellarhome.DTO.UserDTO;
import com.stellarhome.endPoints.IUserEndPoint;
import com.stellarhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IUserEndPoint.USER_BASE_URL)
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(IUserEndPoint.USER_CREATE_URL)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO newUserEntity = userService.createUser(userDTO);
        return new ResponseEntity<>(newUserEntity, HttpStatus.CREATED);
    }

    @GetMapping(IUserEndPoint.USER_GET_ID_URL)
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Integer id){
        UserDTO userDTO = userService.userFindById(id);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }


}
