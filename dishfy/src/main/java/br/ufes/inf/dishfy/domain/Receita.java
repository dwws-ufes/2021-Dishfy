package br.ufes.inf.dishfy.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.swing.ImageIcon;

@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private float calorias;
    private ImageIcon imagem;
    private boolean publico;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Categoria> categoria;
    @OneToMany(mappedBy = "rec")
    private List<Consumo> consumo;

    public Receita(int id, String nome, String descricao, float calorias, ImageIcon imagem, boolean publico,
            List<Categoria> categoria, List<Consumo> consumo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.calorias = calorias;
        this.imagem = imagem;
        this.publico = publico;
        this.categoria = categoria;
        this.consumo = consumo;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    public ImageIcon getImagem() {
        return imagem;
    }

    public void setImagem(ImageIcon imagem) {
        this.imagem = imagem;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

}