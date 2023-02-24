package com.example.controledegastos.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.controledegastos.models.Categoria;
import com.example.controledegastos.models.ControleDeGastosModel;
import com.example.controledegastos.models.Situação;
import com.example.controledegastos.repositories.ControleGastosRepositoryTest;

public class ControleGastoServiceTest {
    
    private ControleGastosRepositoryTest controleGastosRepository;
    private ControleGastoService controleGastoService;
    private ControleDeGastosModel controleGastosModel;

    @BeforeEach
    public void setUp(){
        controleGastosRepository = new ControleGastosRepositoryTest();
        controleGastoService = new ControleGastoService(controleGastosRepository);
        controleGastosModel = new ControleDeGastosModel();

    }
    
    @Test
    void testDelete() {

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
    void testSave_Returntrue_WhenDespesaToSave() {
        
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setSituação(Situação.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        ControleDeGastosModel controleDeGastosModelSave = controleGastoService.save(controleGastosModel);

        assertNotNull(controleDeGastosModelSave.getId());

    }

    @Test
    void testSave_ReturnFalse_WhenFieldIsNull(){
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setSituação(Situação.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);
        
        ControleDeGastosModel controleDeGastosModelSaveNull = controleGastoService.save(controleGastosModel);

        assertTrue(controleDeGastosModelSaveNull.getValor() == 0);
    }

}
