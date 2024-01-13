package com.project.assignment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.assignment.models.request.StoryReqModel;
import com.project.assignment.models.response.UserStoriesAndCountResModel;
import com.project.assignment.services.StoryService;

@RestController
@RequestMapping("/user")
public class StoryController {

	@Autowired
	StoryService storyService;
	
	@PostMapping("/{id}/story")
	public ResponseEntity<Long> createStory(@PathVariable("id") int userId,
		     @RequestBody @Valid StoryReqModel storyReqModel) {
		return new ResponseEntity<>(storyService.createStory(userId,storyReqModel), HttpStatus.OK);
	}

	@GetMapping("/{id}/stories")
	public ResponseEntity<UserStoriesAndCountResModel> getUserStories(
			@PathVariable("id") int userId,
			@RequestParam(defaultValue = "10") Integer pageSize,
			 @RequestParam(defaultValue = "0") Integer pageIndex,
			 @RequestParam(required = false) String sortField,
			 @RequestParam(required = false) String sortOrder)
			throws JsonProcessingException {

		return new ResponseEntity<>(
				storyService.getUserStories(userId,pageSize, pageIndex, sortField, sortOrder), HttpStatus.OK);
	}
	
}
