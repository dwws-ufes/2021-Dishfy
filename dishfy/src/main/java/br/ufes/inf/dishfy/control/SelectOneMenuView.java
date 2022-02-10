package br.ufes.inf.dishfy.control;

import java.util.List;

import br.ufes.inf.dishfy.application.CategoriaService;
import br.ufes.inf.dishfy.domain.Categoria;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class SelectOneMenuView {
    
    private String categoria;
    private List<String> options;
    private List<Categoria> categorias;

    @EJB
    private CategoriaService categoriaService;

    @PostConstruct
    public void init() {
        List<Categoria> categorias = categoriaService.getCategorias();
        for (Categoria categoria : categorias) {
            options.add(categoria.getNome());
        }
    }
}
