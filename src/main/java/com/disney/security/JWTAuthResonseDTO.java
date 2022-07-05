package com.disney.security;

import lombok.Data;

@Data
public class JWTAuthResonseDTO {

	private String accessToken;
	private String tokenType = "Bearer";

	public JWTAuthResonseDTO(String accessToken) {
		super();
		this.accessToken = accessToken;
	}

}
