package com.example.controledegastos.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledegastos.Services.ControleGastoService;

@RestController
@CrossOrigin
@RequestMapping("/ControleDeGasto")
public class ControleGastoController {
    final ControleGastoService controleGastoService;

    public ControleGastoController(ControleGastoService controleGastoService){
        this.controleGastoService = controleGastoService;
    }

}
