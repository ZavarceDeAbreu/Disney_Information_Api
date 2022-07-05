package com.disney.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.entity.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

	public Optional<UserEntity> findByEmail(String email);

	public Optional<UserEntity> findByUsernameOrEmail(String userName, String email);

	public Optional<UserEntity> findByUsername(String userName);

	public Boolean existsByUsername(String username);
	
	public Boolean existsByEmail(String email);
}
