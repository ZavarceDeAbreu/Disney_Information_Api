package com.disney.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.dto.MovieSeriesDto;
import com.disney.entity.CharacterEntity;
import com.disney.entity.MovieSeriesEntity;
import com.disney.exceptions.ParamNotFoundException;
import com.disney.exceptions.ResourceNotFoundException;
import com.disney.mapper.MovieSeriesMapper;
import com.disney.repository.CharacterRepository;
import com.disney.repository.MovieSeriesRepository;

@Service
public class MovieSeriesServiceIpm implements MovieSeriesService {

	@Autowired
	MovieSeriesRepository movieSeriesRepo;
	@Autowired
	private CharacterRepository characterRepo;

	@Autowired
	private MovieSeriesMapper movieSeriesMap;

	@Override
	public MovieSeriesDto save(MovieSeriesDto movieSeriesDto) {
		MovieSeriesEntity movieSeries = movieSeriesMap.mapEntity(movieSeriesDto);
		return movieSeriesMap.mapDTO(movieSeriesRepo.save(movieSeries));
	}

	@Override
	public MovieSeriesDto update(Long id, MovieSeriesDto movieSeriesDto) {
		MovieSeriesEntity movieSeries = movieSeriesRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
		movieSeries.setImage(movieSeriesDto.getImage());
		movieSeries.setTitle(movieSeriesDto.getTitle());
		movieSeries.setCreationDate(movieSeriesDto.getCreationDate());
		movieSeries.setRating(movieSeriesDto.getId());

		return movieSeriesMap.mapDTO(movieSeriesRepo.save(movieSeries));
	}

	@Override
	public void delete(Long id) {
		MovieSeriesEntity movieSeries = movieSeriesRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
		movieSeriesRepo.delete(movieSeries);
	}

	@Override
	public MovieSeriesDto get(Long id) {
		MovieSeriesEntity movieSeries = movieSeriesRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
		return movieSeriesMap.mapDTO(movieSeries);
	}

	@Override
	public List<MovieSeriesDto> getAllMovieSeries() {
		List<MovieSeriesEntity> movies = movieSeriesRepo.findAll();
		return movies.stream().map(movie -> movieSeriesMap.mapDTO(movie)).collect(Collectors.toList());
	}

	@Override
	public List<MovieSeriesDto> findByName(String title) {
		List<MovieSeriesEntity> movieSeries = movieSeriesRepo.findByTitle(title);
		if (movieSeries.isEmpty()) {
			throw new ParamNotFoundException("Error: Invalid movie title");
		}
		return movieSeries.stream().map(movieSerie -> movieSeriesMap.mapDTO(movieSerie)).collect(Collectors.toList());
	}

	@Override
	public List<MovieSeriesDto> findByGenreId(Long genreId) {
		List<MovieSeriesEntity> movieSeries = movieSeriesRepo.findByGenresId(genreId);

		if (movieSeries.isEmpty()) {
			throw new ParamNotFoundException("Error: Invalid movie genre");
		}

		return movieSeries.stream().map(movieSerie -> movieSeriesMap.mapDTO(movieSerie)).collect(Collectors.toList());
	}

	@Override
	public List<MovieSeriesDto> findAllByOrder(String order) {
		List<MovieSeriesEntity> movieSeries;

		if (order.equals("ASC")) {
			movieSeries = movieSeriesRepo.findAllByOrderByCreationDateDesc();
			return movieSeries.stream().map(movieSerie -> movieSeriesMap.mapDTO(movieSerie))
					.collect(Collectors.toList());
		}

		if (order.equals("DESC")) {
			movieSeries = movieSeriesRepo.findAllByOrderByCreationDateDesc();
			return movieSeries.stream().map(movieSerie -> movieSeriesMap.mapDTO(movieSerie))
					.collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public void addCharacter(Long movieId, Long characterid) {
		MovieSeriesEntity movieSeries = movieSeriesRepo.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

		CharacterEntity character = characterRepo.findById(characterid)
				.orElseThrow(() -> new ResourceNotFoundException("character", "id", characterid));

		movieSeries.getCharacters().add(character);

		movieSeriesRepo.save(movieSeries);

	}


    
	@Override
	public void deleteCharacter(Long movieId, Long characterid) {
		MovieSeriesEntity movieSeries = movieSeriesRepo.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));
		
		movieSeries.getCharacters().removeIf(charac -> characterRepo.existsById(characterid)); 
		
		movieSeriesRepo.save(movieSeries);
		
	}

}
