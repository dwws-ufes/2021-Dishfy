package br.ufes.inf.dishfy.application;

import java.util.List;

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
       return  receitaDao.updateReceita(receita);
    }

    public Receita getReceita(Receita receita){
        return receitaDao.getReceita(receita);
    }

    public void deleteReceita(Receita receita){
        receitaDao.deleteReceita(receita);
    }

    public List<Receita> getAllReceita(){
        return receitaDao.getAllReceita();
    }

    public Receita getReceitaById(int receitaId){
        return receitaDao.getReceitaById(receitaId);            
    }

    public List<Receita> getPublicReceitas(){
        return receitaDao.getAllPublicReceita();
    }

    public List<Receita> getCategoriaReceitas(int idCategoria){
        return receitaDao.getReceitasByCategoria(idCategoria);
    }

    public List<Receita> getReceitasUsuario(int idUsuario){
        return receitaDao.getReceitasByUsuario(idUsuario);
    }
}
