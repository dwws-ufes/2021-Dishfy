package br.ufes.inf.dishfy.application;

import java.io.Serializable;
import br.ufes.inf.dishfy.domain.Ingrediente;

public interface IngredienteService extends Serializable {

    public Ingrediente getIngrediente(String nome);
}
