package com.sid.splitwiseduplicate.controller;

import com.sid.splitwiseduplicate.dto.UserDto;
import com.sid.splitwiseduplicate.model.User;
import com.sid.splitwiseduplicate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @GetMapping("api/user/getuser/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new UserDto(
                user.getUsername(),
                null,
                user.getFirstName(),
                user.getLastName()
        ));
    }

    @PostMapping("api/user/adduser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.username());
        user.setPasswordHash(passwordEncoder.encode(userDto.password()));
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());

        User savedUser = userService.addUser(user);

        return ResponseEntity.ok(new UserDto(
                savedUser.getUsername(),
                null,
                savedUser.getFirstName(),
                savedUser.getLastName()
        ));
    }

}