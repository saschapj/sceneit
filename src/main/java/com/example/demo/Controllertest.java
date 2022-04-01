package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class Controllertest {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping({"/index","/"})
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Movie> allMovies = movieRepository.findAll();
        modelAndView.addObject("allmovies",allMovies);
        return modelAndView;
    }

    @GetMapping("/detailmovie/{movieId}")
    public ModelAndView detailmovie(@PathVariable Long movieId){

        ModelAndView modelAndView = new ModelAndView("detailmovie");

        Optional<Movie> detailMovie = movieRepository.findById(movieId);

        if(detailMovie.isPresent()) {
            modelAndView.addObject("movie",detailMovie.get());
        }

        return modelAndView;
    }
}
