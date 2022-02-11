package br.ufes.inf.dishfy.control;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.ufes.inf.dishfy.application.CategoriaService;
import br.ufes.inf.dishfy.application.IngredienteService;
import br.ufes.inf.dishfy.application.ReceitaService;
import br.ufes.inf.dishfy.domain.Categoria;
import br.ufes.inf.dishfy.domain.Ingrediente;
import br.ufes.inf.dishfy.domain.Item;
import br.ufes.inf.dishfy.domain.Receita;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.inject.Model;
import jakarta.servlet.http.Part;

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
  private double calorias;
  
  private Part uploadedFile;
  private String imageName;
  private byte[] imageContents;

  private String qtd;
  private String grand;
  private String ingrediente;

  private Receita receita;
  private List<Receita> matchReceitas;
  private List<Item> items;
  private String consulta;

  @PostConstruct
  public void init() {
    receita = new Receita();
    matchReceitas = receitaService.getAllReceita();
    items = new ArrayList<>();
  }

  public Receita criaReceita(){

    Categoria categoriaConsultada = categoriaService.getCategoriaByName(categoria);

    receita.setNome(nome);
    receita.setDescricao(desc);
    receita.setCategoria(categoriaConsultada);    
    receita.setPublico(publico.equals("privado") ? false : true);
    receita.setImagem(imageContents);
    receita.setItens(items);

    Receita receitaCriada = receitaService.createReceita(receita);

    receita = new Receita();
    nome = null;
    desc = null;
    categoria = null;
    publico = null;
    imageContents = null;

    return receitaCriada;
  }

  public void salvarItem(){
    Item item = new Item();

    if(grand != null && qtd != null && ingrediente != null){
      item.setGrandeza(grand);
      item.setQuantidade(Double.parseDouble(qtd));
      item.setIngrediente(ingredienteService.getIngrediente(ingrediente));
      items.add(item);
    }

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

  public void uploadImage() {
    imageName = Paths.get(uploadedFile.getSubmittedFileName()).getFileName().toString();

    try (InputStream input = uploadedFile.getInputStream()) {
        imageContents = input.readAllBytes();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
  }

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

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDesc() {
    return this.desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getCategoria() {
    return this.categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getPublico() {
    return this.publico;
  }

  public void setPublico(String publico) {
    this.publico = publico;
  }

  public Part getUploadedFile() {
    return this.uploadedFile;
  }

  public void setUploadedFile(Part uploadedFile) {
    this.uploadedFile = uploadedFile;
  }

  public String getQtd() {
    return this.qtd;
  }

  public void setQtd(String qtd) {
    this.qtd = qtd;
  }

  public String getGrand() {
    return this.grand;
  }

  public void setGrand(String grand) {
    this.grand = grand;
  }

  public String getIngrediente() {
    return this.ingrediente;
  }

  public void setIngrediente(String ingrediente) {
    this.ingrediente = ingrediente;
  }

  public List<Item> getItems() {
    return this.items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public String getConsulta() {
    return this.consulta;
  }

  public void setConsulta(String consulta) {
    this.consulta = consulta;
  }

  public double getCalorias() {
    return this.calorias;
  }

  public void setConsulta(double calorias) {
    this.calorias = calorias;
  }

}
