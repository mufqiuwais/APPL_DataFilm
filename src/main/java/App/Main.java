package App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.mongodb.core.mapping.Field;

import model.Film;
import config.MongoConfig;
import query.*;
 
public class Main {
 
    public static void main(String args[]) {
 
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        IQuery filmQueries = (IQuery) context.getBean("filmQueries");
        
        mainMenu(filmQueries);
 
        context.close();
    }
    
    public static void mainMenu(IQuery filmQueries) {
    	int option;
    	boolean exit = false;
    	Scanner scan = new Scanner(System.in);
    	while(!exit) {
    		System.out.println("==========Database Film==========");
        	System.out.println("1. Display all the film in database");
        	System.out.println("2. Find films by title");
        	System.out.println("3. Find films by year of release");
        	System.out.println("4. Add film to the database");
        	System.out.println("5. Delete a film by id");
        	System.out.println("6. Update a film by id");
        	System.out.println("7. Delete all films in database");
        	System.out.println("8. Exit");
        	System.out.print("Option : ");
        	option = scan.nextInt();
        	switch(option) {
        		case 1:{
        			List < Film > films = filmQueries.findAll();
        			int n = 1;
        	        for (Film film: films) {
        	        	System.out.println("==========Film "+n+"==========");
        	            System.out.println("Id : " + film.getId());
        	            System.out.println("Title : " + film.getTitle());
        	            System.out.println("Release In : " + film.getRelease());
        	            System.out.println("Duration : " + film.getDuration());
        	            System.out.println("Rating : " + film.getAge_rating());
        	            System.out.println("Director : " + film.getDirector());
        	            System.out.println("Genre : " + film.getGenre());
        	            System.out.println("Actors : " + film.getActors());
        	            System.out.println();
        	            n++;
        	        }
        	        pressAnyKeyToContinue();
        			break;
        		}
        		case 2:{
        			List<Film> films = new ArrayList<>();
        			String title;
        			System.out.print("Enter the film title : ");
        			scan.nextLine();
        			title = scan.nextLine();
        			films = filmQueries.findByTitle(title);
        			int n = 1;
        	        for (Film film: films) {
        	        	System.out.println("==========Film "+n+"==========");
        	            System.out.println("Id : " + film.getId());
        	            System.out.println("Title : " + film.getTitle());
        	            System.out.println("Release In : " + film.getRelease());
        	            System.out.println("Duration : " + film.getDuration());
        	            System.out.println("Rating : " + film.getAge_rating());
        	            System.out.println("Director : " + film.getDirector());
        	            System.out.println("Genre : " + film.getGenre());
        	            System.out.println("Actors : " + film.getActors());
        	            System.out.println();
        	            n++;
        	        }
        	        pressAnyKeyToContinue();
        			break;
        		}
        		case 3:{
        			List<Film> films = new ArrayList<>();
        			int year;
        			System.out.print("Enter the year : ");
        			year = scan.nextInt();
        			films = filmQueries.findByYearRelease(year);
        			int n = 1;
        	        for (Film film: films) {
        	        	System.out.println("==========Film "+n+"==========");
        	            System.out.println("Id : " + film.getId());
        	            System.out.println("Title : " + film.getTitle());
        	            System.out.println("Release In : " + film.getRelease());
        	            System.out.println("Duration : " + film.getDuration());
        	            System.out.println("Rating : " + film.getAge_rating());
        	            System.out.println("Director : " + film.getDirector());
        	            System.out.println("Genre : " + film.getGenre());
        	            System.out.println("Actors : " + film.getActors());
        	            System.out.println();
        	            n++;
        	        }
        	        pressAnyKeyToContinue();
        			break;
        		}
        		case 4:{
        			List<Film> films = new ArrayList<>();
        			int c;
        			Film film = new Film();
        			String id;
        			String title;
        			int year_release;
        			int duration;
        			String age_rating;
        			String sGenre;
        			List<String> genre;
        			String director;
        			String sActors;
        			List<String> actors;
        			String str[];
        			System.out.print("Enter how many film(s) : ");
        			c = scan.nextInt();
        	        for (int n = 1;n<=c;n++) {
        	        	System.out.println("==========Film "+n+"==========");
        	            System.out.print("Id : ");
        	            scan.nextLine();
        	            id = scan.nextLine();
        	            System.out.print("Title : ");
        	            title = scan.nextLine();
        	            System.out.print("Release In : ");
        	            year_release = scan.nextInt();
        	            System.out.print("Duration in minutes: ");
        	            duration = scan .nextInt();
        	            System.out.print("Rating : ");
        	            scan.nextLine();
        	            age_rating = scan.nextLine();
        	            System.out.print("Director : ");
        	            director = scan.nextLine();
        	            System.out.print("Genre (separate it using coma \",\"): ");
        	            sGenre = scan.nextLine();
        	            System.out.print("Actors (separate it using coma \",\"): ");
        	            sActors = scan.nextLine();
        	            System.out.println();
        	            str = sGenre.split(",");
        	            genre = Arrays.asList(str);
        	            str = sActors.split(",");
        	            actors = Arrays.asList(str);
        	            film = new Film(id, title, year_release, duration, age_rating, genre, director, actors);
        	            filmQueries.create(film);
        	            n++;
        	        }
        	        pressAnyKeyToContinue();
        			break;
        		}
        		case 5:{
        			Film film = new Film();
        			String id;
        			System.out.print("Enter the film id : ");
        			scan.nextLine();
        			id = scan.nextLine();
        			film = filmQueries.findById(id);
        			if(film==null) {
        				System.out.println("No Film with such id");
            	        pressAnyKeyToContinue();
        			}else {
        				filmQueries.delete(film);
            	        pressAnyKeyToContinue();
        			}
        			
        			break;
        		}
        		case 6:{
        			Film film = new Film();
        			String id;
        			String title;
        			int year_release;
        			int duration;
        			String age_rating;
        			String sGenre;
        			List<String> genre;
        			String director;
        			String sActors;
        			List<String> actors;
        			String str[];
        			System.out.print("Enter the film id : ");
        			scan.nextLine();
        			id = scan.nextLine();
        			film = filmQueries.findById(id);
        			if(film==null) {
        				System.out.println("No Film with such id");
            	        pressAnyKeyToContinue();
        			}else {
        				System.out.println("==========Before Update==========");
        				System.out.println("Id : " + film.getId());
        	            System.out.println("Title : " + film.getTitle());
        	            System.out.println("Release In : " + film.getRelease());
        	            System.out.println("Duration : " + film.getDuration());
        	            System.out.println("Rating : " + film.getAge_rating());
        	            System.out.println("Director : " + film.getDirector());
        	            System.out.println("Genre : " + film.getGenre());
        	            System.out.println("Actors : " + film.getActors());
        	            System.out.println();
        	            System.out.println("==========Updating==========");
        	            System.out.print("Id : ");
        	            id = scan.nextLine();
        	            System.out.print("Title : ");
        	            title = scan.nextLine();
        	            System.out.print("Release In : ");
        	            year_release = scan.nextInt();
        	            System.out.print("Duration in minutes: ");
        	            duration = scan .nextInt();
        	            System.out.print("Rating : ");
        	            scan.nextLine();
        	            age_rating = scan.nextLine();
        	            System.out.print("Director : ");
        	            director = scan.nextLine();
        	            System.out.print("Genre (separate it using coma \",\"): ");
        	            sGenre = scan.nextLine();
        	            System.out.print("Actors (separate it using coma \",\"): ");
        	            sActors = scan.nextLine();
        	            System.out.println();
        	            str = sGenre.split(",");
        	            genre = Arrays.asList(str);
        	            str = sActors.split(",");
        	            actors = Arrays.asList(str);
        	            film = new Film(id, title, year_release, duration, age_rating, genre, director, actors);
        				filmQueries.update(film);
            	        pressAnyKeyToContinue();
        			}
        			
        			break;
        		}
        		case 7:{
        			filmQueries.deleteAll();
        			pressAnyKeyToContinue();
        			break;
        		}
        		default:{
        			System.out.println("Thank you!");
        			exit = true;
        			break;
        		}
        	}
    	}
    }
    
    private static void pressAnyKeyToContinue()
    { 
           System.out.println("Press Enter key to continue...");
           try
           {
               System.in.read();
           }  
           catch(Exception e)
           {}  
    }
 
}