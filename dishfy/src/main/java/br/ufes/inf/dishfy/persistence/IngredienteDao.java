package br.ufes.inf.dishfy.persistence;

import java.util.List;

import br.ufes.inf.dishfy.domain.Ingrediente;

public interface IngredienteDao{

    public List<Ingrediente> getIngredientes();
    public void saveIngrediente(Ingrediente ingrediente);
    public Ingrediente getIngredientesByName(String nome);

}