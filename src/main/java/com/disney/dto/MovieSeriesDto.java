package com.disney.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.disney.entity.CharacterEntity;
import com.disney.entity.GenreEntity;

import lombok.Data;

@Data
public class MovieSeriesDto {

	private Long id;
	@NotEmpty
	@Size(min = 2, message = "El titulo de la pelicula  debe tener al menos 2 caracteres")
	private String title;
	private String image;
	private LocalDate creationDate;
	@DecimalMin("0.0")
	@DecimalMax("5.0")
	private float rating;
	private List<CharacterEntity> characters;
	private List<GenreEntity> genres;

}
