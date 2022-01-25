package br.ufes.inf.dishfy.persistence;

import java.util.List;
import br.ufes.inf.dishfy.domain.Receita;

public interface ReceitaDao {
    
    Receita saveReceita(Receita receita);
    Receita updateReceita(Receita receita);
    Receita insertOrUpdate(Receita receita);
    Receita getReceita(Receita receita);
    List<Receita> getAllReceita();


    
}