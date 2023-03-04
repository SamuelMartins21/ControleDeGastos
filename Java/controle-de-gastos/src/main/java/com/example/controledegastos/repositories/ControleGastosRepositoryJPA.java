package com.example.controledegastos.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.controledegastos.models.ControleDeGastosModel;

@Service
public class ControleGastosRepositoryJPA implements IControleGastosRepository{

    final ControleGastosRepository controleGastosRepositoryJPA;
    public ControleGastosRepositoryJPA(ControleGastosRepository controleGastosRepositoryJPA){
        this.controleGastosRepositoryJPA = controleGastosRepositoryJPA;
    }

    @Override
    public ControleDeGastosModel save(ControleDeGastosModel controleDeGastosModel) {
       return controleGastosRepositoryJPA.save(controleDeGastosModel);
    }

    @Override
    public List<ControleDeGastosModel> findAll() {
      return controleGastosRepositoryJPA.findAll();
    }

    @Override
    public Optional<ControleDeGastosModel> findById(UUID id) {
        return controleGastosRepositoryJPA.findById(id);
    }

    @Override
    public void delete(ControleDeGastosModel controleDeGastosModel) {
        controleGastosRepositoryJPA.delete(controleDeGastosModel);
    }

    @Override
    public void deleteAll(List<ControleDeGastosModel> controleDeGastosModelsList) {
        controleGastosRepositoryJPA.deleteAll(controleDeGastosModelsList);
    }
    
}
