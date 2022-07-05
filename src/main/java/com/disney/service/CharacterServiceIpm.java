package com.disney.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.dto.CharacterDto;
import com.disney.entity.CharacterEntity;
import com.disney.exceptions.ParamNotFoundException;
import com.disney.exceptions.ResourceNotFoundException;
import com.disney.mapper.CharacterMapper;
import com.disney.repository.CharacterRepository;

@Service
public class CharacterServiceIpm implements CharacterService {

	@Autowired
	private CharacterRepository characterRepo;

	@Autowired
	private CharacterMapper characterMap;

	@Override
	public CharacterDto save(CharacterDto characterDto) {
		CharacterEntity character = characterMap.mapEntity(characterDto);
		return characterMap.mapDTO(characterRepo.save(character));
	}

	@Override
	public CharacterDto update(Long id, CharacterDto characterDto) {

		CharacterEntity character = characterRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Character", "id", id));

		character.setImage(characterDto.getImage());
		character.setName(characterDto.getName());
		character.setAge(characterDto.getAge());
		character.setWeight(characterDto.getWeight());
		character.setHistory(characterDto.getHistory());

		return characterMap.mapDTO(characterRepo.save(character));
	}

	@Override
	public void delete(Long id) {
		CharacterEntity character = characterRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Character", "id", id));
		characterRepo.delete(character);
	}

	@Override
	public CharacterDto get(Long id) {
		CharacterEntity publicacion = characterRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Character", "id", id));
		return characterMap.mapDTO(publicacion);
	}

	public List<CharacterDto> getByName(String name) {
		List<CharacterEntity> characters = characterRepo.findByName(name);

		if (characters.isEmpty()) {
			throw new ParamNotFoundException("Error: Invalid character name");
		}

		return characters.stream().map(character -> characterMap.mapDTO(character)).collect(Collectors.toList());
	}

	@Override
	public List<CharacterDto> getByAge(Integer age) {
		List<CharacterEntity> characters = characterRepo.findByAge(age);

		if (characters.isEmpty()) {
			throw new ParamNotFoundException("Error: Invalid character name");
		}

		return characters.stream().map(character -> characterMap.mapDTO(character)).collect(Collectors.toList());
	}

	@Override
	public List<CharacterDto> getByMovies(Long movieSeriesId) {
		List<CharacterEntity> characters = characterRepo.findByMovieSeriesId(movieSeriesId);

		if (characters.isEmpty()) {
			throw new ParamNotFoundException("Error: Invalid movie id");
		}

		return characters.stream().map(character -> characterMap.mapDTO(character)).collect(Collectors.toList());
	}

	@Override
	public List<CharacterDto> getAllCharacters() {
		List<CharacterEntity> characters = characterRepo.findAll();
		return characters.stream().map(character -> characterMap.mapDTO(character)).collect(Collectors.toList());
	}
}
