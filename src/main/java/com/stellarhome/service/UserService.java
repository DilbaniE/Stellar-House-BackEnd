package com.stellarhome.service;

import com.stellarhome.model.UserEntity;
import com.stellarhome.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    public Optional< List<UserEntity>> getAllUsers(){
        List<UserEntity> users = iUserRepository.findAll();
        return users.isEmpty() ? Optional.empty() : Optional.of(users);
    }

    public Optional<UserEntity> getUserByDni(String dni, String kDni) {
        return Optional.of(UserEntity.builder().build());
        //return iUserRepository.findByDniAndKDni(dni, kDni);
    }

    public Optional<UserEntity> createUser(UserEntity userEntity){
        Optional<UserEntity> existingUser = Optional.of(UserEntity.builder().build());//iUserRepository.findByDniAndKDni(userEntity.getDni(), userEntity.getKDni());
        if(existingUser.isPresent()){
            return Optional.empty();
        }else{
            UserEntity userSave = iUserRepository.save(userEntity);
            return Optional.of(userSave);
        }

    }

    public Optional<UserEntity> updateUser(String dni, String kDni, UserEntity userEntity){
        Optional<UserEntity> userExisting = Optional.of(UserEntity.builder().build());//iUserRepository.findByDniAndKDni(dni,kDni);
        if(userExisting.isPresent()){
            UserEntity userToUpdate = userExisting.get();
            userToUpdate.setName(userEntity.getName());
            userToUpdate.setLastName(userEntity.getLastName());
            userToUpdate.setEmail(userEntity.getEmail());
            userToUpdate.setPassword(userEntity.getPassword());
            userToUpdate.setAddress(userEntity.getAddress());
            userToUpdate.setPhone(userEntity.getPhone());
            UserEntity updatedUser = iUserRepository.save(userToUpdate);
            return Optional.of(updatedUser);
        } else {
            return Optional.empty();
        }

    }

    public Optional<UserEntity> patchUser(String dni, String kDni, Map<String, Object> fields) {
        Optional<UserEntity> optionalUser = Optional.of(UserEntity.builder().build());//iUserRepository.findByDniAndKDni(dni, kDni);
        if (optionalUser.isPresent()) {
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

            UserEntity updatedUser = iUserRepository.save(userEntity);
            return Optional.of(updatedUser);
        }
        return Optional.empty();
    }
}

