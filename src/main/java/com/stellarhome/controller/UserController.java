package com.stellarhome.controller;

import com.stellarhome.model.UserEntity;
import com.stellarhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/createUser")
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        return userService.saveUser(userEntity);
    }
    @GetMapping("/getUser")
    public UserEntity getUser(@PathVariable Integer id){
        return userService.getById(id);
    }

    @GetMapping("/getAll")
    public List<UserEntity> getAllUsers(){
        return userService.getAll();
    }
    @PutMapping("/updateUser")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Integer id, @RequestBody UserEntity userEntity){
        UserEntity userUpdate = userService.updateUser(id, userEntity);
        if(userUpdate != null){
            return ResponseEntity.ok(userUpdate);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/patchUser")
    public ResponseEntity<UserEntity> patchUser(@PathVariable Integer id, @RequestBody Map<String, Object> fields){
        UserEntity userUpdatePacth = userService.patchUser(id, fields);
        if(userUpdatePacth != null){
            return ResponseEntity.ok(userUpdatePacth);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }


}
