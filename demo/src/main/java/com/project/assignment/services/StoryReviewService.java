package com.project.assignment.services;

import com.project.assignment.models.request.ReviewReqModel;
import com.project.assignment.models.response.TopStoryReviews;

public interface StoryReviewService {

	Long createReviewStory(int userId,int storyId,ReviewReqModel storyReqModel);
	Long createReviewStory();
	TopStoryReviews getTopStoryReviews (Integer pageSize, Integer pageIndex, String sortField,	String sortOrder);
}
