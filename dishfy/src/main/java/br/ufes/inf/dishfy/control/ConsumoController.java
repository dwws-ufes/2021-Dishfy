package br.ufes.inf.dishfy.control;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.ufes.inf.dishfy.application.AutenticacaoService;
import br.ufes.inf.dishfy.application.ConsumoService;
import br.ufes.inf.dishfy.application.ReceitaService;
import br.ufes.inf.dishfy.application.UsuarioService;
import br.ufes.inf.dishfy.domain.Consumo;
import br.ufes.inf.dishfy.domain.Receita;
import br.ufes.inf.dishfy.domain.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.Calendar;

@Model
public class ConsumoController implements Serializable {

  @EJB
  private ConsumoService consumoService;

  @EJB
  private ReceitaService receitaService;

  @EJB
  private AutenticacaoService autenticacaoService;

  @EJB
  private UsuarioService usuarioService;

  private Integer idReceita;
  private Date date;
  private Receita receita;
  private Consumo consumo;

  @PostConstruct
  public void init() {
    consumo = new Consumo();
    receita = new Receita();

  }

  public void saveConsumo() {
    consumo.setData(date);
    receita.setId(idReceita);
    consumo.setReceita(receitaService.getReceita(receita));

  }

  public Consumo getOneConsumo(Integer idUsuario) {
    return consumoService.getById(idUsuario);
  }

  public List<Consumo> getAllConsumoUsuario() {
    Usuario usuarioLogado;
    List<Consumo> consumos = null;
    try {
      usuarioLogado = autenticacaoService.getLoggedUser();
      consumos = consumoService.getConsumoById(usuarioLogado.getId());
      return consumos;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return consumos;
  }

  public String consomeReceita(int receitaId) {
    Receita receita = receitaService.getReceitaById(receitaId);
    Usuario usuarioLogado;
    Calendar today = Calendar.getInstance();
    today.set(Calendar.HOUR_OF_DAY, 0);

    System.out.println("++++++++++++++++++++ Consumiu " + receita.getNome());

    try {
      usuarioLogado = autenticacaoService.getLoggedUser();

      Consumo consumo = new Consumo();
      consumo.setData(today.getTime());
      consumo.setReceita(receita);
      consumo.setCalorias();
      consumo.setUsuario(usuarioLogado);

      consumo = consumoService.saveConsumo(consumo);

      List<Consumo> consumos = usuarioLogado.getConsumo();
      consumos.add(consumo);

      usuarioLogado.setConsumo(consumos);
      usuarioService.updateUsuario(usuarioLogado);

    } catch (Exception e) {
      e.printStackTrace();
    }

    return "/receita/consumoSucesso.xhtml";
  }

  public String getDateAsString(Consumo cons) {
    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
    return formatter.format(cons.getData());
  }


  public Integer getIdReceita() {
    return this.idReceita;
  }

  public void setIdReceita(Integer idReceita) {
    this.idReceita = idReceita;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Receita getReceita() {
    return this.receita;
  }

  public void setReceita(Receita receita) {
    this.receita = receita;
  }

  public Consumo getConsumo() {
    return this.consumo;
  }

  public void setConsumo(Consumo consumo) {
    this.consumo = consumo;
  }

}
