package com.disney.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.disney.entity.MovieSeriesEntity;

import lombok.Data;

@Data
public class CharacterDto {

	private Long id;

	private String image;

	@NotEmpty
	@Size(min = 2, message = "El nombre del personaje  debe tener al menos 2 caracteres")
	private String name;

	private Integer age;

	private Float weight;

	@Size(min = 2, message = "La historia del personaje debe tener al menos 10 caracteres")
	private String history;

	private List<MovieSeriesEntity> movieSeries;

}
