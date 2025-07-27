package com.example.springboot_backend.controller;

// ✅ Use corrected import path and class name (Users → User)
import com.example.springboot_backend.entities.User;

import com.example.springboot_backend.services.UserService; // ✅ Interface renamed from UserServices → UserService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // ✅ Added base path here instead of repeating in every mapping
public class UserController { // ✅ Renamed from MyController → UserController for clarity and standard naming

    @Autowired
    private UserService userService; // ✅ Renamed from userServices → userService (camelCase & singular)

    // ✅ POST /users – standard REST path to add new user
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // ✅ GET /users – fetch all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // ✅ GET /users/{id} – fetch user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ PUT /users/{id} – update user details
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ DELETE /users/{id} – delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.ok("User deleted successfully with id: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with id: " + id);
        }
    }
}
