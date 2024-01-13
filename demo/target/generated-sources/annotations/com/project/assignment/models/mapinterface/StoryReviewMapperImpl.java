package com.project.assignment.models.mapinterface;

import com.project.assignment.entities.Story;
import com.project.assignment.entities.User;
import com.project.assignment.entities.storyReview;
import com.project.assignment.models.response.StoryResModel;
import com.project.assignment.models.response.StoryReviewResModel;
import com.project.assignment.models.response.UserResModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-13T23:13:06+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class StoryReviewMapperImpl implements StoryReviewMapper {

    @Override
    public StoryReviewResModel mapToStoryReviewResModel(storyReview story) {
        if ( story == null ) {
            return null;
        }

        StoryReviewResModel storyReviewResModel = new StoryReviewResModel();

        storyReviewResModel.setComment( story.getComment() );
        storyReviewResModel.setRating( story.getRating() );
        storyReviewResModel.setReviewDate( story.getReviewDate() );
        storyReviewResModel.setStory( storyToStoryResModel( story.getStory() ) );

        return storyReviewResModel;
    }

    @Override
    public List<StoryReviewResModel> mapToStoryReviewResModel(List<storyReview> stories) {
        if ( stories == null ) {
            return null;
        }

        List<StoryReviewResModel> list = new ArrayList<StoryReviewResModel>( stories.size() );
        for ( storyReview storyReview : stories ) {
            list.add( mapToStoryReviewResModel( storyReview ) );
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

    protected StoryResModel storyToStoryResModel(Story story) {
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
}
