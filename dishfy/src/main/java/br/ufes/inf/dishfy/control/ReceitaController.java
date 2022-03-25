package br.ufes.inf.dishfy.control;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import br.ufes.inf.dishfy.Utils;
import br.ufes.inf.dishfy.application.AutenticacaoService;
import br.ufes.inf.dishfy.application.CategoriaService;
import br.ufes.inf.dishfy.application.ImagemPersitService;
import br.ufes.inf.dishfy.application.ImagemService;
import br.ufes.inf.dishfy.application.IngredienteService;
import br.ufes.inf.dishfy.application.ItemService;
import br.ufes.inf.dishfy.application.ReceitaService;
import br.ufes.inf.dishfy.application.UsuarioService;
import br.ufes.inf.dishfy.domain.Categoria;
import br.ufes.inf.dishfy.domain.ImageDishfy;
import br.ufes.inf.dishfy.domain.Ingrediente;
import br.ufes.inf.dishfy.domain.Item;
import br.ufes.inf.dishfy.domain.Receita;
import br.ufes.inf.dishfy.domain.Usuario;
import br.ufes.inf.dishfy.exceptions.MultipleObjectException;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.SessionContext;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Model;
import jakarta.servlet.http.Part;

@Model
@SessionScoped
public class ReceitaController implements Serializable {

  @EJB
  private ReceitaService receitaService;

  @EJB
  private CategoriaService categoriaService;

  @EJB
  private IngredienteService ingredienteService;

  @EJB
  private AutenticacaoService autenticacaoService;

  @EJB
  private ImagemPersitService imagemPersitService;

  @EJB
  private ImagemService imagemService;

  @EJB
  private UsuarioService usuarioService;

  @EJB
  private ItemService itemService;

  private String nome;
  private String desc;
  private String categoria;
  private String publico;
  private double calorias;

  private Part uploadedFile;
  private String imageName;
  private ImageDishfy imagem;

  private String qtd;
  private String grand;
  private String ingrediente;
  private Receita receita;
  private List<Receita> matchReceitas;
  private List<Item> items;
  private String consulta;
  private Receita receitaSelecionada;
  private int receitaId;
  private Receita receitaCriada;
  private List<Receita> receitasPublicas;
  private Usuario usuarioLogado;

  @PostConstruct
  public void init() {
    receita = new Receita();
    try {
      usuarioLogado = autenticacaoService.getLoggedUser();
    } catch (Exception e) {
      e.printStackTrace();
    }
    publico = "publico";
    // items = new ArrayList<>();
    matchReceitas = receitaService.getAllReceita();
    receitasPublicas = receitaService.getPublicReceitas();
  }

  public String criaReceita() {
    Categoria categoriaConsultada = categoriaService.getCategoriaByName(categoria);

    System.out
        .println("------- criando receita: " + nome + " " + desc + " " + categoriaConsultada.getNome() + " " + publico);

    receita.setNome(nome);
    receita.setDescricao(desc);
    receita.setCategoria(categoriaConsultada);
    receita.setPublico(publico.equals("privado") ? false : true);

    receita.setAutor(usuarioLogado);

    // long start = System.currentTimeMillis();
    // long end = start + 5*1000;
    // while (System.currentTimeMillis() < end) {}

    // receita.setImagem(imagem);

    receita.setItens(new ArrayList<>());

    receita = receitaService.createReceita(receita);

    List<Receita> receitas = usuarioLogado.getReceitas();
    receitas.add(receita);
    usuarioLogado.setReceitas(receitas);

    System.out.println("------------- USUARIO LOGADO " + usuarioLogado.getId());
    usuarioLogado = usuarioService.updateUsuario(usuarioLogado);

    System.out.println("---- Receitas do usuario");
    for (Receita receita : usuarioLogado.getReceitas()) {
      System.out.println("---- " + receita.getNome());
    }

    this.receitaCriada = receita;

    receita = new Receita();
    nome = null;
    desc = null;
    categoria = null;
    publico = null;
    items = null;

    receitasPublicas = receitaService.getPublicReceitas();

    return "/receita/adicionaItem.xhtml";
  }

  public String adicionarItens() {
    return "/receita/sucesso.xhtml";
  }

  public void salvarItem() {
    Item item = new Item();

    double somaCaloria = 0;

    if (grand != null && qtd != null && ingrediente != null && receitaCriada != null) {
      System.out.println("-------- item adicionado " + qtd + " " + grand + " "
          + ingredienteService.getIngrediente(ingrediente).getNome());
      item.setGrandeza(grand);
      item.setQuantidade(Double.parseDouble(qtd));
      item.setIngrediente(ingredienteService.getIngrediente(ingrediente));
      item.setReceita(receitaCriada);
      somaCaloria = somaCaloria
          + (Double.parseDouble(qtd) * ingredienteService.getIngrediente(ingrediente).getCalorias());
    }

    itemService.salvarItem(item);
    this.items = receitaCriada.getItens();
    this.items.add(item);
    receitaCriada.setItens(items);
    receitaCriada.setCalorias(somaCaloria);
    receitaService.updateReceita(receitaCriada);

    qtd = null;
    grand = null;
    ingrediente = null;

  }

  public Receita AtualizarReceita(Receita receita) {
    return receitaService.updateReceita(receita);
  }

  public List<Receita> consultaReceita() {
    return receitaService.getAllReceita();
  }

  public void deletaReceita(Receita receita) {
    receitaService.deleteReceita(receita);
  }

  public void upload() {
    imageName = Paths.get(uploadedFile.getSubmittedFileName()).getFileName().toString();
    // imagemService.setImageName(imageName);
    // imagemService.setUploadedFile(uploadedFile);
    imagem = imagemService.uploadImage(imageName, uploadedFile);
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

  public String acessaReceita(int receitaId) {
    System.out.println("-------------------RECITA ID: " + receitaId);
    this.receitaSelecionada = receitaService.getReceitaById(receitaId);
    receitaSelecionada.setItens(itemService.getItems(receitaId));
    System.out.println("---------- Receita Selecionada: " + receitaSelecionada.getNome());
    for (Item item : receitaSelecionada.getItens()) {
      System.out.println("------ item " + item.getIngrediente().getNome());
    }
    return "/receita/receita.xhtml";
  }

  public void acessaReceitasPublicas() {
    this.receitasPublicas = receitaService.getPublicReceitas();
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

  public Receita getReceitaSelecionada() {
    return this.receitaSelecionada;
  }

  public void setReceitaSelecionada(Receita receitaSelecionada) {
    this.receitaSelecionada = receitaSelecionada;
  }

  public int getReceitaId() {
    return this.receitaId;
  }

  public void setReceitaId(int receitaId) {
    this.receitaId = receitaId;
  }

  public List<Receita> getReceitasPublicas() {
    return this.receitasPublicas;
  }

  public void setReceitasPublicas(List<Receita> receitasPublicas) {
    this.receitasPublicas = receitasPublicas;
  }

  public Receita getReceitaCriada() {
    return this.receitaCriada;
  }

  public void setReceitaCriada(Receita receitaCriada) {
    this.receitaCriada = receitaCriada;
  }

  public Usuario getUsuarioLogado() {
    return this.usuarioLogado;
  }

  public void setUsuarioLogado(Usuario usuarioLogado) {
    this.usuarioLogado = usuarioLogado;
  }

  public String clienteSPARQL() {
    return "http://localhost:2021/snorql/";
  }
}
