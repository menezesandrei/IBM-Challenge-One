package br.com.challengeone.demo.service.impl;


import br.com.challengeone.demo.error.PageNotFoundException;
import br.com.challengeone.demo.model.HeaderMovies;
import br.com.challengeone.demo.model.Movie;
import br.com.challengeone.demo.service.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    @Override
    public List<Movie> consumesJsonMoviesByTitle(String title) {
        //https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman

        RestTemplate movieTemplate = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("jsonmock.hackerrank.com")
                .path("api/movies/search")
                .queryParam("Title", "spiderman")
                .build();

        ResponseEntity<HeaderMovies> response = movieTemplate.getForEntity(uri.toUriString(), HeaderMovies.class);

        return getAllPages(title,response.getBody().getTotalPages(),response.getBody().getData());
    }

    @Override
    public List<Movie> consumesJsonMoviesByTitleAndNumberPage(String title, Integer pageNumber) {
        //https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman

        RestTemplate movieTemplate = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("jsonmock.hackerrank.com")
                .path("api/movies/search")
                .queryParam("Title", title)
                .queryParam("page", pageNumber.toString())
                .build();

        ResponseEntity<HeaderMovies> response = movieTemplate.getForEntity(uri.toUriString(), HeaderMovies.class);

        if(pageNumber > response.getBody().getTotalPages() || pageNumber <= 0){
            throw new PageNotFoundException("Page not found");
        }

        return response.getBody().getData();
    }

    private List<Movie> getAllPages(String title,int numberPages,List<Movie> moviesTitles){
        if(numberPages > 1){
            for(int i=2;i<=numberPages;i++){
                moviesTitles.addAll(consumesJsonMoviesByTitleAndNumberPage(title,i));
            }
        }
        return moviesTitles;
    }

    private List<String> sortTitleMovies(List<Movie> movies) {

        movies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        return movies.stream().map(e -> e.getTitle()).collect(Collectors.toList());
    }

    public List<String>  getSortedMovieTitles(List<Movie> movies){
        return sortTitleMovies(movies);
    }
}
