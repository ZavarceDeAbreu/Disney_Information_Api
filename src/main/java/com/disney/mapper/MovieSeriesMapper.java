package com.disney.mapper;

import org.springframework.stereotype.Component;

import com.disney.dto.MovieSeriesDto;
import com.disney.entity.MovieSeriesEntity;

@Component
public class MovieSeriesMapper {

	//Convertimos de DTO a enidad
	public MovieSeriesEntity mapEntity (MovieSeriesDto movieSeriesDto) {
		MovieSeriesEntity movieSeries = new MovieSeriesEntity();
		movieSeries.setImage(movieSeriesDto.getImage());
		movieSeries.setTitle(movieSeriesDto.getTitle());
		movieSeries.setCreationDate(movieSeriesDto.getCreationDate());
		movieSeries.setRating(movieSeriesDto.getRating());
		movieSeries.setCharacters(movieSeriesDto.getCharacters());
		movieSeries.setGenres(movieSeriesDto.getGenres());
		return movieSeries;
	}
	
	//Convertimos de DTO a enidad
	public MovieSeriesDto mapDTO (MovieSeriesEntity movieSeries) {
		MovieSeriesDto movieSeriesDto= new MovieSeriesDto();
		movieSeriesDto.setId(movieSeries.getId());
		movieSeriesDto.setImage(movieSeries.getImage());
		movieSeriesDto.setTitle(movieSeries.getTitle());
		movieSeriesDto.setCreationDate(movieSeries.getCreationDate());
		movieSeriesDto.setRating(movieSeries.getRating());
		movieSeriesDto.setCharacters(movieSeries.getCharacters());
		movieSeriesDto.setGenres(movieSeries.getGenres());
		return movieSeriesDto;
	}


}
