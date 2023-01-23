package com.example.controledegastos.Services;

import org.springframework.stereotype.Service;

import com.example.controledegastos.repositories.ControleGastosRepository;

@Service
public class ControleGastoService {
    
    final ControleGastosRepository controleGastosRepository;

    public ControleGastoService(ControleGastosRepository controleGastosRepository){
        this.controleGastosRepository = controleGastosRepository;
    }

    
}
