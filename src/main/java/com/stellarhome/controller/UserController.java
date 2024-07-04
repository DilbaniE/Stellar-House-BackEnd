package com.stellarhome.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping("/createUser")
   public ResponseEntity<String> createUser(){
       return null;
   }

    @GetMapping("/getUser")
    public ResponseEntity<String> getUser(){
        return null;
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(){
        return null;
    }

    @PatchMapping("/patchUser")
    public ResponseEntity<String> patchUser(){
        return null;
    }

    @ DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(){
        return null;
    }


}
