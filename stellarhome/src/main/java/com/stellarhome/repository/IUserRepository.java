package com.stellarhome.repository;

import com.stellarhome.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Integer> {
    // queris busquedas espesificas
}
