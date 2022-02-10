package br.ufes.inf.dishfy.control;

import java.io.Serializable;
import java.util.List;

import javax.swing.ImageIcon;

import br.ufes.inf.dishfy.application.CategoriaService;
import br.ufes.inf.dishfy.application.IngredienteService;
import br.ufes.inf.dishfy.application.ReceitaService;
import br.ufes.inf.dishfy.domain.Categoria;
import br.ufes.inf.dishfy.domain.Item;
import br.ufes.inf.dishfy.domain.Receita;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.inject.Model;
@Model
public class ReceitaController implements Serializable {
  
  @EJB
  private ReceitaService receitaService;

  @EJB
  private CategoriaService categoriaService;

  @EJB
  private IngredienteService ingredienteService;

  private String nome;
  private String desc;
  private String categoria;
  private String publico;
  private ImageIcon img;

  private String qtd;
  private String grand;
  private String ingrediente;

  private Receita receita;
  private List<Receita> matchReceitas;
  private List<Item> items;

  @PostConstruct
  public void init() {
    receita = new Receita();
    matchReceitas = receitaService.getAllReceita();      		
  }

  public Receita criaReceita(){

    Categoria categoriaConsultada = categoriaService.getCategoriaByName(categoria);

    receita.setNome(nome);
    receita.setDescricao(desc);
    receita.setCategoria(categoriaConsultada);    
    receita.setPublico(publico.equals("privado") ? false : true);
    // TODO: tratar imagem
    receita.setImagem(img);
    receita.setItens(items);

    Receita receitaCriada = receitaService.createReceita(receita);

    receita = new Receita();
    nome = null;
    desc = null;
    categoria = null;
    publico = null;
    img = null;
    
    return receitaCriada;
  }

  public void salvarItem(){
    Item item = new Item();
    item.setGrandeza(grand);
    item.setQuantidade(Double.parseDouble(qtd));
    item.setIngrediente(ingredienteService.getIngrediente(ingrediente));
    items.add(item);

    qtd = null;
    grand = null;
    ingrediente = null;
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
