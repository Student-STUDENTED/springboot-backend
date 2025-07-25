package com.example.springboot_backend.services;

// ✅ Import correct and renamed class
import com.example.springboot_backend.entities.User;
import com.example.springboot_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
// ✅ Renamed class from UserServicesImp → UserServiceImpl (standard naming convention for service implementations)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) { // ✅ Changed Users → User
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() { // ✅ Method name changed to match interface
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) { // ✅ Naming improved for clarity
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(int id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            // ✅ Optionally, copy individual fields to preserve ID and avoid replacing unintended fields
            User user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setCity(updatedUser.getCity());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    @Override
    public boolean deleteUser(int id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
