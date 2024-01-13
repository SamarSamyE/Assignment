package com.project.assignment.models.mapinterface;

import java.util.List;

import org.mapstruct.Mapper;

import com.project.assignment.entities.Story;
import com.project.assignment.models.response.StoryResModel;

@Mapper(componentModel = "spring")
public interface StoryMapper {
	StoryResModel mapToStoryResModel(Story story); 
	List<StoryResModel> mapToStoryResModel(List<Story> stories); 

}