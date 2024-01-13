package com.project.assignment.models.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class StoryReqModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2516652126657920518L;
	private String body;
	private String title;

}
