package query;
 
import java.util.List;
 
import model.Film;;
 
public interface IQuery {
 
    public void create(Film film);
 
    public void update(Film film);
 
    public void delete(Film film);
 
    public void deleteAll();
 
    public List < Film > findByYearRelease(int year);
 
    public List < Film > findByTitle(String title);
 
    public List < Film > findAll();
}