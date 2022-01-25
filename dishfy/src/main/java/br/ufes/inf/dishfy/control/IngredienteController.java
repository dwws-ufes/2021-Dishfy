package br.ufes.inf.dishfy.control;

import java.io.Serializable;

import br.ufes.inf.dishfy.application.IngredienteService;
import br.ufes.inf.dishfy.domain.Ingrediente;
import jakarta.ejb.EJB;

public class IngredienteController implements Serializable {

    @EJB
    private IngredienteService ingredienteService;

    private String nome;

    public Ingrediente consultaIngrediente(){
        return ingredienteService.getIngrediente(nome);
    }
}
