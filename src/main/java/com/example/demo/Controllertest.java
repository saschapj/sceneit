package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class Controllertest {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping({"/index", "/"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Movie> allMovies = movieRepository.findAll();
        modelAndView.addObject("allmovies", allMovies);
        return modelAndView;
    }

    @GetMapping("/detailmovie/{movieId}")
    public ModelAndView detailmovie(@PathVariable Long movieId) {

        ModelAndView modelAndView = new ModelAndView("detailmovie");

        Optional<Movie> detailMovie = movieRepository.findById(movieId);

        if (detailMovie.isPresent()) {
            modelAndView.addObject("movie", detailMovie.get());
        }

        return modelAndView;
    }

    @GetMapping("/newmovie")
    public String newmovie(Model model) {
        model.addAttribute("movie",new Movie());

        return "newmovie";
    }

    @PostMapping("/newmovie")
    public ModelAndView newmovieSubmit(Model model,@RequestParam String title,@RequestParam int age, @RequestParam int year, @RequestParam String plot, @RequestParam String linkToCover, @RequestParam int lengthInMinutes, @RequestParam String actors, @RequestParam String authors, @RequestParam String directors, @RequestParam String genres, @RequestParam String originalTitle) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);

        String[] splitActors = actors.split(", ");
        List<Actor> actorsnew = new ArrayList<>();
        for(String s : splitActors){
            actorsnew.add(new Actor(s));
        }

        String[] splitAuthors = authors.split(", ");
        List<Author> authorsnew = new ArrayList<>();
        for(String s : splitAuthors){
            authorsnew.add(new Author(s));
        }

        String[] splitDirectors = directors.split(", ");
        List<Director> directorsnew = new ArrayList<>();
        for(String s : splitDirectors){
            directorsnew.add(new Director(s));
        }

        String[] splitGenres = genres.split(", ");
        List<Genre> genresnew = new ArrayList<>();
        for(String s : splitGenres){
            genresnew.add(new Genre(s));
        }

        movie.setActors(actorsnew);
        movie.setDirectors(directorsnew);
        movie.setAuthors(authorsnew);
        movie.setGenres(genresnew);
        movie.setAge(age);
        movie.setPlot(plot);
        movie.setLinkToCover(linkToCover);
        movie.setLengthInMinutes(lengthInMinutes);
        movie.setYear(year);
        movie.setOriginalTitle(originalTitle);
        movie.setTitle(title);

        ModelAndView modelAndView = new ModelAndView("detailmovie");
        movieRepository.save(movie);
        return modelAndView;
    }

}
