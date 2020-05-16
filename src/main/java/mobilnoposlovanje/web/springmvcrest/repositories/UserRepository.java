package mobilnoposlovanje.web.springmvcrest.repositories;

import mobilnoposlovanje.web.springmvcrest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
