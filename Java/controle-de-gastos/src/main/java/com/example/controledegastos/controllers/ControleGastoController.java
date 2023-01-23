package com.example.controledegastos.controllers;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledegastos.Services.ControleGastoService;
import com.example.controledegastos.dtos.ControleGastosDTO;
import com.example.controledegastos.models.ControleDeGastosModel;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/ControleDeGasto")
public class ControleGastoController {
    final ControleGastoService controleGastoService;

    public ControleGastoController(ControleGastoService controleGastoService){
        this.controleGastoService = controleGastoService;
    }

    @PostMapping
    public ResponseEntity<Object> SaveControleDeGastos(@RequestBody @Valid ControleGastosDTO controleGastosDTO){
        var controleDeGastosModel = new ControleDeGastosModel();
        BeanUtils.copyProperties(controleGastosDTO, controleDeGastosModel);
        controleDeGastosModel.setData(LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(controleGastoService.save(controleDeGastosModel));

    }
}
