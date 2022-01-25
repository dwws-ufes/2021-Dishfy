package br.ufes.inf.dishfy.application;

import br.ufes.inf.dishfy.domain.Ingrediente;
import br.ufes.inf.dishfy.persistence.IngredienteDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class IngredienteServiceImpl implements IngredienteService{
    @EJB
    private IngredienteDao ingredienteDao;

    public Ingrediente getIngrediente(String nome) {
        return ingredienteDao.getIngredientesByName(nome);
    }


}
