package com.example.controledegastos.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledegastos.Services.ControleGastoService;
import com.example.controledegastos.dtos.ControleGastosDTO;
import com.example.controledegastos.models.ControleDeGastosModel;
import com.example.controledegastos.repositories.ControleGastosRepositoryJPA;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin (origins = "*", maxAge = 3600)
@RequestMapping("/controledegastos")
public class ControleGastoController {
    
    final ControleGastosRepositoryJPA controleGastosRepository;
    public ControleGastoController (ControleGastosRepositoryJPA controleGastosRepository){
        this.controleGastosRepository = controleGastosRepository;
    }

    @PostMapping ("/postcontroledegastos")
    public ResponseEntity<Object> SaveControleDeGastos(@RequestBody @Valid ControleGastosDTO controleGastosDTO){
        var controleGastoService = new ControleGastoService(controleGastosRepository);
        var controleDeGastosModel = new ControleDeGastosModel();
        BeanUtils.copyProperties(controleGastosDTO, controleDeGastosModel);
        controleDeGastosModel.setData(LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(controleGastoService.save(controleDeGastosModel));

    }

    @GetMapping("/getallcontroledegastos")
    public ResponseEntity <List<ControleDeGastosModel>> getAllControleGastos(){
        var controleGastoService = new ControleGastoService(controleGastosRepository);
        List<ControleDeGastosModel> controleDeGastosModelsList = controleGastoService.findAll();
        if(controleDeGastosModelsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            for (ControleDeGastosModel gastosModel : controleDeGastosModelsList){
                UUID id = gastosModel.getId();
                gastosModel.add(linkTo(methodOn(ControleGastoController.class).getOneGasto(id)).withSelfRel());
            }
            return ResponseEntity.status(HttpStatus.OK).body(controleDeGastosModelsList);
        }

    }

    @GetMapping("/GetOneControleDeGasto/{id}")
    public ResponseEntity<Object> getOneGasto(@PathVariable(value = "id")UUID id){
        var controleGastoService = new ControleGastoService(controleGastosRepository);
        Optional<ControleDeGastosModel> controleDeGastosModelOptional = controleGastoService.findById(id);
        if(!controleDeGastosModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar essa despesa.");
        }
        controleDeGastosModelOptional.get().add(linkTo(methodOn(ControleGastoController.class).getAllControleGastos()).withRel("Lista de produtos:"));
        return ResponseEntity.status(HttpStatus.OK).body(controleDeGastosModelOptional.get());
    }

    @DeleteMapping("/DeleteOneControleDeGasto/{id}")
    public ResponseEntity<Object> deleteDespesa(@PathVariable(value = "id") UUID id){
        var controleGastoService = new ControleGastoService(controleGastosRepository);
        Optional<ControleDeGastosModel> controleDeGastosModeloOptional = controleGastoService.findById(id);
        if(!controleDeGastosModeloOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar essa despesa.");
        }
        controleGastoService.delete(controleDeGastosModeloOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Despesa apagada com sucesso.");
    }

    @PutMapping("/ControleDeGasto/{id}") 
    public ResponseEntity<Object> updateControleGastos(@PathVariable (value = "id")UUID id, @RequestBody @Valid ControleGastosDTO controleGastosDTO){
        var controleGastoService = new ControleGastoService(controleGastosRepository);
        Optional<ControleDeGastosModel> controleDeGastosModeloOptional = controleGastoService.findById(id);
        if(!controleDeGastosModeloOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar essa despesa.");
        }
        var controleDeGastosModel = new ControleDeGastosModel();
        BeanUtils.copyProperties(controleGastosDTO, controleDeGastosModel);
        controleDeGastosModel.setId(controleDeGastosModeloOptional.get().getId());
        controleDeGastosModel.setData(controleDeGastosModeloOptional.get().getData());
        return ResponseEntity.status(HttpStatus.OK).body(controleGastoService.save(controleDeGastosModel));
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAllGastos(){
        var controleGastoService = new ControleGastoService(controleGastosRepository);
        List<ControleDeGastosModel> controleDeGastosModelsList = controleGastoService.findAll();
        if(controleDeGastosModelsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar despesas.");
        }
        controleGastoService.deleteAll(controleDeGastosModelsList);
        return ResponseEntity.status(HttpStatus.OK).body("Todas as despesas Apagadas");
    }
    
}
