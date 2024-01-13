package com.project.assignment.models.mapinterface;

import com.project.assignment.entities.User;
import com.project.assignment.models.response.UserResModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-13T19:34:05+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResModel mapToUserResModel(User user) {
        if ( user == null ) {
            return null;
        }

        UserResModel userResModel = new UserResModel();

        userResModel.setId( user.getId() );
        userResModel.setUserName( user.getUserName() );

        return userResModel;
    }
}
