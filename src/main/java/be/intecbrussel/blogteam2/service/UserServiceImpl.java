package be.intecbrussel.blogteam2.service;

import be.intecbrussel.blogteam2.models.User;
import be.intecbrussel.blogteam2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.get().getUserName())
                .password(user.get().getPassword())
                .roles("USER") // Здесь можно добавить роли пользователя
                .build();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setUserName(userDetails.getUserName());
            user.setEmail(userDetails.getEmail());
            user.setStreet(userDetails.getStreet());
            user.setHome(userDetails.getHome());
            user.setCity(userDetails.getCity());
            user.setZip(userDetails.getZip());
            user.setPassword(userDetails.getPassword());
            user.setAvatar(userDetails.getAvatar());
            return userRepository.save(user);
        });
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
