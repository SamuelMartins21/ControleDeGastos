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
import org.springframework.web.bind.annotation.RestController;

import com.example.controledegastos.Services.ControleGastoService;
import com.example.controledegastos.dtos.ControleGastosDTO;
import com.example.controledegastos.models.ControleDeGastosModel;

import jakarta.validation.Valid;

@RestController
@CrossOrigin (origins = "*", maxAge = 3600)
public class ControleGastoController {
    final ControleGastoService controleGastoService;

    public ControleGastoController(ControleGastoService controleGastoService){
        this.controleGastoService = controleGastoService;
    }

    @PostMapping ("/postcontroledegastos")
    public ResponseEntity<Object> SaveControleDeGastos(@RequestBody @Valid ControleGastosDTO controleGastosDTO){
        var controleDeGastosModel = new ControleDeGastosModel();
        BeanUtils.copyProperties(controleGastosDTO, controleDeGastosModel);
        controleDeGastosModel.setData(LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(controleGastoService.save(controleDeGastosModel));

    }

    @GetMapping("/getallcontroledegastos")
    public ResponseEntity <List<ControleDeGastosModel>> getAllControleGastos(){
        return ResponseEntity.status(HttpStatus.OK).body(controleGastoService.findAll());
    }

    @GetMapping("/ControleDeGasto/{id}")
    public ResponseEntity<Object> getOneGasto(@PathVariable(value = "id")UUID id){
        Optional<ControleDeGastosModel> controleDeGastosModelOptional = controleGastoService.findById(id);
        if(!controleDeGastosModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar essa despesa.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(controleDeGastosModelOptional.get());
    }

    @DeleteMapping("/ControleDeGasto/{id}")
    public ResponseEntity<Object> deleteDespesa(@PathVariable(value = "id") UUID id){
        Optional<ControleDeGastosModel> controleDeGastosModeloOptional = controleGastoService.findById(id);
        if(!controleDeGastosModeloOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar essa despesa.");
        }
        controleGastoService.delete(controleDeGastosModeloOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Despesa apagada com sucesso.");
    }

    @PutMapping("/ControleDeGasto/{id}") 
    public ResponseEntity<Object> updateControleGastos(@PathVariable (value = "id")UUID id, @RequestBody @Valid ControleGastosDTO controleGastosDTO){
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
}
