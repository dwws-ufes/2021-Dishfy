package br.ufes.inf.dishfy.control;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.ufes.inf.dishfy.application.IngredienteService;
import br.ufes.inf.dishfy.domain.Ingrediente;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class AutoCompleteView {
    private String consulta;

    @EJB
    private IngredienteService ingredienteService;

    public List<String> completeText(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> ingredientList = new ArrayList<>();
        List<Ingrediente> ingredientes = ingredienteService.getIngredientes();
        for (Ingrediente ingrediente : ingredientes) {
            ingredientList.add(ingrediente.getNome());
        }
        return ingredientList.stream().filter(c -> c.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
}
