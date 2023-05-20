package com.example.controledegastos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.controledegastos.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    
}
