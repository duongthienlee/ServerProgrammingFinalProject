package fi.haagahelia.CourseProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import fi.haagahelia.CourseProject.model.Artist;

@RestResource
public interface ArtistRepository extends CrudRepository<Artist, Long> {
	List<Artist> findByFirstNameAndLastName(String firstName, String lastName);
	List<Artist> findByLastName(@Param("lastName") String lastName);

}
