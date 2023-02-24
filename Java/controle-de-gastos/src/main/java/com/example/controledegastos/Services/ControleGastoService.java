package com.example.controledegastos.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.controledegastos.models.ControleDeGastosModel;
import com.example.controledegastos.repositories.IControleGastosRepository;

import jakarta.transaction.Transactional;

@Service
public class ControleGastoService {
    
    final IControleGastosRepository controleGastosRepository;

    public ControleGastoService(IControleGastosRepository controleGastosRepository){
        this.controleGastosRepository = controleGastosRepository;
    }

    @Transactional
    public ControleDeGastosModel save(ControleDeGastosModel controleDeGastosModel){
        return controleGastosRepository.save(controleDeGastosModel);
    }
    
    public List<ControleDeGastosModel> findAll(){
        return controleGastosRepository.findAll();
    }

    public Optional<ControleDeGastosModel> findById(UUID id){
        return controleGastosRepository.findById(id);

    }

    @Transactional
    public void delete(ControleDeGastosModel controleDeGastosModel){
        controleGastosRepository.delete(controleDeGastosModel);
    }

    @Transactional
    public void deleteAll(List<ControleDeGastosModel> controleDeGastosModelsList){
        controleGastosRepository.deleteAll(controleDeGastosModelsList);
    }   
    
}
