package com.wipro.jersey.wipro.app.client.movie;

import java.io.Serializable;

public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    private String movieId;
    private String movieName;
    private String movieActor;
    private Float movieCollection;

    public Movie() {
    }

    public Movie(String movieId, String movieName, String movieActor, Float movieCollection) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieActor = movieActor;
        this.movieCollection = movieCollection;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public Float getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(Float movieCollection) {
        this.movieCollection = movieCollection;
    }

    @Override
    public String toString() {
        return "Movie{" + "movieId=" + movieId + ", movieName=" + movieName + ", movieActor=" + movieActor + ", movieCollection=" + movieCollection + '}';
    }

}
