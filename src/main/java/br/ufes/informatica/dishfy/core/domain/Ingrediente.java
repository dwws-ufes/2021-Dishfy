package br.ufes.informatica.dishfy.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingrediente {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private float calorias;
    public Ingrediente(int id, String nome, float calorias) {
        this.id = id;
        this.nome = nome;
        this.calorias = calorias;
    }
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
    public float getCalorias() {
        return calorias;
    }
    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    

    
    
}
