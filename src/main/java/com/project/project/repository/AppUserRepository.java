package com.project.project.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.project.model.AppUser;

@RepositoryRestResource(exported = false)
public interface AppUserRepository extends CrudRepository<AppUser,Integer> {

    Optional<AppUser> findByUsername(String username);

}
