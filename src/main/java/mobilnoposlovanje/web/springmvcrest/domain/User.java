package mobilnoposlovanje.web.springmvcrest.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isAdmin;
    private String email;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String picture;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isAdmin, email, username, name, lastName, picture);
    }

        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    //
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//        User user = (User) o;
//        return Objects.equals(id, user.id) &&
//                Objects.equals(name, user.name) &&
//                Objects.equals(lastName, user.lastName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, lastName);
//    }
//


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", isAdmin=" + isAdmin +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    public Object clone() {
        User user = new User();
        user.setId(this.id);
        user.setEmail(this.getEmail());
        user.setUsername(this.getUsername());
        user.setName(this.getName());
        user.setLastName(this.getLastName());
        user.setIsAdmin(this.getIsAdmin());
        user.setPassword(this.password);
        user.setPicture(this.getPicture());
        return user;
    }
}
