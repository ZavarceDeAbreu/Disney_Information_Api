package com.disney.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney.dto.GenreDto;
import com.disney.service.GenreService;

@RestController
@RequestMapping("/genre")
public class GenreController {

	@Autowired
	private GenreService genreService;

	@PostMapping
	public ResponseEntity<GenreDto> save(@Valid @RequestBody GenreDto genre) {
		return ResponseEntity.ok().body(genreService.save(genre));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		genreService.delete(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<GenreDto> update(@Valid @RequestBody GenreDto genre,
			@PathVariable(name = "id") long id) {
		return ResponseEntity.ok().body(genreService.update(id, genre));
	}

	@GetMapping("/{id}")
	public ResponseEntity<GenreDto> get(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(genreService.get(id));
	}

	@GetMapping
	public ResponseEntity<List<GenreDto>> getAll() {
		return ResponseEntity.ok().body(genreService.getAllGenre());
	}

}
