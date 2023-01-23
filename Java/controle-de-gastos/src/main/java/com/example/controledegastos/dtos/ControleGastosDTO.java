package com.example.controledegastos.dtos;

import com.example.controledegastos.models.Categoria;
import com.example.controledegastos.models.Situação;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ControleGastosDTO {
    @Size(max=50)
    private String descrição;
    @NotNull
    private double valor;
    @NotNull
    private Categoria categoria;
    @NotNull
    private Situação situação;
    
    public String getDescrição() {
        return descrição;
    }
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Situação getSituação() {
        return situação;
    }
    public void setSituação(Situação situação) {
        this.situação = situação;
    }
    

}
