package fi.haagahelia.CourseProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
	List<Artist> findByFirstNameAndLastName(String firstName, String lastName);

	List<Artist> findByLastName(String lastName);


}
