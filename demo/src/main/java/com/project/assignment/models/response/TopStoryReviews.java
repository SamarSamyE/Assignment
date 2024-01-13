package com.project.assignment.models.response;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopStoryReviews implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4825810530050976899L;
	private long count;
	private List<StoryReviewResModel> rows;

}
