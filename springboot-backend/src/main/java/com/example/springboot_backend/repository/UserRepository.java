package com.example.springboot_backend.repository;

import com.example.springboot_backend.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
