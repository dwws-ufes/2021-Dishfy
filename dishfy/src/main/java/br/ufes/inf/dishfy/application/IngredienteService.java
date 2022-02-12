package br.ufes.inf.dishfy.application;

import java.io.Serializable;
import java.util.List;

import br.ufes.inf.dishfy.domain.Ingrediente;
import jakarta.ejb.Local;

@Local
public interface IngredienteService extends Serializable {

    public Ingrediente getIngrediente(String nome);

    public Ingrediente getIngredienteById(int ingredienteId);
    
    public List<Ingrediente> getIngredientes();
}
