package dev.aziz.amazonrestapi.controllers;

import dev.aziz.amazonrestapi.dtos.SignUpDto;
import dev.aziz.amazonrestapi.dtos.UserDto;
import dev.aziz.amazonrestapi.dtos.UserSummaryDto;
import dev.aziz.amazonrestapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserSummaryDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSummaryDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserSummaryDto> createUser(@RequestBody SignUpDto signUpDto) {
        return ResponseEntity.ok(userService.createUser(signUpDto));

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserSummaryDto> updateUser(@PathVariable Long id,
                                                     @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.editUserById(id, userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserSummaryDto> deleteUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

}
