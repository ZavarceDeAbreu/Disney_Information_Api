package com.disney.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "GENRE_ENTITY", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class GenreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_genre")
	private Long id;

	@Column(length = 100)
	@NotBlank(message = "El campo 'name' no puede estar en blanco")
	private String name;

	@Column(columnDefinition="TEXT")
	private String image;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres", cascade = { CascadeType.MERGE, CascadeType.PERSIST})
	private List<MovieSeriesEntity> moviesSeries;
}
