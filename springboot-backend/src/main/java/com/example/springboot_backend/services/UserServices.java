package com.example.springboot_backend.services;

import com.example.springboot_backend.Entities.Users;

import java.util.List;
import java.util.Optional;

public  interface UserServices  {

    public Users createUser(Users users);

    public List<Users> getAllUsersDetails();

    public Optional<Users> getUsersDetails(int id);

    public Users  updateUsersDetails(int id, Users users);

    public boolean deleteUsers(int id);
}
