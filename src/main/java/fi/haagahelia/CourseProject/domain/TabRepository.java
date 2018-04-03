package fi.haagahelia.CourseProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TabRepository extends CrudRepository<Tab, Long> {
	List<Tab> findBySong(String song);
	

}
