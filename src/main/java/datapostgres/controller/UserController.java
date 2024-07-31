package datapostgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import datapostgres.data.entity.User;
import datapostgres.data.repository.UserRepository;
import datapostgres.data.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setEdad(newUser.getEdad());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}