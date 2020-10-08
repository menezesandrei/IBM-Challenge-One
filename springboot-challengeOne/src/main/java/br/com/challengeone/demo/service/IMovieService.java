package br.com.challengeone.demo.service;

import br.com.challengeone.demo.model.Movie;

import java.util.List;

public interface IMovieService {

    List<Movie> consumesJsonMoviesByTitle(String title);

    List<Movie> consumesJsonMoviesByTitleAndNumberPage(String title, Integer pageNumber);

    List<String>  getSortedMovieTitles(List<Movie> movies);

}
