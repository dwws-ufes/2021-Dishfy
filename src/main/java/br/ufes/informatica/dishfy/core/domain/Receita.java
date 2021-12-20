package br.ufes.informatica.dishfy.core.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.swing.ImageIcon;

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
