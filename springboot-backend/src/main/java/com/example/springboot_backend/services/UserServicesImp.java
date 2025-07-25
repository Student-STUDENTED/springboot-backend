package com.example.springboot_backend.services;


import com.example.springboot_backend.Entities.Users;
import com.example.springboot_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImp implements UserServices{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users createUser(Users users) {
        return userRepository.save(users) ;
    }

    @Override
    public List<Users> getAllUsersDetails() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> getUsersDetails(int id) {
            return userRepository.findById(id);
    }

    @Override
    public Users updateUsersDetails(int id, Users newusers) {
        Users usersData = userRepository.findById(id).orElse(null);
        if (usersData != null){
            return userRepository.save(newusers);
        }
        else {
             throw new RuntimeException("User not found with id  : " +id);
        }

    }

    @Override
    public boolean deleteUsers(int id) {
        Optional<Users> useropt = userRepository.findById(id);
        if (useropt.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

}
