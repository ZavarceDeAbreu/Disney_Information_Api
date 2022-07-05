package com.disney.service;


import java.util.List;

import com.disney.dto.GenreDto;

public interface GenreService {

	public GenreDto save (GenreDto genreDto);
	
	public GenreDto update (Long id, GenreDto genreDto);
	
	public void delete (Long id);
	
	public GenreDto get(Long id);

	List<GenreDto> getAllGenre();

}
