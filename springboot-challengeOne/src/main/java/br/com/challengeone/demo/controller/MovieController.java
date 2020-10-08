package br.com.challengeone.demo.controller;

import br.com.challengeone.demo.error.PageNotFoundException;
import br.com.challengeone.demo.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    IMovieService movieService;


    @GetMapping
    public ResponseEntity<?> getMovieTitles() {
        throw new PageNotFoundException("Page not Found");
    }

    @GetMapping(path = "/{Title}")
    public ResponseEntity<?> getMovieTitles(@PathVariable("Title") String title) {
        return new ResponseEntity<>(movieService.getSortedMovieTitles(movieService.consumesJsonMoviesByTitle(title)), HttpStatus.OK);
    }

    @GetMapping(path = "/{Title}/{page}")
    public ResponseEntity<?> getMovieTitles(@PathVariable("Title") String title, @PathVariable("page") Integer pageNumber) {
        return new ResponseEntity<>(movieService.getSortedMovieTitles(movieService.consumesJsonMoviesByTitleAndNumberPage(title, pageNumber)), HttpStatus.OK);
    }
}
