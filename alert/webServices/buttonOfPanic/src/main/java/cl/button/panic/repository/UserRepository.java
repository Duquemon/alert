package cl.button.panic.repository;

import org.springframework.data.repository.CrudRepository;

import cl.button.panic.model.ApplicationUser;

public interface UserRepository extends CrudRepository<ApplicationUser, Long> {
	ApplicationUser findByEmailClient(String emailClient);

}
