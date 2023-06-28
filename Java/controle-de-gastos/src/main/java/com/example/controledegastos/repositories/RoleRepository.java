package com.example.controledegastos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.controledegastos.models.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, UUID> {
    
}
