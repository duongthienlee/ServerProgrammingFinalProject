package fi.haagahelia.CourseProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import fi.haagahelia.CourseProject.model.User;

@RepositoryRestResource(path = "users")
public interface UserRepository extends CrudRepository<User, Long> {
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	Iterable<User> findAll();

	User findByUsername(String username);

	User findByEmail(String email);
}
