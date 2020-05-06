package repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
 
import model.Film;;
 
@Repository
public interface FilmRepository extends MongoRepository < Film, String > {
    @Query("{ 'title' : ?0 }")
    List < Film > findByTitle(String title);
 
    @Query(value = "{ 'year_release' : ?0}")
    List < Film > findByYearRelease(int year);
}
