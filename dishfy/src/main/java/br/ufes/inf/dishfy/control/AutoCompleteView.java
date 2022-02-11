package br.ufes.inf.dishfy.control;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.ufes.inf.dishfy.application.IngredienteService;
import br.ufes.inf.dishfy.domain.Ingrediente;
import jakarta.annotation.ManagedBean;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class AutoCompleteView {

    private String consulta;
    private Ingrediente ingrediente;

    @Inject
    private IngredienteService ingredienteService;

    public List<String> completeText(String query) {
        System.out.println("------ AUTO COMPLETE " + query);
        String queryLowerCase = query.toLowerCase();
        List<String> ingredientList = new ArrayList<>();
        List<Ingrediente> ingredientes = ingredienteService.getIngredientes();

        for (Ingrediente ingrediente : ingredientes) {
            ingredientList.add(ingrediente.getNome());
        }

        return ingredientList.stream().filter(c -> c.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }

    public List<Ingrediente> completeIngrediente(String query){
        System.out.println("------ AUTO COMPLETE ");
        String queryLowerCase = query.toLowerCase();
        List<Ingrediente> ingredientes = ingredienteService.getIngredientes();
        return ingredientes.stream().filter(t -> t.getNome().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }

    
    public List<String> getFoo() {
        System.out.println("------ AUTO COMPLETE ");
        List<String> results = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            results.add(""+i);
        }
         
        return results;
    }

    public String getConsulta() {
        return this.consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public Ingrediente getIngrediente() {
        return this.ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

}
