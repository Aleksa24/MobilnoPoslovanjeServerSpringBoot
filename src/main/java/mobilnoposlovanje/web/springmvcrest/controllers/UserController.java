package mobilnoposlovanje.web.springmvcrest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import mobilnoposlovanje.web.springmvcrest.exception.UserApiException;
import mobilnoposlovanje.web.springmvcrest.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import mobilnoposlovanje.web.springmvcrest.domain.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String BASE_URL = "/api/v1/users";
    private final UserService userService;
    private final List<User> logedInUsers;

    public UserController(UserService userService) {
        this.logedInUsers = new ArrayList<>();
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping()
    List<User> getAllUsers(){
        System.out.println("===getAllUsers()===");
        return userService.findAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){

        System.out.println("===findUserById(id)===");
        return userService.findUserById(id);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        User userToSend = (User) savedUser.clone();
        userToSend.setPassword("");
        System.out.println("SavedUser:" + savedUser);
        System.out.println("UserToSend:" + userToSend);
        return userToSend;
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User loginUser(@RequestBody EmailPassword data) {
        User user = userService.findUserByEmailAndPassword(data.getEmail(), data.getPassword());
        user.setPassword("");
        if (user == null) {
            throw new UserApiException("User with that email and/or password not found");
        }
        if (isLogedIn(user)) {
            throw new UserApiException("User is Is Already loged in");
        }
        this.logedInUsers.add(user);
        System.out.println(logedInUsers);
        ObjectMapper mapper = new ObjectMapper();
        return user;
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public User loginUser(@RequestBody User user) {
        User updatedUser = this.userService.updateUser(user);
        return updatedUser;
    }

    private boolean isLogedIn(User user) {
        for (User u :
                logedInUsers) {
            if (u.getId() == user.getId())return  true;
        }
        return false;
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public ReturnMessage logoutUser(@RequestBody User userToLogout) {
        if (isLogedIn(userToLogout)) {
            this.logedInUsers.remove(userToLogout);
            System.out.println("removed user:" + userToLogout);
        }
        else System.out.println("user nije ulogovan, mrzi me da radim bolje ako se ovo desi");
        System.out.println(logedInUsers);
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setMessage("Success Login");
        return returnMessage;
    }
}

@Data
 class EmailPassword{
    private String password;
    private String email;
}
@Data
class ReturnMessage{
    private String message;
}
