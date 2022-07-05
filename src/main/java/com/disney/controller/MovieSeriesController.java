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

import com.disney.dto.MovieSeriesDto;
import com.disney.service.MovieSeriesService;

@RestController
@RequestMapping("/movies")
public class MovieSeriesController {

	@Autowired
	private MovieSeriesService movieSeriesService;

	/*
	 * Guardar pelicula: image = String title = String creationDate = LocalDate rating = Float
	 * characters = List<character>  genres = List<genres> 
	 */
	@PostMapping
	public ResponseEntity<MovieSeriesDto> save(@Valid @RequestBody MovieSeriesDto movieSeries) {
		return ResponseEntity.status(HttpStatus.OK).body(movieSeriesService.save(movieSeries));
	}

	@PutMapping("/{id}")
	public ResponseEntity<MovieSeriesDto> update(@Valid @RequestBody MovieSeriesDto movieSeries,
			@PathVariable(name = "id") long id) {
		return ResponseEntity.status(HttpStatus.OK).body(movieSeriesService.update(id, movieSeries));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		movieSeriesService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieSeriesDto> get(@PathVariable(name = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(movieSeriesService.get(id));
	}
	
	@GetMapping
	public ResponseEntity<List<MovieSeriesDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(movieSeriesService.getAllMovieSeries());
	}
	
	@GetMapping(params = "name")
	public ResponseEntity<List<MovieSeriesDto>> getByName(@RequestParam("name") String title) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(movieSeriesService.findByName(title));
	}

	@GetMapping(params = "genre")
	public ResponseEntity<List<MovieSeriesDto>> getByidGenero(@RequestParam("genre") Long genreId)
			throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(movieSeriesService.findByGenreId(genreId));
	}

	@GetMapping(params = "order")
	public ResponseEntity<List<MovieSeriesDto>> getAllByOrder(@RequestParam("order") String order) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(movieSeriesService.findAllByOrder(order));
	}
	
	@PutMapping("/{idMovie}/characters/{idCharacter}")
	public ResponseEntity<MovieSeriesDto> addCharacte(@PathVariable("idMovie") Long movieId, @PathVariable("idCharacter") Long characterid) {
		movieSeriesService.addCharacter(movieId , characterid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

	@DeleteMapping("/{idmovie}/characters/{idCharacter}")
	public ResponseEntity<MovieSeriesDto> deleteCharacter(@PathVariable("idmovie") Long movieId, @PathVariable("idCharacter") Long Characterid) {
		movieSeriesService.deleteCharacter(movieId , Characterid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
