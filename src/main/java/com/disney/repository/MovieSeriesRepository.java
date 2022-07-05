package com.disney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.dto.MovieSeriesDto;
import com.disney.entity.MovieSeriesEntity;

@Repository
public interface MovieSeriesRepository extends JpaRepository<MovieSeriesEntity, Long> {

	List<MovieSeriesEntity> findByTitle(String title);

	List<MovieSeriesEntity> findByGenresId(Long genreId);

	List<MovieSeriesEntity> findAllByOrderByCreationDateAsc();

	List<MovieSeriesEntity> findAllByOrderByCreationDateDesc();

	MovieSeriesDto findByCharactersId(Long characterid);

}
