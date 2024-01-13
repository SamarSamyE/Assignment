package com.project.assignment.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.project.assignment.entities.storyReview;

public interface StoryReviewRepositroy extends CrudRepository<storyReview, Integer>{
	Page<storyReview> findAllByOrderByRatingDesc(Pageable pageableRequest);

}
