package br.ufes.inf.dishfy.persistence;

import java.util.List;

import br.ufes.inf.dishfy.domain.Ingrediente;
import jakarta.ejb.Local;
@Local
public interface IngredienteDao{

    public List<Ingrediente> getIngredientes();
    public void saveIngrediente(Ingrediente ingrediente);
    public Ingrediente getIngredientesByName(String nome);
    public Ingrediente getIngredientesById(int ingredienteId);
}