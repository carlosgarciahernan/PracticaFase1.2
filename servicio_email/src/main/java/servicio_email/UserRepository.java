package servicio_email;

import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);
}