package com.disney.service;

import java.util.List;

import com.disney.dto.MovieSeriesDto;

public interface MovieSeriesService {
	
	public MovieSeriesDto save (MovieSeriesDto movieSeriesDto);
	
	public MovieSeriesDto update (Long id, MovieSeriesDto movieSeriesDto);
	
	public void delete (Long id);
	
	public MovieSeriesDto get(Long id);
	
	public List<MovieSeriesDto> getAllMovieSeries();
	
	public List<MovieSeriesDto> findByName(String title);

	public List<MovieSeriesDto> findByGenreId(Long genereId);

	public List<MovieSeriesDto> findAllByOrder(String order);

	public void addCharacter(Long movieId, Long characterid);

	public void deleteCharacter(Long movieId, Long characterid);

	

	

	
}
