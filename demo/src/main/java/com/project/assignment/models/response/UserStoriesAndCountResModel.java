package com.project.assignment.models.response;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserStoriesAndCountResModel implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -2869620941918334060L;
	private long count;
	private List<StoryResModel> rows;

}
