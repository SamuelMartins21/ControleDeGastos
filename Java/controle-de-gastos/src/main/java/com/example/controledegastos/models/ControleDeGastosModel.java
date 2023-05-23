package com.example.controledegastos.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import com.example.controledegastos.enums.Categoria;
import com.example.controledegastos.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "TB_CONTROLE_GASTOS")
public class ControleDeGastosModel extends RepresentationModel<ControleDeGastosModel> implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; 
    @Column(nullable = true, length = 50)
    private String descrição;
    @Column(nullable = false)
    private double valor;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Status status;
    @Column(nullable = false)
    private LocalDate data;
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
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
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
   
    @Override
    public String toString() {
        return "ControleDeGastosModel [id=" + id + ", descrição=" + descrição + ", valor=" + valor + ", categoria="
                + categoria + ", situação=" + status + ", data=" + data + "]";
    }
    
    

}
