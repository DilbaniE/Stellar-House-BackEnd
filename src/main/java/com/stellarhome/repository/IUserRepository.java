package com.stellarhome.repository;

import com.stellarhome.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    // querys busquedas espesificas
    //Optional<UserEntity> findByDniAndKDni(String dni, String kDni);
}
