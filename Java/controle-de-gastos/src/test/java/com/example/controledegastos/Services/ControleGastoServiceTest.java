package com.example.controledegastos.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.controledegastos.models.Categoria;
import com.example.controledegastos.models.ControleDeGastosModel;
import com.example.controledegastos.models.Status;
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
    void testDelete_ReturnTrue_WhenDespesaIsExcluded() {
        
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setStatus(Status.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        controleGastoService.save(controleGastosModel);
        controleGastoService.delete(controleGastosModel);
        Optional<ControleDeGastosModel> controleDeGastosModelOptional = controleGastoService.findById(controleGastosModel.getId());

        Assertions.assertTrue(controleDeGastosModelOptional.isEmpty());
        
    }

    @Test
    void testDeleteAll_ReturnTrue_WhenDespesaAllIsExcluded() {
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setStatus(Status.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        controleGastoService.save(controleGastosModel);
        List<ControleDeGastosModel> controleDeGastosModelList = controleGastoService.findAll();
        controleGastoService.deleteAll(controleDeGastosModelList);

        Assertions.assertTrue(controleDeGastosModelList.isEmpty());
    }

    @Test
    void testFindAll_ReturnTrue_WhenDespesaIsPresent() {
        
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setStatus(Status.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        controleGastoService.save(controleGastosModel);
        List<ControleDeGastosModel> controleDeGastosModelIsPresent = controleGastoService.findAll();
        
        Assertions.assertTrue(controleDeGastosModelIsPresent.contains(controleGastosModel));

    }

    @Test
    void testFindAll_ReturnFalse_WhenDespesaIsNoPresent() {
        
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setStatus(Status.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        controleGastoService.save(controleGastosModel);
        controleGastoService.delete(controleGastosModel);
        List<ControleDeGastosModel> controleDeGastosModelIsNoPresent = controleGastoService.findAll();
        
        
        Assertions.assertFalse(controleDeGastosModelIsNoPresent.contains(controleGastosModel));

    }


    @Test
    void testFindById_ReturnTrue_WhenIdIsPresent() {
        
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setStatus(Status.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        controleGastoService.save(controleGastosModel);
        Optional<ControleDeGastosModel> controleDeGastosModelIdIsPresent = controleGastoService
        .findById(controleGastosModel.getId());

        Assertions.assertTrue(controleDeGastosModelIdIsPresent.isPresent());

        }

    @Test
    void testFindById_ReturnNullPointerException_WhenIdIsNull(){
        
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setStatus(Status.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        controleGastoService.save(controleGastosModel);
        controleGastosModel.setId(null);

        Assertions.assertThrows(NullPointerException.class, () -> controleGastoService.
        findById(controleGastosModel.getId()));

    }

    @Test
    void testFindById_ReturnFalse_WhenIdIsincorrect() {
        
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setStatus(Status.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        controleGastoService.save(controleGastosModel);

        Optional<ControleDeGastosModel> controleDeGastosModelOptional = controleGastoService.findById(UUID.randomUUID());
        Assertions.assertFalse(controleDeGastosModelOptional.isPresent());

    }

    @Test
    void testSave_ReturnNotNullId_WhenDespesaToSave() {
        
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setStatus(Status.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        controleGastoService.save(controleGastosModel);

        Assertions.assertNotNull(controleGastosModel.getId());

    }

    @Test
    void testSave_ReturnNull_WhenFieldIsNull(){
        controleGastosModel.setDescrição("teste");
        controleGastosModel.setValor(20);
        controleGastosModel.setStatus(Status.PAGA);
        
        controleGastoService.save(controleGastosModel);

        Assertions.assertEquals(null, controleGastosModel.getCategoria());

    }

}
