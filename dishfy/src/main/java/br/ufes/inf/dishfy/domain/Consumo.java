package br.ufes.inf.dishfy.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne; 

@Entity
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // @Column(nullable = false)
    // // @JoinColumn(name = "user_id", nullable = false)
    // private int idUsuario;

    // @Column(nullable = false)
    // // @JoinColumn(name = "rec_id", nullable = false)
    // private int idReceita;

    @Column(nullable = false)
    private Date data;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Receita receita;

    public Consumo(int id, Date data, Usuario usuario, Receita receita) {
        this.id = id;
        // this.idUsuario = idUsuario;
        // this.idReceita = idReceita;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Receita getReceita() {
        return this.receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }
    

}
