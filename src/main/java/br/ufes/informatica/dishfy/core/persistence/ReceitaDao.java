package br.ufes.informatica.dishfy.core.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufes.informatica.dishfy.core.domain.Receita;

public interface ReceitaDao {
    
    Receita saveReceita(Receita receita);
    Receita updateReceita(Receita receita);
    Receita insertOrUpdate(Receita receita);
    Receita getReceita(Receita receita);
    List<Receita> getAllReceita();


    
}
