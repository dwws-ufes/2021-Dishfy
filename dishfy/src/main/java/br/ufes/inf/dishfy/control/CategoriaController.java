package br.ufes.inf.dishfy.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufes.inf.dishfy.application.CategoriaService;
import br.ufes.inf.dishfy.application.ReceitaService;
import br.ufes.inf.dishfy.domain.Categoria;
import br.ufes.inf.dishfy.domain.Receita;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Model;

@Model
@SessionScoped
public class CategoriaController implements Serializable {

    @EJB
    private CategoriaService categoriaService;

    @EJB
    private ReceitaService receitaService;

    private Categoria categoria;
    private List<Categoria> categorias;
    private List<Receita> receitasCategoria;

    @PostConstruct
    public void init() {
        categorias = categoriaService.getCategorias();
        receitasCategoria = new ArrayList<>();
    }

    public String selectCategory(String nomeCategoria){
        for (Categoria categoriaBusca : categorias) {
            if(categoriaBusca.getNome().equals(nomeCategoria)){
                categoria = categoriaBusca;
                break;
            }
        }

        receitasCategoria = receitaService.getCategoriaReceitas(categoria.getId());

        return "/receita/categoria.xhtml";
    }


    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Receita> getReceitasCategoria() {
        return this.receitasCategoria;
    }

    public void setReceitasCategoria(List<Receita> receitasCategoria) {
        this.receitasCategoria = receitasCategoria;
    }

}