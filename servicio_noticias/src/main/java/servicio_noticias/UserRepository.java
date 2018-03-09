package servicio_noticias;

import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);
}