package com.example.controledegastos.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.controledegastos.enums.Categoria;
import com.example.controledegastos.enums.Status;
import com.example.controledegastos.models.ControleDeGastosModel;
import com.example.controledegastos.repositories.ControleGastosRepositoryTest;

class ControleGastoServiceTest {
    
    private ControleGastosRepositoryTest controleGastosRepositoryTest;
    private ControleGastoService controleGastoService;
    private ControleDeGastosModel controleGastosModel;

    @BeforeEach
    void setUp(){
        controleGastosRepositoryTest = new ControleGastosRepositoryTest();
        controleGastoService = new ControleGastoService(controleGastosRepositoryTest);
        controleGastosModel = new ControleDeGastosModel();

        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setStatus(Status.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

    }
    
    @Test
    void testDelete_ReturnTrue_WhenDespesaIsExcluded() {

        controleGastoService.save(controleGastosModel);
        controleGastoService.delete(controleGastosModel);
        Optional<ControleDeGastosModel> controleDeGastosModelOptional = controleGastoService.findById(controleGastosModel.getId());

        assertTrue(controleDeGastosModelOptional.isEmpty());
        
    }

    @Test
    void testDeleteAll_ReturnTrue_WhenDespesaAllIsExcluded() {

        controleGastoService.save(controleGastosModel);
        List<ControleDeGastosModel> controleDeGastosModelList = controleGastoService.findAll();
        controleGastoService.deleteAll(controleDeGastosModelList);

        assertTrue(controleDeGastosModelList.isEmpty());
    }

    @Test
    void testFindAll_ReturnTrue_WhenDespesaIsPresent() {

        controleGastoService.save(controleGastosModel);
        List<ControleDeGastosModel> controleDeGastosModelIsPresent = controleGastoService.findAll();
        
        assertTrue(controleDeGastosModelIsPresent.contains(controleGastosModel));

    }

    @Test
    void testFindAll_ReturnFalse_WhenDespesaIsNoPresent() {

        controleGastoService.save(controleGastosModel);
        controleGastoService.delete(controleGastosModel);
        List<ControleDeGastosModel> controleDeGastosModelIsNoPresent = controleGastoService.findAll();
        
        assertFalse(controleDeGastosModelIsNoPresent.contains(controleGastosModel));

    }


    @Test
    void testFindById_ReturnTrue_WhenIdIsPresent() {

        controleGastoService.save(controleGastosModel);
        Optional<ControleDeGastosModel> controleDeGastosModelIdIsPresent = controleGastoService
        .findById(controleGastosModel.getId());

        assertTrue(controleDeGastosModelIdIsPresent.isPresent());

        }

    @Test
    void testFindById_ReturnNullPointerException_WhenIdIsNull(){

        controleGastoService.save(controleGastosModel);
        controleGastosModel.setId(null);

        assertThrows(NullPointerException.class, () -> controleGastoService.
        findById(controleGastosModel.getId()));

    }

    @Test
    void testFindById_ReturnFalse_WhenIdIsincorrect() {

        controleGastoService.save(controleGastosModel);

        Optional<ControleDeGastosModel> controleDeGastosModelOptional = controleGastoService.findById(UUID.randomUUID());
        assertFalse(controleDeGastosModelOptional.isPresent());

    }

    @Test
    void testSave_ReturnNotNullId_WhenDespesaToSave() {

        controleGastoService.save(controleGastosModel);

        assertNotNull(controleGastosModel.getId());

    }

    @Test
    void testSave_ReturnNull_WhenFieldIsNull(){
        controleGastosModel.setCategoria(null);
        
        controleGastoService.save(controleGastosModel);

        assertNull(controleGastosModel.getCategoria());

    }

}
