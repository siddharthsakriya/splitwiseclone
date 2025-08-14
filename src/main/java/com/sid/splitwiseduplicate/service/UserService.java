package com.sid.splitwiseduplicate.service;

import com.sid.splitwiseduplicate.model.User;
import com.sid.splitwiseduplicate.model.UserGroup;
import com.sid.splitwiseduplicate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final GroupService groupService;

    @Autowired
    public UserService(UserRepository userRepository, GroupService groupService) {
        this.userRepository = userRepository;
        this.groupService = groupService;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setPasswordHash(userDetails.getPasswordHash());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void addUserToGroup(Long id, Long groupId) {
        User user = getUserById(id);
        UserGroup group = groupService.getGroupById(groupId);

        user.getAllUserGroups().add(group);
        group.getMembers().add(user);

        userRepository.save(user);
    }

}
