package com.project.assignment.services;

import com.project.assignment.models.request.StoryReqModel;
import com.project.assignment.models.response.StoryResModel;
import com.project.assignment.models.response.UserStoriesAndCountResModel;

public interface StoryService {

	Long createStory(int userId,StoryReqModel storyReqModel);
	Long createStory();
	StoryResModel getStoryById(Long storyId);
	UserStoriesAndCountResModel getUserStories(int userId,Integer pageSize, Integer pageIndex, String sortField,
			String sortOrder);

}
