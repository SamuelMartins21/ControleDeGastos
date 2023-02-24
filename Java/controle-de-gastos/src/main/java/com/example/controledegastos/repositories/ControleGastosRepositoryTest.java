package com.example.controledegastos.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.controledegastos.models.ControleDeGastosModel;

public class ControleGastosRepositoryTest implements IControleGastosRepository {

    private List<ControleDeGastosModel> listControleDeGastosModel;

    public ControleGastosRepositoryTest (){
        this.listControleDeGastosModel = new ArrayList<>();
    }

    @Override
    public ControleDeGastosModel save(ControleDeGastosModel controleDeGastosModel) {
        this.listControleDeGastosModel.add(controleDeGastosModel);
        controleDeGastosModel.setId(UUID.randomUUID());
        return controleDeGastosModel;
    }

    @Override
    public List<ControleDeGastosModel> findAll() {
        this.listControleDeGastosModel.stream().collect(Collectors.toList());
        return listControleDeGastosModel;
    }

    @Override
    public Optional<ControleDeGastosModel> findById(UUID id) {
        return this.listControleDeGastosModel.stream()
        .filter(listControleDeGastosModel -> listControleDeGastosModel.getId()
        .equals(id)).findFirst();
    
    }

    @Override
    public void delete(ControleDeGastosModel controleDeGastosModel) {
       System.out.println();
    }

    @Override
    public void deleteAll(List<ControleDeGastosModel> controleDeGastosModelsList) {
        System.out.println();
    }
    
}
