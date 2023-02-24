package com.example.controledegastos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.controledegastos.models.ControleDeGastosModel;

public interface ControleGastosRepositoryJPA extends JpaRepository <ControleDeGastosModel, UUID> {
    
}
