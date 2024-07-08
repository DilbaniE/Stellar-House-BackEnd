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

    public List<UserEntity> getAll(){
        return iUserRepository.findAll();
    }

    public UserEntity getById(Integer id){
        return iUserRepository.findById(id).orElse(null);
    }

    public UserEntity saveUser(UserEntity userEntity){
        return iUserRepository.save(userEntity);
    }

    public UserEntity updateUser(Integer id, UserEntity userEntity){
        if(iUserRepository.existsById(id)){
            userEntity.setId(id);
            return iUserRepository.save(userEntity);
        }
        return null;
    }

    public UserEntity patchUser(Integer id, Map<String, Object> fields){
        Optional<UserEntity> optionalUser = iUserRepository.findById(id);
        if(optionalUser.isPresent()){
            UserEntity userEntity = optionalUser.get();
            fields.forEach((key, value) ->{
                switch (key){
                    case "name":
                        userEntity.setName((String) value);
                        break;
                    case "lastName":
                        userEntity.setLastName((String) value);
                        break;
                    case "email":
                        userEntity.setEmail((String) value);
                        break;
                    case "password":
                        userEntity.setPassword((String) value);
                        break;
                    case "address":
                        userEntity.setAddress((String) value);
                        break;
                    case "phone":
                        userEntity.setPhone((String) value);
                        break;
                    default:
                        break;
                }
            });
            return iUserRepository.save(userEntity);
        }
        return null;
    }
    public void deleteUser(Integer id){
        iUserRepository.deleteById(id);
    }
}
