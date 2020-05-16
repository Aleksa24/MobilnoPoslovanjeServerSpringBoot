package mobilnoposlovanje.web.springmvcrest.service.user;

import mobilnoposlovanje.web.springmvcrest.domain.User;
import mobilnoposlovanje.web.springmvcrest.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     *
     * @param email
     * @param password
     * @return User | null if not found
     */
    @Override
    public User findUserByEmailAndPassword(String email,String password) {
        //iscitaj sve,proveri da li postoji u listi, vrati odgovarajuce
        List<User> allUsers = this.findAllUsers();

        for (User user :
                allUsers) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password))return user;
        }

        return null;
    }

    /**
     * No PASSWORD
     * @param user
     * @return
     */
    @Override
    public User updateUser(User user) {
        User userToUpdate = this.userRepository.findById(user.getId()).get();
        System.out.println("user in rep before update:" + userRepository.findById(user.getId()).get());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setIsAdmin(user.getIsAdmin());
        userToUpdate.setPicture(user.getPicture());
        userRepository.save(userToUpdate);

        return userRepository.findById(user.getId()).get();
    }
}
