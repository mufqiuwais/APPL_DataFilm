package model;

import java.util.Date;
import java.util.List;

//import org.springframework.*;

public class Film {
	private String id;
	private String title;
	private Date release;
	private int duration;
	private String age_rating;
	private List<String> genre;
	private String director;
	private List<String> actors;
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
	public Date getRelease() {
		return release;
	}
	public void setRelease(Date release) {
		this.release = release;
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
