package com.example.demo;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="Actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.PERSIST})
    @JoinColumn(name = "movie_id")
    private List<Movie> movies = new ArrayList<>();

    public Actor() {
    }

    public Actor(String name) {
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
