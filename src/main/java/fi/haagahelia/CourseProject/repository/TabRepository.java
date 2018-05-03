package fi.haagahelia.CourseProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.CourseProject.model.Tab;

public interface TabRepository extends CrudRepository<Tab, Long> {
	List<Tab> findBySong(String song);
	

}
