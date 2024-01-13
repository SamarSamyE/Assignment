package com.project.assignment.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.project.assignment.entities.Story;

public interface StoryRepository extends CrudRepository<Story, Integer>{
	Page<Story> findByUserId(int userId,Pageable pageableRequest);

}
