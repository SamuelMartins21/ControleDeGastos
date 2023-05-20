package com.example.controledegastos.dtos;

import com.example.controledegastos.enums.Categoria;
import com.example.controledegastos.enums.Status;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ControleGastosDTO {
    @Size(max=50)
    private String descrição;
    private double valor;
    @NotNull
    private Categoria categoria;
    @NotNull
    private Status status;
    
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
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    

}
