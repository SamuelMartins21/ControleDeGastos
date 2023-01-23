package com.example.controledegastos.Services;

import org.springframework.stereotype.Service;

import com.example.controledegastos.models.ControleDeGastosModel;
import com.example.controledegastos.repositories.ControleGastosRepository;

import jakarta.transaction.Transactional;

@Service
public class ControleGastoService {
    
    final ControleGastosRepository controleGastosRepository;

    public ControleGastoService(ControleGastosRepository controleGastosRepository){
        this.controleGastosRepository = controleGastosRepository;
    }

    @Transactional
    public ControleDeGastosModel save(ControleDeGastosModel controleDeGastosModel){
        return controleGastosRepository.save(controleDeGastosModel);
    }
}
