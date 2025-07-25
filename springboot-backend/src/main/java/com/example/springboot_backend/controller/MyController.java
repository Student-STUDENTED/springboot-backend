package com.example.springboot_backend.controller;


import com.example.springboot_backend.Entities.Users;

import com.example.springboot_backend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/users")

    public Users addUser(@RequestBody Users users){
        return userServices.createUser(users);

    }

    @GetMapping("/users")
    public List<Users> getAllUsersDetails(){
        return userServices.getAllUsersDetails();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUsersDetails(@PathVariable int id){
        Users users = userServices.getUsersDetails(id).orElse(null);
        if (users != null){
            return ResponseEntity.ok().body(users);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUsersDetails(@PathVariable int id , @RequestBody Users users ){
        Users updateUsers = userServices.updateUsersDetails(id, users);
        if (updateUsers != null){
            return ResponseEntity.ok(updateUsers);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable  int id){
          boolean isDeleted = userServices.deleteUsers(id);
        //return ResponseEntity.noContent().build();
        if (isDeleted){
            return ResponseEntity.ok("User deleted successfully with id : " +id);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id : " +id);
        }
    }
}
