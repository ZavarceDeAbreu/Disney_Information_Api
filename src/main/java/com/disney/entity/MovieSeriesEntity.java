package com.disney.entity;

import java.time.LocalDate;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "MOVIE_ENTITY", uniqueConstraints = { @UniqueConstraint(columnNames = { "title" }) })
public class MovieSeriesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movie_series")
	private Long id;

	@NotBlank(message = "El campo 'title' no puede estar en blanco")
	private String title;

	@Column(columnDefinition = "TEXT")
	private String image;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate creationDate;

	@DecimalMin("0.0")
	@DecimalMax("5.0")
	@NotNull(message = "El campo 'rating' no puede estar en blanco")
	private float rating;

	@ManyToMany(mappedBy = "movieSeries", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST})
	private List<CharacterEntity> characters;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "MOVIE_GENRE", joinColumns = @JoinColumn(name = "id_movie_series"), inverseJoinColumns = @JoinColumn(name = "id_genre"))
	private List<GenreEntity> genres;

}
