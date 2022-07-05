package com.disney.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney.dto.LoginDto;
import com.disney.dto.RegisterDto;
import com.disney.entity.RolEntity;
import com.disney.entity.UserEntity;
import com.disney.repository.RolEntityRepository;
import com.disney.repository.UserEntityRepository;
import com.disney.security.JWTAuthResonseDTO;
import com.disney.security.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserEntityRepository userRepo;

	@Autowired
	private RolEntityRepository rolRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@PostMapping("/login")
	ResponseEntity<JWTAuthResonseDTO> authenticateUser(@RequestBody LoginDto loginDto) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//Obtenemos un token de JwT
		String token = jwtTokenProvider.generateToken(authentication);
		
		return ResponseEntity.ok(new JWTAuthResonseDTO(token));
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterDto registerDto) {
		if (userRepo.existsByUsername(registerDto.getUsername()) || userRepo.existsByEmail(registerDto.getEmail())) {
			return new ResponseEntity<>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
		}

		UserEntity user = new UserEntity();
		user.setName(registerDto.getName());
		user.setUsername(registerDto.getUsername());
		user.setEmail(registerDto.getEmail());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

		RolEntity roles = rolRepo.findByName("ROLE_ADMIN").get();
		user.setRoles(Collections.singleton(roles));

		userRepo.save(user);
		return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.OK);
	}
}
