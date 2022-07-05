package com.disney.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "CHARACTERS_ENTITY")
public class CharacterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_characters")
	private Long id;
	
	@Column(columnDefinition="TEXT")
	@NotBlank(message = "El campo 'image' no puede estar en blanco")
	private String image;
	
	@Column(unique = true , length = 30)
	@NotBlank(message = "El campo 'name' no puede estar en blanco")
	private String name;
	
	@Column(length = 5)
	private Integer age;
	
	@DecimalMin("0.0")
	private Float weight;
	
	@Column(columnDefinition="TEXT")
	private String history;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,  cascade = { CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "CHARACTERS_MOVIE", joinColumns = @JoinColumn(name = "id_characters"), inverseJoinColumns = @JoinColumn(name = "id_movie_series"))
	private List<MovieSeriesEntity> movieSeries;
	

}
