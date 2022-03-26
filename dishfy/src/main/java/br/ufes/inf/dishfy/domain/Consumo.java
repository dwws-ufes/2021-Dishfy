package br.ufes.inf.dishfy.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType; 

@Entity
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(nullable = false)
    private double calorias; 

    @ManyToOne
    private Receita receita;

    @ManyToOne
    private Usuario usuario;
    
    public void setCalorias(){
        this.calorias = this.receita.getCalorias();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

   
    public Receita getReceita() {
        return this.receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }
    

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    

}
