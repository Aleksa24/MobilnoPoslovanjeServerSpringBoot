package mobilnoposlovanje.web.springmvcrest.service.user;

import mobilnoposlovanje.web.springmvcrest.domain.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);

    List<User> findAllUsers();

    User saveUser(User user);

    /**
     *
     * @param email
     * @param password
     * @return User | null if there is no user with username and password
     */
    User findUserByEmailAndPassword(String email,String password);

    User updateUser(User user);
}
