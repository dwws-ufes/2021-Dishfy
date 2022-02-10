package br.ufes.inf.dishfy.application;

import java.util.List;

import br.ufes.inf.dishfy.domain.Categoria;
import br.ufes.inf.dishfy.exceptions.MultipleObjectException;
import br.ufes.inf.dishfy.persistence.CategoriaDao;
import jakarta.ejb.EJB;

public class CategoriaServiceImpl {

    @EJB
    private CategoriaDao categoriaDao;

    public Categoria saveCategoria(Categoria categoria){
        return categoriaDao.saveCategoria(categoria);
    }
    public void deleteCategoria(Categoria categoria){
        categoriaDao.deleteCategoria(categoria);
    }
    public Categoria getCategoriaByName(String nome){
        try{
            return categoriaDao.getCategoriaByName(nome);
        } catch (MultipleObjectException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Categoria> getCategorias(){
        return categoriaDao.getCategorias();
    }
}
