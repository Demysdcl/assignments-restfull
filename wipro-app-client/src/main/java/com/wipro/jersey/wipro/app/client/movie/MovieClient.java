package com.wipro.jersey.wipro.app.client.movie;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class MovieClient {

    private final Client client = ClientBuilder.newClient();

    private static final String BASE_URL = "http://localhost:8080/movie-app-ws/wipro/movies";

    private final WebTarget webTarget = client.target(BASE_URL);

    public List<Movie> getAllMoviesXML() {
        return webTarget
            .request(MediaType.APPLICATION_XML)
            .get(Movies.class);
    }

    public List<Movie> getAllMoviesJSON() {
        return webTarget
            .request(MediaType.APPLICATION_JSON)
            .get(Movies.class);
    }

    public Movie getMovieById(String id) {
        return webTarget
            .path(id)
            .request(MediaType.APPLICATION_XML)
            .get(Movie.class);
    }

    public static void main(String[] args) {
        MovieClient movieClient = new MovieClient();

        List<Movie> list = movieClient.getAllMoviesJSON();
        list.forEach(it -> {
            System.out.println(it);
        });

        System.out.println(movieClient.getMovieById("M0001"));
    }

}
