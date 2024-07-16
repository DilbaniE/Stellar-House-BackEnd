package com.stellarhome.controller;

import com.stellarhome.model.UserEntity;
import com.stellarhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        return service.getAllUsers()
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/{dni}/{kDni}")
    public ResponseEntity<UserEntity> getUserByDni(@PathVariable String dni, @PathVariable String kDni){
       return service.getUserByDni(dni, kDni)
               .map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        Optional<UserEntity> saveUser = service.createUser(userEntity);
        return saveUser
                .map(user -> ResponseEntity.status(HttpStatus.CREATED).body(user))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/{dni}/{kDni}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable String dni, @PathVariable String kDni, @RequestBody UserEntity userEntity){
        Optional<UserEntity> updateUser = service.updateUser(dni, kDni, userEntity);
        return updateUser
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{dni}/{kDni}")
    public ResponseEntity<UserEntity> patchUser(@PathVariable String dni, @PathVariable String kDni, @RequestBody Map<String, Object> fields){
       Optional<UserEntity> patchUser = service.patchUser(dni, kDni, fields);
       return patchUser
               .map(ResponseEntity::ok)
               .orElseGet(()-> ResponseEntity.notFound().build());

    }


}
