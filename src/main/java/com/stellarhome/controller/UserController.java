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
import org.springframework.web.bind.annotation.PatchMapping;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        return service.getAllUsers();
    }
    @GetMapping("/{dni}/{kDni}")
    public ResponseEntity<UserEntity> getUserByDni(@PathVariable String dni, @PathVariable String kDni){
        return service.getUserByDni(dni, kDni);
    }
    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity){
        return service.saveUser(userEntity);
    }

    @PutMapping("/{dni}/{kDni}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable String dni, @PathVariable String kDni, @RequestBody UserEntity userEntity){
        return service.updateUser(dni,kDni,userEntity);
    }

    @PatchMapping("/{dni}/{kDni}")
    public ResponseEntity<UserEntity> patchUser(@PathVariable String dni, @PathVariable String kDni, @RequestBody Map<String, Object> fields){
        UserEntity userUpdatePatch = service.patchUser(dni,kDni,fields);
        if(userUpdatePatch != null){
            return ResponseEntity.ok(userUpdatePatch);
        }
        return ResponseEntity.notFound().build();
    }




}
