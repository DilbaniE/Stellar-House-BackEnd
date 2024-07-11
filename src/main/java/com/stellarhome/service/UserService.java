package com.stellarhome.service;

import com.stellarhome.model.UserEntity;
import com.stellarhome.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    public ResponseEntity< List<UserEntity>> getAllUsers(){
        List<UserEntity> users = iUserRepository.findAll();
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<UserEntity> getUserByDni(String dni, String kDni) {
        Optional<UserEntity> optionalUser = iUserRepository.findByDniAndKDni(dni, kDni);
        return optionalUser
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build())
        ;

    }
    public ResponseEntity<?> saveUser(UserEntity userEntity){
        Optional<UserEntity> existingUser = iUserRepository.findByDniAndKDni(userEntity.getDni(), userEntity.getKDni());
        if(existingUser.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("user exists");
        }else{
            UserEntity userSave = iUserRepository.save(userEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
        }

    }

    public ResponseEntity<UserEntity> updateUser(String dni, String kDni, UserEntity userEntity){
        Optional<UserEntity> userExisting = iUserRepository.findByDniAndKDni(dni,kDni);
        if(userExisting.isPresent()){
            UserEntity userToUpdate = userExisting.get();
            userToUpdate.setName(userEntity.getName());
            userToUpdate.setLastName(userEntity.getLastName());
            userToUpdate.setEmail(userEntity.getEmail());
            userToUpdate.setPassword(userEntity.getPassword());
            userToUpdate.setAddress(userEntity.getAddress());
            userToUpdate.setPhone(userEntity.getPhone());
            UserEntity updatedUser = iUserRepository.save(userToUpdate);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    public UserEntity patchUser(String dni, String kDni, Map<String, Object> fields){
        Optional<UserEntity> optionalUser = iUserRepository.findByDniAndKDni(dni, kDni);
        if(optionalUser.isPresent()){
            UserEntity userEntity = optionalUser.get();
            if (fields.containsKey("name")) {
                userEntity.setName((String) fields.get("name"));
            }
            if (fields.containsKey("lastName")) {
                userEntity.setLastName((String) fields.get("lastName"));
            }
            if (fields.containsKey("email")) {
                userEntity.setEmail((String) fields.get("email"));
            }
            if (fields.containsKey("password")) {
                userEntity.setPassword((String) fields.get("password"));
            }
            if (fields.containsKey("address")) {
                userEntity.setAddress((String) fields.get("address"));
            }
            if (fields.containsKey("phone")) {
                userEntity.setPhone((String) fields.get("phone"));
            }

            return iUserRepository.save(userEntity);
        }
        return null;
        }

    }

}
