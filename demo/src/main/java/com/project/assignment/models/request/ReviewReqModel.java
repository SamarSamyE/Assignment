package com.project.assignment.models.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ReviewReqModel  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1384140952450423486L;
	
	@NotNull
	private String comment;
	
	@Min(1)
	@Max(5)
	private int rating;

}
