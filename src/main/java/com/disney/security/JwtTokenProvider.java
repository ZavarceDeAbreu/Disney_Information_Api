package com.disney.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.disney.exceptions.BlogAppException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	@Value("${app.jwt-secret}")
	private String jwtSecret;
	
	@Value("${app.jwt-expiration-milliseconds}")
	private int jwtExpirationInMs;
	
	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date currentDate = new Date();
		Date expirationDate = new Date(currentDate.getTime() + jwtExpirationInMs);
		String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		
		return token;
	}
	
	public String GetUsernameJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		}catch (MalformedJwtException ex) {
			throw new BlogAppException(HttpStatus.BAD_REQUEST,"Token JWT no valida");
		}
		catch (ExpiredJwtException ex) {
			throw new BlogAppException(HttpStatus.BAD_REQUEST,"Token JWT caducado");
		}
		catch (UnsupportedJwtException ex) {
			throw new BlogAppException(HttpStatus.BAD_REQUEST,"Token JWT no compatible");
		}
		catch (IllegalArgumentException ex) {
			throw new BlogAppException(HttpStatus.BAD_REQUEST,"La cadena claims JWT esta vacia");
		}
	}
}

