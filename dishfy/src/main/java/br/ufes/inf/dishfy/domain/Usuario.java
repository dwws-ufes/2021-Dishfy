package br.ufes.inf.dishfy.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import javax.swing.ImageIcon;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String login;

    @Column(length = 16, nullable = false)
    private String senha;

    private ImageIcon fotoPerfil;

    @Column(nullable = false)
    private int tamanhoMax;

    @OneToMany //(mappedBy = "user")
    private List<Consumo> consumo;

    @ManyToMany
    private List<Receita> receitas;

    public List<Receita> getReceitas() {
        return this.receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    public Usuario(int id, String nome, String login, String senha, 
        ImageIcon fotoPerfil, int tamanhoMax, List<Consumo> consumo,
        List<Receita> receitas) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.fotoPerfil = fotoPerfil;
        this.tamanhoMax = tamanhoMax;
        this.consumo = consumo;
        this.receitas = receitas;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ImageIcon getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(ImageIcon fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public int getTamanhoMax() {
        return tamanhoMax;
    }

    public void setTamanhoMax(int tamanhoMax) {
        this.tamanhoMax = tamanhoMax;
    }

}
