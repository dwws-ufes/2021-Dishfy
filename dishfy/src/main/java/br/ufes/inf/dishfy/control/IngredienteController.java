package br.ufes.inf.dishfy.control;

import java.io.Serializable;

import br.ufes.inf.dishfy.application.IngredienteService;
import br.ufes.inf.dishfy.domain.Ingrediente;
import jakarta.ejb.EJB;
import jakarta.enterprise.inject.Model;
@Model
public class IngredienteController implements Serializable {

    @EJB
    private IngredienteService ingredienteService;

    private String nome;
    private Ingrediente ingrediente;

    public void consultaIngrediente(){
        ingrediente = ingredienteService.getIngrediente(nome);
    }
}
