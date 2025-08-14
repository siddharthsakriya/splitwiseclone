package com.sid.splitwiseduplicate.controller;

import com.sid.splitwiseduplicate.dto.UserDto;
import com.sid.splitwiseduplicate.model.User;
import com.sid.splitwiseduplicate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("api/user/health-check")
    public String getHealth() {
        return "All Fine";
    }

    @GetMapping("api/user/getuser/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new UserDto(user.getId(), user.getUsername()));
    }

}