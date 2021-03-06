package br.ufes.inf.dishfy.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

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
    private double calorias;

    // @OneToOne
    // private ImageDishfy imagem;
    
    @Column(nullable = false)
    private boolean publico;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    /** A principio, nao ha necessidade da receita saber qual foi seu consumo */
    // @OneToMany
    // private List<Consumo> consumo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receita")
    private List<Item> itens;

    @ManyToOne
    private Usuario autor;

    // public Receita(int id, String nome, String descricao, 
    //     float calorias, ImageIcon imagem, boolean publico,
    //     List<Categoria> categoria, List<Item> itens){//, List<Consumo> consumo) {
    //     this.id = id;
    //     this.nome = nome;
    //     this.descricao = descricao;
    //     this.calorias = calorias;
    //     this.imagem = imagem;
    //     this.publico = publico;
    //     this.categoria = categoria;
    //     this.itens = itens;
    //     // this.consumo = consumo;
    // }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
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

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public boolean getPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public List<Item> getItens() {
        return this.itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    // public ImageDishfy getImagem() {
    //     return this.imagem;
    // }

    // public void setImagem(ImageDishfy imagem) {
    //     this.imagem = imagem;
    // }
}
