package model;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//import org.springframework.*;
@Document
public class Film {
	
	@Id
	private String id;
	
	@Field
	private String title;
	private int year_release;
	private int duration;
	private String age_rating;
	private List<String> genre;
	private String director;
	private List<String> actors;
	
	public Film() {
		super();
	}
	
	public Film(String id, String title, int year_release, int duration, String age_rating,
			List<String> genre, String director, List<String> actors) {
		super();
		this.id = id;
		this.title = title;
		this.year_release = year_release;
		this.duration = duration;
		this.age_rating = age_rating;
		this.genre = genre;
		this.director = director;
		this.actors = actors;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRelease() {
		return year_release;
	}
	public void setRelease(int release) {
		this.year_release = release;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getAge_rating() {
		return age_rating;
	}
	public void setAge_rating(String age_rating) {
		this.age_rating = age_rating;
	}
	public List<String> getGenre() {
		return genre;
	}
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public List<String> getActors() {
		return actors;
	}
	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	
}
