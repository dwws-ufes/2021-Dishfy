package br.ufes.inf.dishfy.persistence;

import java.util.List;
import br.ufes.inf.dishfy.domain.Receita;
import br.ufes.inf.dishfy.exceptions.MultipleObjectException;
import jakarta.ejb.Local;

@Local
public interface ReceitaDao {
    
    public Receita saveReceita(Receita receita);
    public Receita updateReceita(Receita receita);
    public Receita insertOrUpdate(Receita receita);
    public Receita getReceita(Receita receita);
    public List<Receita> getAllReceita();
    public void deleteReceita(Receita receita);
    public Receita getReceitaById(int receitaId);
    public List<Receita> getAllPublicReceita();
    public List<Receita> getReceitasByCategoria(int idCategoria);
    public List<Receita> getReceitasByUsuario(int idUsuario);
}