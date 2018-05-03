package fi.haagahelia.CourseProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.CourseProject.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
	List<Artist> findByFirstNameAndLastName(String firstName, String lastName);

	List<Artist> findByLastName(String lastName);


}
