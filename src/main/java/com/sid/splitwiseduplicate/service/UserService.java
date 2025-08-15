package com.sid.splitwiseduplicate.service;

import com.sid.splitwiseduplicate.model.User;
import com.sid.splitwiseduplicate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Create Operations
     */
    public User addUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Read Operations
     */

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Update Operations
     */
    public User updateUser(User user) {
        User existingUser = getUserById(user.getId());
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPasswordHashed(user.getPasswordHashed());
            return userRepository.save(existingUser);
        }
        return null;
    }


    /**
     * Delete Operations
     */
    public User deleteUserById(Long userId) {
        User user = getUserById(userId);
        if (user != null) {
            userRepository.delete(user);
        }
        return user;
    }

    public User deleteUserByUsername(String username) {
        User user = getUserByUsername(username);
        if (user != null) {
            userRepository.delete(user);
        }
        return user;
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }


}
