package com.disney.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disney.dto.CharacterDto;
import com.disney.service.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterController {

	@Autowired
	private CharacterService characterService;

	/*
	 * Guardar Personaje: image = String name = String age = Integer weight = Float
	 * history = String movieSeries = List<MovieSeries>
	 */
	@PostMapping()
	public ResponseEntity<CharacterDto> save(@Valid @RequestBody CharacterDto character) {
		return ResponseEntity.status(HttpStatus.OK).body(characterService.save(character));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CharacterDto> update(@Valid @RequestBody CharacterDto character,
			@PathVariable(name = "id") long id) {
		return ResponseEntity.status(HttpStatus.OK).body(characterService.update(id, character));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		characterService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CharacterDto> get(@PathVariable(name = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(characterService.get(id));
	}

	@GetMapping(params = "name")
	public ResponseEntity<List<CharacterDto>> getByName(@RequestParam("name") String name) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(characterService.getByName(name));
	}

	@GetMapping(params = "age")
	public ResponseEntity<List<CharacterDto>> getByAge(@RequestParam("age") Integer age) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(characterService.getByAge(age));
	}

	@GetMapping(params = "movies")
	public ResponseEntity<List<CharacterDto>> getByMovieId(@RequestParam("movies") Long movieSeriesId) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(characterService.getByMovies(movieSeriesId));
	}

	@GetMapping
	public ResponseEntity<List<CharacterDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(characterService.getAllCharacters());
	}
}
