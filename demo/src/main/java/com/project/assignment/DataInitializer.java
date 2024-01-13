package com.project.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.project.assignment.repositories.StoryRepository;
import com.project.assignment.repositories.StoryReviewRepositroy;
import com.project.assignment.services.StoryReviewService;
import com.project.assignment.services.StoryService;

@Component
public class DataInitializer implements ApplicationRunner{

	@Autowired
	StoryService storyService;
	@Autowired
	StoryRepository storyRepository;
	@Autowired
	StoryReviewService storyReviewService;
	@Autowired
	StoryReviewRepositroy storyReviewRepository;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		seedData();
		
	}
	
	 private void seedData() {
	        // Logic to seed 50k posts
	        for (int i = 0; i < 50000; i++) {
	             storyService.createStory();

	            // Logic to seed more than 20k reviews for each post
	            for (int j = 0; j < 20000; j++) {
	            	storyReviewService.createReviewStory();
	            }
	        }
	    }

}
