package com.example.springboot_backend.services;

import com.example.springboot_backend.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService { // ✅ Renamed from UserServices → UserService
    // Java convention: Interface names should be singular and service-oriented (e.g., UserService)

    // ✅ Changed Users → User to match the renamed entity class
    User createUser(User user);

    // ✅ Method name simplified to reflect standard practice
    List<User> getAllUsers();

    Optional<User> getUserById(int id); // ✅ Improved method naming to be more meaningful

    User updateUser(int id, User user); // ✅ Consistent and descriptive naming

    boolean deleteUser(int id); // ✅ Singular noun and action verb used
}
