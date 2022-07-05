package com.disney.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.dto.MovieSeriesDto;
import com.disney.entity.CharacterEntity;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long>{
	
    List<CharacterEntity> findByName(String name);

	List<CharacterEntity> findByAge(Integer age);

	List<CharacterEntity> findByMovieSeriesId(Long movieSeries);

	List<MovieSeriesDto> findAllById(Long characterId);
	
}
