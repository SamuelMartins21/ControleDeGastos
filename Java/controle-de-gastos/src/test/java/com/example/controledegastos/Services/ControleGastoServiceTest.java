package com.example.controledegastos.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.controledegastos.models.Categoria;
import com.example.controledegastos.models.ControleDeGastosModel;
import com.example.controledegastos.models.Situação;
import com.example.controledegastos.repositories.ControleGastosRepository;

public class ControleGastoServiceTest {
    private ControleGastoService service;
    private ControleGastosRepository repository;

    @BeforeEach
    public void setUp(){
        service = new ControleGastoService(repository);
    }

    @Test
    void testDelete_ReturnTrue_QuandoDespesaForEncontrada() {
       ControleDeGastosModel model = new ControleDeGastosModel();
       model.setDescrição("Despesa preenchida");
       model.setCategoria(Categoria.Alimentação);
       model.setValor(20);
       model.setSituação(Situação.PAGA);
       
    }
    
    @Test
    void testDelete_ReturnTrue_QuandoDespesaNaoForEncontrada() {
       
    }

    @Test
    void testDelete_ReturnFalse_QuandoDespesaForNula() {
       
    }

    @Test
    void testDeleteAll() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testSave() {

    }
}
