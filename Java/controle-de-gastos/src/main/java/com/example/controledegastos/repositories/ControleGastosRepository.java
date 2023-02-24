package com.example.controledegastos.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.controledegastos.models.ControleDeGastosModel;

@Service
public class ControleGastosRepository implements IControleGastosRepository{

    final ControleGastosRepositoryJPA controleGastosRepositoryJPA;
    public ControleGastosRepository(ControleGastosRepositoryJPA controleGastosRepositoryJPA){
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(ControleDeGastosModel controleDeGastosModel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAll(List<ControleDeGastosModel> controleDeGastosModelsList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }
    
}
