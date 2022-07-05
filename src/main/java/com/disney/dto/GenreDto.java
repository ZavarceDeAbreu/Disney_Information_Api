package com.disney.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.disney.entity.MovieSeriesEntity;

import lombok.Data;

@Data
public class GenreDto {

	private Long id;
	
	@NotEmpty
	@Size(min = 2, message = "El nombre del genero  debe tener al menos 2 caracteres")
	private String name;
	
	private String image;
	
	private List <MovieSeriesEntity> moviesSeries;
}
