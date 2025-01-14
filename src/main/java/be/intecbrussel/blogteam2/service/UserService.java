package be.intecbrussel.blogteam2.service;

import be.intecbrussel.blogteam2.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    Optional<User> updateUser(Long id, User user);
    void deleteUser(Long id);
}
