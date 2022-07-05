package com.disney.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BugDetailDto {

	private Date timesTamp;
	private String message;
	private String details;

}
