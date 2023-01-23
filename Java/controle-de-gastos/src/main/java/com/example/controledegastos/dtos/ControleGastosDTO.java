package com.example.controledegastos.dtos;

import com.example.controledegastos.models.Categoria;
import com.example.controledegastos.models.Situação;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ControleGastosDTO {
    @Size(max=50)
    private String descrição;
    @NotBlank
    @Size(max = 10)
    private int valor;
    @NotBlank
    @Size(max = 20)
    private Categoria categoria;
    @NotBlank
    @Size(max = 20)
    private Situação situação;
    
    public String getDescrição() {
        return descrição;
    }
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
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
