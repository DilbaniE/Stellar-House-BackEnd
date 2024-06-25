package com.stellarhome.service;

import com.stellarhome.DTO.UserDTO;
import com.stellarhome.model.UserEntity;
import com.stellarhome.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        // Convertir UserDTO a UserEntity
        UserEntity userEntity = UserEntity.builder()
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .address(userDTO.getAddress())
                .phone(userDTO.getPhone())
                .build();
        // Guardar UserEntity en la base de datos
        UserEntity savedEntity = iUserRepository.save(userEntity);
        // Convertir UserEntity a UserDTO
        UserDTO newUserDTO = UserDTO.builder()
                .id(savedEntity.getId())
                .name(savedEntity.getName())
                .lastName(savedEntity.getLastName())
                .email(savedEntity.getEmail())
                .password(savedEntity.getPassword())
                .address(savedEntity.getAddress())
                .phone(savedEntity.getPhone())
                .build();
        return newUserDTO;
    }


}
