package com.project.assignment.models.mapinterface;

import org.mapstruct.Mapper;

import com.project.assignment.entities.User;
import com.project.assignment.models.response.UserResModel;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserResModel mapToUserResModel(User user); 

}
