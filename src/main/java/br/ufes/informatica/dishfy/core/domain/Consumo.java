package br.ufes.informatica.dishfy.core.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Consumo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int idUsuario;
    @Column(nullable = false)
    private int idReceita;
    @Column(nullable = false)
    private Date data;
    
 
    public Consumo(int id, int idUsuario, int idReceita, Date data) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idReceita = idReceita;
        this.data = data;
        
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
