package br.ufes.inf.dishfy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ingrediente {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double calorias;

    @Column(nullable = false)
    private String grandeza;

    // public Ingrediente(int id, String nome, float calorias) {
    //     this.id = id;
    //     this.nome = nome;
    //     this.calorias = calorias;
    // }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getCalorias() {
        return calorias;
    }
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }
    public void setGrandeza(String grandeza){
        this.grandeza = grandeza;
    }
    public String getGrandeza(){
        return this.grandeza;
    }
    
}
