package com.example.springboot_backend.repository;

import com.example.springboot_backend.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {


}
