package br.ufes.inf.dishfy.control;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

import br.ufes.inf.dishfy.application.ReceitaService;
import br.ufes.inf.dishfy.domain.Receita;

@Named
@RequestScoped
public class FilterView implements Serializable {

    @Inject
    private ReceitaService receitaService;

    private List<Receita> receitas;

    private List<Receita> receitasFiltradas;

    @PostConstruct
    public void init() {
        receitas = receitaService.getAllReceita();
    }

    public List<Receita> getReceitas() {
        return this.receitas;
    }

    public List<Receita> getReceitasFiltradas() {
        return this.receitasFiltradas;
    }

    public void setReceitasFiltradas(List<Receita> receitasFiltradas) {
        this.receitasFiltradas = receitasFiltradas;
    }

}