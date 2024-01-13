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
import com.project.assignment.models.mapinterface.StoryMapper;
import com.project.assignment.models.request.StoryReqModel;
import com.project.assignment.models.response.StoryResModel;
import com.project.assignment.models.response.UserStoriesAndCountResModel;
import com.project.assignment.repositories.StoryRepository;
import com.project.assignment.repositories.UserRepository;
import com.project.assignment.services.StoryService;

@Service
public class DefaultStoryService implements StoryService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	StoryRepository storyRepository;
	@Autowired
	StoryMapper storyMapper;
	
	@Override
	public Long createStory(int userId,StoryReqModel storyReqModel) {
		Story story= new Story();
		User user=userRepository.findById(userId).get();
		mapStoryReqModelToStory(user,story,storyReqModel);
		storyRepository.save(story);
		return (long) story.getId();
	}

	@Override
	public StoryResModel getStoryById(Long storyId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private void mapStoryReqModelToStory(User user,Story story,StoryReqModel storyReqModel) {
		story.setBody(storyReqModel.getBody());
		story.setTitle(storyReqModel.getTitle());
		story.setStoryDate(LocalDateTime.now());
		story.setUser(user);
	}

	@Override
	public UserStoriesAndCountResModel getUserStories(int userId,Integer pageSize, Integer pageIndex, String sortField,
			String sortOrder) {
		
		Pageable pageableRequest = null;
		if (sortField != null && !sortField.isBlank() && sortOrder != null && !sortOrder.isBlank())
			pageableRequest = PageRequest.of(pageIndex, pageSize,
					sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending()
							: Sort.by(sortField).descending());
		else
			pageableRequest = PageRequest.of(pageIndex, pageSize);

		Page<Story> userStories = storyRepository.findByUserId(userId, pageableRequest);
	
		if (userStories.hasContent()) {
			return new UserStoriesAndCountResModel(userStories.getTotalElements(),
					storyMapper.mapToStoryResModel(userStories.getContent()));
		}

		return new UserStoriesAndCountResModel(0, new ArrayList<>());
	}

	@Override
	public Long createStory() {
		Story story= new Story();
		List<User> allUsers = (List<User>) userRepository.findAll();
		Random random = new Random();
		int randomUserIndex = random.nextInt(allUsers.size());
		User randomUser = allUsers.get(randomUserIndex);
		story.setBody(generateRandomBody() );
		story.setTitle(generateRandomTitle());
		story.setStoryDate(LocalDateTime.now());
		story.setUser(randomUser);
		storyRepository.save(story);
		return (long) story.getId();
	}
	
	
	private String generateRandomBody() {
	    return "Random Body ";
	}

	private String generateRandomTitle() {
		  return "Random Title";
	}

}
