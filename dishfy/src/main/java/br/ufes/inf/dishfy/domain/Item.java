package br.ufes.inf.dishfy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private double quantidade;

    @Column(nullable = false)
    private String grandeza;
    
    @ManyToOne
    private Ingrediente ingrediente;

    @ManyToOne(fetch = FetchType.LAZY)
    private Receita receita;
    
    // public Item(int id, Ingrediente ingrediente, Receita receita, float quantidade) {
    //     this.id = id;
    //     this.ingrediente = ingrediente;
    //     this.receita = receita;
    //     this.quantidade = quantidade;
    // }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Ingrediente getIngrediente() {
        return this.ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Receita getReceita() {
        return this.receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }    
    
    public double getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getGrandeza() {
        return this.grandeza;
    }

    public void setGrandeza(String grandeza) {
        this.grandeza = grandeza;
    }

    public String getQuantidadeString(){
        return this.grandeza.toString();
    }
}
