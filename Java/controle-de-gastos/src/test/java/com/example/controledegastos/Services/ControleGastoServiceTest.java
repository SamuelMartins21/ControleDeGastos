package com.example.controledegastos.Services;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
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
    void testFindById_ReturnTrue_WhenIdIsPresent() {
        
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setSituação(Situação.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        ControleDeGastosModel controleDeGastosModelSave = controleGastoService.save(controleGastosModel);
        Optional<ControleDeGastosModel> controleDeGastosModelIdIsPresent = controleGastoService.findById(controleDeGastosModelSave.getId());

        Assertions.assertTrue(controleDeGastosModelIdIsPresent.isPresent());

        }

    @Test
    void testFindById_ReturnNullPointerException_WhenIdIsNull(){
        
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setSituação(Situação.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        ControleDeGastosModel controleDeGastosModelSave = controleGastoService.save(controleGastosModel);
        controleDeGastosModelSave.setId(null);

        Assertions.assertThrows(NullPointerException.class, () -> controleGastoService.
        findById(controleDeGastosModelSave.getId()));

    }

    @Test
    void testFindById_ReturnFalse_WhenIdIsincorrect() {
        
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setSituação(Situação.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        ControleDeGastosModel controleDeGastosModelSave = controleGastoService.save(controleGastosModel);

        Optional<ControleDeGastosModel> controleDeGastosModelOptional = controleGastoService.findById(UUID.randomUUID());
        Assertions.assertFalse(controleDeGastosModelOptional.isPresent());

    }

    @Test
    void testSave_ReturnNotNullId_WhenDespesaToSave() {
        
        controleGastosModel.setDescrição("Teste 1");
        controleGastosModel.setValor(20);
        controleGastosModel.setSituação(Situação.PAGA);
        controleGastosModel.setCategoria(Categoria.Alimentação);

        ControleDeGastosModel controleDeGastosModelSave = controleGastoService.save(controleGastosModel);

        Assertions.assertNotNull(controleDeGastosModelSave.getId());

    }

    @Test
    void testSave_ReturnNull_WhenFieldIsNull(){
        controleGastosModel.setDescrição("teste");
        controleGastosModel.setValor(20);
        controleGastosModel.setSituação(Situação.PAGA);
        
        ControleDeGastosModel controleDeGastosModelSaveNull = controleGastoService.save(controleGastosModel);

        Assertions.assertEquals(null, controleDeGastosModelSaveNull.getCategoria());

    }

}
