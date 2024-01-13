package com.project.assignment.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.assignment.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
