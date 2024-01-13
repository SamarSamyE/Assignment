package com.project.assignment.models.mapinterface;

import java.util.List;

import org.mapstruct.Mapper;

import com.project.assignment.entities.storyReview;
import com.project.assignment.models.response.StoryReviewResModel;

@Mapper(componentModel = "spring")
public interface StoryReviewMapper {
	StoryReviewResModel mapToStoryReviewResModel(storyReview story); 
	List<StoryReviewResModel> mapToStoryReviewResModel(List<storyReview> stories); 
}
