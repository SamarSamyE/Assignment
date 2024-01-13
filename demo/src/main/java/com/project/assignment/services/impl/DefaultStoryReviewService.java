package com.project.assignment.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.assignment.entities.Story;
import com.project.assignment.entities.User;
import com.project.assignment.entities.storyReview;
import com.project.assignment.models.mapinterface.StoryReviewMapper;
import com.project.assignment.models.request.ReviewReqModel;
import com.project.assignment.models.response.TopStoryReviews;
import com.project.assignment.models.response.UserStoriesAndCountResModel;
import com.project.assignment.repositories.StoryRepository;
import com.project.assignment.repositories.StoryReviewRepositroy;
import com.project.assignment.repositories.UserRepository;
import com.project.assignment.services.StoryReviewService;

@Service
public class DefaultStoryReviewService implements StoryReviewService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	StoryRepository storyRepository;
	@Autowired
	StoryReviewRepositroy storyReviewRepositroy;
	@Autowired
	StoryReviewMapper storyReviewMapper;
	
	@Override
	public Long createReviewStory(int userId, int storyId, ReviewReqModel storyReqModel) {
		storyReview storyReview= new storyReview();
		User user=userRepository.findById(userId).get();
		Story story=storyRepository.findById(storyId).get();
		storyReview.setStory(story);
		storyReview.setUser(user);
		mapStoryReviewReqModelToStoryReview(storyReview,storyReqModel);
		storyReviewRepositroy.save(storyReview);
		return (long) storyReview.getId();
	}
	
	private void mapStoryReviewReqModelToStoryReview(storyReview storyReview, ReviewReqModel storyReqModel) {
		storyReview.setComment(storyReqModel.getComment());
		storyReview.setRating(storyReqModel.getRating());
		storyReview.setReviewDate(LocalDateTime.now());
	}

	@Override
	public TopStoryReviews getTopStoryReviews(Integer pageSize, Integer pageIndex, String sortField, String sortOrder) {
		Pageable pageableRequest = null;
		if (sortField != null && !sortField.isBlank() && sortOrder != null && !sortOrder.isBlank())
			pageableRequest = PageRequest.of(pageIndex, pageSize,
					sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending()
							: Sort.by(sortField).descending());
		else
			pageableRequest = PageRequest.of(pageIndex, pageSize);

		Page<storyReview> topStories = storyReviewRepositroy.findAllByOrderByRatingDesc(pageableRequest);
	
		if (topStories.hasContent()) {
			return new TopStoryReviews(topStories.getTotalElements(),
					storyReviewMapper.mapToStoryReviewResModel(topStories.getContent()));
		}

		return new TopStoryReviews(0, new ArrayList<>());
	}

	@Override
	public Long createReviewStory() {
		List<User> allUsers = (List<User>) userRepository.findAll();
		List<Story> allStories = (List<Story>) storyRepository.findAll();
		storyReview storyReview= new storyReview();
		Random random = new Random();
		int randomUserIndex = random.nextInt(allUsers.size());
		int randomStoryIndex = random.nextInt(allStories.size());
		User randomUser = allUsers.get(randomUserIndex);
		Story randomStory = allStories.get(randomStoryIndex);
		storyReview.setComment(generateRandomComment());
		storyReview.setRating(generateRandomRating());
		storyReview.setReviewDate(LocalDateTime.now());
		storyReview.setStory(randomStory);
		storyReview.setUser(randomUser);
		
		storyReviewRepositroy.save(storyReview);
		return (long) storyReview.getId();
	}
	
	
	private String generateRandomComment() {
	    return "Random Comment ";
	}

	private int generateRandomRating() {
	    return new Random().nextInt(5) + 1;
	}

}
