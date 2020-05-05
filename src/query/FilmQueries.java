package query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import model.Film;
import repository.FilmRepository;
 
@Service("filmQueries")
public class FilmQueries implements IQuery {
 
    @Autowired
    FilmRepository FilmRepo;
 
    @Override
    public void create(Film Film) {
        Film film = FilmRepo.insert(Film);
        System.out.println("Created:- " + film);
    }
 
    @Override
    public void update(Film Film) {
        Film film = FilmRepo.save(Film);
        System.out.println("Updated:- " + film);
 
    }
 
    @Override
    public void delete(Film Film) {
        FilmRepo.delete(Film);
        System.out.println("Deleted:- " + Film.getId());
    }
 
    @Override
    public List < Film > findAll() {
        return FilmRepo.findAll();
    }
 
    @Override
    public List < Film > findByTitle(String title) {
        return FilmRepo.findByTitle(title);
    }
 
    @Override
    public List < Film > findByYearRelease(int year) {
        return FilmRepo.findByYearRelease(year);
    }
    
    @Override
    public void deleteAll() {
        FilmRepo.deleteAll();
    }
}
