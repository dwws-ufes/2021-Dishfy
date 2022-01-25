package br.ufes.inf.dishfy.control;

import java.io.Serializable;
import java.util.List;

import javax.swing.ImageIcon;

import br.ufes.inf.dishfy.application.ReceitaService;
import br.ufes.inf.dishfy.domain.Receita;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.inject.Model;
@Model
public class ReceitaController implements Serializable {
  @EJB
  private ReceitaService receitaService;
  private String nome;
  private String desc;
  private ImageIcon img;
  private Receita receita;
  private List<Receita> matchReceitas;
  

  @PostConstruct
  public void init() {
      receita = new Receita();
      		
  }
  public Receita criaReceita(){
      
      receita.setNome(nome);
      receita.setDescricao(desc);
      receita.setImagem(img);

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
