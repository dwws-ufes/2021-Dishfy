package br.ufes.inf.dishfy.application;

import br.ufes.inf.dishfy.domain.Receita;
import br.ufes.inf.dishfy.persistence.ReceitaDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class ReceitaServiceImpl implements ReceitaService {
    @EJB
    private ReceitaDao receitaDao;

    public Receita createReceita(Receita receita){

       return receitaDao.saveReceita(receita);    
        
    }
    public Receita updateReceita(Receita receita){
       return  receitaDao.saveReceita(receita);
    }

    public Receita getReceita(Receita receita){
        return receitaDao.getReceita(receita);
    }

    public boolean deleteReceita(){
        
    }
}
