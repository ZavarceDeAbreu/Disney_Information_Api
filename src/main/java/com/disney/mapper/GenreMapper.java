package com.disney.mapper;

import org.springframework.stereotype.Component;

import com.disney.dto.GenreDto;
import com.disney.entity.GenreEntity;

@Component
public class GenreMapper {

	// Convertimos de DTO a enidad
	public GenreEntity mapEntity(GenreDto genereDto) {
		GenreEntity genre = new GenreEntity();
		genre.setImage(genereDto.getImage());
		genre.setName(genereDto.getName());
		genre.setMoviesSeries(genereDto.getMoviesSeries());
		return genre;
	}

	// Convertimos de DTO a enidad
	public GenreDto mapDTO(GenreEntity genere) {
		GenreDto genreDto = new GenreDto();
		genreDto.setId(genere.getId());
		genreDto.setImage(genere.getImage());
		genreDto.setName(genere.getName());
		genreDto.setMoviesSeries(genere.getMoviesSeries());
		return genreDto;
	}

}
