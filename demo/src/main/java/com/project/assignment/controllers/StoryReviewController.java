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
import com.project.assignment.models.request.ReviewReqModel;
import com.project.assignment.models.response.TopStoryReviews;
import com.project.assignment.services.StoryReviewService;

@RestController
@RequestMapping("/stories-reviews")
public class StoryReviewController {

	@Autowired
	StoryReviewService storyReviewService;
	
	@PostMapping("user/{id}/story/{storyId}")
	public ResponseEntity<Long> createReviewStory(@PathVariable("id") int userId,
			@PathVariable("storyId") int storyId,
		    @RequestBody @Valid ReviewReqModel reviewReqModel) {
		return new ResponseEntity<>(storyReviewService.createReviewStory(userId,storyId,reviewReqModel), HttpStatus.OK);
	}
	
	@GetMapping("/top-stories")
	public ResponseEntity<TopStoryReviews> getTopStoryReviews(
			@RequestParam(defaultValue = "10") Integer pageSize,
			 @RequestParam(defaultValue = "0") Integer pageIndex,
			 @RequestParam(required = false) String sortField,
			 @RequestParam(required = false) String sortOrder)
			throws JsonProcessingException {

		return new ResponseEntity<>(
				storyReviewService.getTopStoryReviews(pageSize, pageIndex, sortField, sortOrder), HttpStatus.OK);
	}
	
}
