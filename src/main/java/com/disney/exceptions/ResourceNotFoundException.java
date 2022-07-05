package com.disney.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	private long fieldVaulue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldVaulue) {
		super(String.format("%s No encontrado con : %s : '%s'", resourceName,fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldVaulue = fieldVaulue;
	}
	
	
	

}
