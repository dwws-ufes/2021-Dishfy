package br.ufes.informatica.dishfy.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.ImageIcon;
@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String login;
    @Column(length = 16)
    private String senha;
    private ImageIcon fotoPerfil;
    private int tamanhoMax;

    public Usuario(int id, String nome, String login, String senha, ImageIcon fotoPerfil, int tamanhoMax) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.fotoPerfil = fotoPerfil;
        this.tamanhoMax = tamanhoMax;
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
