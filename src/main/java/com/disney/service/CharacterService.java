package com.disney.service;

import java.util.List;

import com.disney.dto.CharacterDto;

public interface CharacterService {
	
	public CharacterDto save (CharacterDto characterDto);
	
	public CharacterDto update (Long id, CharacterDto characterDto);
	
	public void delete (Long id);
	
	public CharacterDto get(Long id);

	public List<CharacterDto> getAllCharacters();
	
	public List<CharacterDto> getByName(String name);
	
	public List<CharacterDto> getByAge(Integer age);

	public List<CharacterDto> getByMovies(Long movies);
	

	
	
	

}
