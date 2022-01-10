package br.ufes.inf.dishfy.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int idUsuario;
    @Column(nullable = false)
    private int idReceita;
    @Column(nullable = false)
    private Date data;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "rec_id", nullable = false)
    private Receita receita;

    public Consumo(int id, int idUsuario, int idReceita, Date data, Usuario usuario, Receita receita) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idReceita = idReceita;
        this.data = data;
        this.usuario = usuario;
        this.receita = receita;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
