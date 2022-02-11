package br.ufes.inf.dishfy.control;

import java.util.ArrayList;
import java.util.List;

import br.ufes.inf.dishfy.application.CategoriaService;
import br.ufes.inf.dishfy.domain.Categoria;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class SelectOneMenuView {
    
    private String categoria;
    private List<String> options;
    private List<Categoria> categorias;

    @Inject
    private CategoriaService categoriaService;

    @PostConstruct
    public void init() {
        options = new ArrayList<>();
        List<Categoria> categorias = categoriaService.getCategorias();
        for (Categoria categoria : categorias) {
            options.add(categoria.getNome());
        }
    }


    public List<String> getOptions() {
        return this.options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
