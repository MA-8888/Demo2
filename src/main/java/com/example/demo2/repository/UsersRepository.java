package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

}