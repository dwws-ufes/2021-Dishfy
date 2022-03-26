package br.ufes.inf.dishfy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ImageDishfy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nome;

    @OneToOne
    private Receita receita;
     
    @Column(nullable = false, length=65535)
    private byte[] image;

    public ImageDishfy() {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Receita getReceita() {
        return this.receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    
}
