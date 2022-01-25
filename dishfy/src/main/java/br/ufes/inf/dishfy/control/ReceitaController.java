package br.ufes.inf.dishfy.control;

import java.io.Serializable;
import java.util.List;

import br.ufes.inf.dishfy.application.ReceitaService;
import br.ufes.inf.dishfy.domain.Receita;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.inject.Model;
@Model
public class ReceitaController implements Serializable {
  @EJB
  private ReceitaService receitaService;
  private String Nome;
  private Receita receita;
  private List<Receita> receitas;
  

  @PostConstruct
  public void init() {
      receita = new Receita();
      		
  }
  public Receita criaReceita(Receita receita){
     return receitaService.createReceita(receita);
  }

  public Receita AtualizarReceita(Receita receita){
      return receitaService.updateReceita(receita);
  }

  public List<Receita> consultaReceita(){

    return receitaService.getAllReceita();
  }

  public void deletaReceita(Receita receita){

    receitaService.deleteReceita(receita);
  }
}
