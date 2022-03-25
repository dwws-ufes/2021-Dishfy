package br.ufes.inf.dishfy.application;

import java.io.Serializable;
import java.util.List;

import br.ufes.inf.dishfy.domain.Receita;
import jakarta.ejb.Local;
@Local
public interface ReceitaService extends Serializable {
    public Receita createReceita(Receita receita);
    public Receita updateReceita(Receita receita);
    public Receita getReceita(Receita receita);
    public Receita getReceitaById(int receitaId);
    public void deleteReceita(Receita receita);
    public List<Receita> getAllReceita();
    public List<Receita> getPublicReceitas();
    public List<Receita> getCategoriaReceitas(int idCategoria);
    public List<Receita> getReceitasUsuario(int idUsuario);
}
