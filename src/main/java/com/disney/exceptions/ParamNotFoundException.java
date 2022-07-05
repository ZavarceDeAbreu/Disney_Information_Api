package com.disney.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ParamNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParamNotFoundException(String error) {
		super(error);
	}

}
