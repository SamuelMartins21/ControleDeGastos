package com.example.controledegastos.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.controledegastos.models.ControleDeGastosModel;

public interface IControleGastosRepository {

    public ControleDeGastosModel save(ControleDeGastosModel controleDeGastosModel);
    public List<ControleDeGastosModel> findAll();
    public Optional<ControleDeGastosModel> findById(UUID id);
    public void delete(ControleDeGastosModel controleDeGastosModel);
    public void deleteAll(List<ControleDeGastosModel> controleDeGastosModelsList);

}
    
