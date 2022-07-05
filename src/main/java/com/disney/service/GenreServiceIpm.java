package com.disney.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.dto.GenreDto;
import com.disney.entity.GenreEntity;
import com.disney.exceptions.ResourceNotFoundException;
import com.disney.mapper.GenreMapper;
import com.disney.repository.GenreRepository;

@Service
public class GenreServiceIpm implements GenreService {

	@Autowired
	GenreRepository genreRepo;
	
	@Autowired
	GenreMapper genreMap;

	@Override
	public GenreDto save(GenreDto genreDto) {
		GenreEntity genere = genreMap.mapEntity(genreDto);
		return genreMap.mapDTO(genreRepo.save(genere));
	}

	@Override
	public GenreDto update(Long id, GenreDto genreDto) {
		GenreEntity genere = genreRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Genre", "id", id));
		genere.setImage(genreDto.getImage());
		genere.setName(genreDto.getName());
		genreRepo.save(genere);
		return genreMap.mapDTO(genere);
	}

	@Override
	public void delete(Long id) {
		GenreEntity genere = genreRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Genre", "id", id));
		genreRepo.delete(genere);
	}

	@Override
	public GenreDto get(Long id) {
		GenreEntity genre = genreRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Genre", "id", id));
		return genreMap.mapDTO(genre);
	}

	@Override
	public List<GenreDto> getAllGenre() {
		List<GenreEntity> genres = genreRepo.findAll();
		return genres.stream().map(genre -> genreMap.mapDTO(genre)).collect(Collectors.toList());
	}
}
