package App;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
 
import model.Film;
import config.MongoConfig;
import query.FilmQueries;
 
public class Main {
 
    public static void main(String args[]) {
 
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        FilmQueries filmQueries = (FilmQueries) context.getBean("filmQueries");
        // Delete All cars
        filmQueries.deleteAll();
        
        /*Create*/
        ArrayList<String> genre = new ArrayList<>();
        genre.add("Sci-Fi");
        ArrayList<String> actors = new ArrayList<>();
        actors.add("Mark Hamill");
        actors.add("Daisy Ridley");
        Film starwars = new Film("123141rq131", "Star Wars : The Last Jedi", 2018, 180, "PG", genre, "Waka Impala", actors);
        filmQueries.create(starwars);
 
        /*Update*/
        System.out.println();
        starwars.setDuration(120);
        filmQueries.update(starwars);
        
        /*Query*/
        System.out.println("\nFind By Title:- " + filmQueries.findByTitle(starwars.getTitle()));
 
        System.out.println("\nFind All!!");
 
        List < Film > films = filmQueries.findAll();
        for (Film film: films) {
            System.out.println(film.getTitle());
        }
 
        System.out.println("\nFind By Year Release = '2018'");
        films = filmQueries.findByYearRelease(2018);
        for (Film film: films) {
            System.out.println(film.getTitle());
        }
        
        /*Delete*/
//        System.out.println();
//        filmQueries.delete(starwars);
 
        context.close();
    }
 
}