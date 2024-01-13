package com.project.assignment.models.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class StoryResModel implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -579806430297222513L;
	private int id;
	private String body;
	private String title;
	private UserResModel user;
	private LocalDateTime storyDate;

}
