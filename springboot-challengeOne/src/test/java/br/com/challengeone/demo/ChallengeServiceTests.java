package br.com.challengeone.demo;

import br.com.challengeone.demo.model.HeaderMovies;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChallengeServiceTests {


    @Test
    public void consumerMovieJsonByTitleTest() {
//https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman

        RestTemplate movieTemplate = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("jsonmock.hackerrank.com")
                .path("api/movies/search")
                .queryParam("Title", "spiderman")
                .build();

        ResponseEntity<HeaderMovies> response = movieTemplate.getForEntity(uri.toUriString(), HeaderMovies.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void consumerMovieJsonByTitleAndNumberPageTest() {
//https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=2

        RestTemplate movieTemplate = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("jsonmock.hackerrank.com")
                .path("api/movies/search")
                .queryParam("Title", "spiderman")
                .queryParam("page", "2")
                .build();

        ResponseEntity<HeaderMovies> response = movieTemplate.getForEntity(uri.toUriString(), HeaderMovies.class);

        assertNotNull(response.getBody());
    }

}
