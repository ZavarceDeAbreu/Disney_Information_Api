package com.disney.mapper;

import org.springframework.stereotype.Component;

import com.disney.dto.CharacterDto;
import com.disney.entity.CharacterEntity;

@Component
public class CharacterMapper {

	//Convertimos de DTO a enidad
	public CharacterEntity mapEntity (CharacterDto characterDto) {
		CharacterEntity character = new CharacterEntity();
		character.setImage(characterDto.getImage());
		character.setName(characterDto.getName());
		character.setAge(characterDto.getAge());
		character.setWeight(characterDto.getWeight());
		character.setHistory(characterDto.getHistory());
		character.setMovieSeries(characterDto.getMovieSeries());
		return character;
	}
	
	//Convertimos de DTO a enidad
	public CharacterDto mapDTO (CharacterEntity character) {
		CharacterDto characterDto = new CharacterDto();
		characterDto.setId(character.getId());
		characterDto.setImage(character.getImage());
		characterDto.setName(character.getName());
		characterDto.setAge(character.getAge());
		characterDto.setWeight(character.getWeight());
		characterDto.setHistory(character.getHistory());
		characterDto.setMovieSeries(character.getMovieSeries());
		return characterDto;
	}



}
