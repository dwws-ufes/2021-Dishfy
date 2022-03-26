package br.ufes.inf.dishfy.application;

import java.util.List;

import br.ufes.inf.dishfy.domain.Ingrediente;
import br.ufes.inf.dishfy.openfoodfacts.OpenFoodFacts;
import br.ufes.inf.dishfy.persistence.IngredienteDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class IngredienteServiceImpl implements IngredienteService{
    @EJB
    private IngredienteDao ingredienteDao;

    public Ingrediente getIngrediente(String nome) {
        Ingrediente ingredienteBuscado;
        ingredienteBuscado = ingredienteDao.getIngredientesByName(nome);
        if(ingredienteBuscado != null){
            return ingredienteBuscado;
        }
        ingredienteBuscado = OpenFoodFacts.getIngredienteAPI(nome, "http://localhost:2020/sparql");
        ingredienteBuscado = ingredienteDao.saveIngrediente(ingredienteBuscado);
        return ingredienteBuscado;
    }

    public Ingrediente getIngredienteById(int ingredienteId){
        return ingredienteDao.getIngredientesById(ingredienteId);
    }

    public List<Ingrediente> getIngredientes() {
        return ingredienteDao.getIngredientes();
    }
}
