package com.disney.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.entity.RolEntity;


@Repository
public interface RolEntityRepository extends JpaRepository<RolEntity, Long> {

	public Optional<RolEntity> findByName(String name);
	
}
