package com.project.assignment.models.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserResModel implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6691024594768419287L;
	private int id;
	private String userName;

}
