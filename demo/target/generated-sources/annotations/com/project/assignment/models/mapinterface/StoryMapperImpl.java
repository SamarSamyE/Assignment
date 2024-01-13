package com.project.assignment.models.mapinterface;

import com.project.assignment.entities.Story;
import com.project.assignment.entities.User;
import com.project.assignment.models.response.StoryResModel;
import com.project.assignment.models.response.UserResModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-13T19:57:27+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class StoryMapperImpl implements StoryMapper {

    @Override
    public StoryResModel mapToStoryResModel(Story story) {
        if ( story == null ) {
            return null;
        }

        StoryResModel storyResModel = new StoryResModel();

        storyResModel.setBody( story.getBody() );
        storyResModel.setId( story.getId() );
        storyResModel.setStoryDate( story.getStoryDate() );
        storyResModel.setTitle( story.getTitle() );
        storyResModel.setUser( userToUserResModel( story.getUser() ) );

        return storyResModel;
    }

    @Override
    public List<StoryResModel> mapToStoryResModel(List<Story> stories) {
        if ( stories == null ) {
            return null;
        }

        List<StoryResModel> list = new ArrayList<StoryResModel>( stories.size() );
        for ( Story story : stories ) {
            list.add( mapToStoryResModel( story ) );
        }

        return list;
    }

    protected UserResModel userToUserResModel(User user) {
        if ( user == null ) {
            return null;
        }

        UserResModel userResModel = new UserResModel();

        userResModel.setId( user.getId() );
        userResModel.setUserName( user.getUserName() );

        return userResModel;
    }
}
