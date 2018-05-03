package fi.haagahelia.CourseProject.repository;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.CourseProject.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
