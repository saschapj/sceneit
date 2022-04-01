package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MoviedbApplication {



	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(MoviedbApplication.class, args);

		GenreRepository genreRepository = run.getBean(GenreRepository.class);
		ActorRepository actorRepository = run.getBean(ActorRepository.class);
		AuthorRepository authorRepository = run.getBean(AuthorRepository.class);
		DirectorRepository directorRepository = run.getBean(DirectorRepository.class);
		MovieRepository movieRepository = run.getBean(MovieRepository.class);

		Movie theGodfather = new Movie();
		theGodfather.setTitle("Der Pate");
		theGodfather.setYear(1972);
		theGodfather.setOriginalTitle("The Godfather");
		theGodfather.setLengthInMinutes(175);
		theGodfather.setPlot("Der alternde Patriarch einer Verbrecherdynastie will die Herrschaft über sein geheimes Reich auf seinen widerwilligen Sohn übertragen.");
		theGodfather.setAge(16);

		List<Director> dirs = new ArrayList<>();
		dirs.add(new Director("Francis Ford Coppola"));

		List<Actor> acts = new ArrayList<>();
		acts.add(new Actor("Marlon Brando"));
		acts.add(new Actor("Al Pacino"));
		acts.add(new Actor("James Caan"));

		List<Genre> genres = new ArrayList<>();
		genres.add(new Genre("Krimi"));
		genres.add(new Genre("Drama"));

		List<Author> authors = new ArrayList<>();
		authors.add(new Author("Mario Puzo"));
		authors.add(new Author("Francis Ford Coppola"));

		theGodfather.setActors(acts);
		theGodfather.setAuthors(authors);
		theGodfather.setDirectors(dirs);
		theGodfather.setGenres(genres);
		theGodfather.setLinkToCover("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg");


		movieRepository.save(theGodfather);

		Movie trueGrit = new Movie();
		trueGrit.setTitle("Der Marshal");
		trueGrit.setYear(1969);
		trueGrit.setOriginalTitle("True Grit");
		trueGrit.setLengthInMinutes(128);
		trueGrit.setPlot("Ein abgebrühter und ständig angetrunkener U.S. Marshal und ein Texas Ranger helfen einer dickköpfigen Teenagerin dabei, den Mörder ihres Vaters im indianischen Territorium aufzuspüren.");
		trueGrit.setAge(12);

		List<Director> dirs2 = new ArrayList<>();
		dirs2.add(new Director("Henry Hathaway"));

		List<Actor> acts2 = new ArrayList<>();
		acts2.add(new Actor("John Wayne"));
		acts2.add(new Actor("Kim Darby"));
		acts2.add(new Actor("Glenn Campbell"));

		List<Genre> genres2 = new ArrayList<>();
		genres2.add(new Genre("Abenteuer"));
		genres2.add(new Genre("Drama"));
		genres2.add(new Genre("Western"));

		List<Author> authors2 = new ArrayList<>();
		authors2.add(new Author("Charles Portis"));
		authors2.add(new Author("Marguerite Roberts"));

		trueGrit.setActors(acts2);
		trueGrit.setAuthors(authors2);
		trueGrit.setDirectors(dirs2);
		trueGrit.setGenres(genres2);
		trueGrit.setLinkToCover("https://m.media-amazon.com/images/I/51aIdRE27sL._SY445_.jpg");

		movieRepository.save(trueGrit);


		List<Movie> der_pate = movieRepository.findByTitle("Der Pate");

		Movie movie = der_pate.get(0);


		System.out.println("Test");
		System.out.println(movie.getYear());
		System.out.println(movie.getTitle());
		System.out.println(movie.getId());
		System.out.println(movie.getActors().get(0).getName());
		System.out.println(movie.getAuthors().get(0).getName());


		System.out.println("///TEST");

		/*List<Genre> genres = new ArrayList<>();
		genres.add(new Genre("Krimi"));
		genres.add(new Genre("Drama"));

		List<Actor> actors = new ArrayList<>();
		actors.add(new Actor("Marlon Brando"));
		actors.add(new Actor("Al Pacino"));
		actors.add(new Actor("James Caan"));

		List<Director> directors = new ArrayList<>();
		directors.add(new Director("Francis Ford Coppola"));


		List<Author> authors = new ArrayList<>();
		authors.add(new Author("Mario Puzo"));
		authors.add(new Author("Francis Ford Coppola"));

		Movie theGodfather = new Movie();



		List<Genre> genres2 = new ArrayList<>();
		genres2.add(new Genre("Action"));
		genres2.add(new Genre("Adventure"));
		genres2.add(new Genre("Science-Fiction"));

		List<Actor> actors2 = new ArrayList<>();
		actors2.add(new Actor("Arnold Schwarzenegger"));
		actors2.add(new Actor("Sharon Stone"));
		actors2.add(new Actor("Micheal Ironside"));

		List<Author> authors2 = new ArrayList<>();
		authors2.add(new Author("Philip K. Dick"));
		authors2.add(new Author("Ronald Shusett"));
		authors2.add(new Author("Dan O'Bannon"));

		List<Director> directors2 = new ArrayList<>();
		directors2.add(new Director("Paul Verhoeven"));

		Movie totalRecall = new Movie();

		GenreRepository genreRepository = run.getBean(GenreRepository.class);
		genreRepository.saveAll(genres);
		genreRepository.saveAll(genres2);


		AuthorRepository authorRepository = run.getBean(AuthorRepository.class);
		authorRepository.saveAll(authors);
		authorRepository.saveAll(authors2);

		DirectorRepository directorRepository = run.getBean(DirectorRepository.class);
		directorRepository.saveAll(directors);
		directorRepository.saveAll(directors2);

		ActorRepository actorRepository = run.getBean(ActorRepository.class);
		actorRepository.saveAll(actors);
		actorRepository.saveAll(actors2);


		theGodfather.setTitle("Der Pate");
		theGodfather.setYear(1972);
		theGodfather.setAge(16);
		theGodfather.setLengthInMinutes(175);
		theGodfather.setOriginalTitle("The Godfather");
		theGodfather.setPlot("Der alternde Patriarch einer Verbrecherdynastie will die Herrschaft über sein geheimes Reich auf seinen widerwilligen Sohn übertragen.");
		theGodfather.setGenres(genres);
		theGodfather.setAuthors(authors);
		theGodfather.setGenres(genres);
		theGodfather.setActors(actors);
		theGodfather.setDirectors(directors);

		totalRecall.setTitle("Total Recall");
		totalRecall.setActors(actors2);
		totalRecall.setAuthors(authors2);
		totalRecall.setGenres(genres2);
		totalRecall.setDirectors(directors2);

		MovieRepository movieRepository = run.getBean(MovieRepository.class);
		movieRepository.save(theGodfather);
//		movieRepository.save(totalRecall);
		System.out.println("test");*/

	}

}
