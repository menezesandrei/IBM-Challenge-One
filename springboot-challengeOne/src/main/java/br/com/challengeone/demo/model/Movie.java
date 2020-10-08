package br.com.challengeone.demo.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Title",
        "Year",
        "imdbID"
})
public class Movie {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private Integer year;
    @JsonProperty("imdbID")
    private String imdbID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("Year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("imdbID")
    public String getImdbID() {
        return imdbID;
    }

    @JsonProperty("imdbID")
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(imdbID, movie.imdbID) &&
                Objects.equals(additionalProperties, movie.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, imdbID, additionalProperties);
    }
}
