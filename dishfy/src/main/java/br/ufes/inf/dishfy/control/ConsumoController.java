package br.ufes.inf.dishfy.control;

import java.io.Serializable;
import java.util.Date;

import br.ufes.inf.dishfy.application.ConsumoService;
import br.ufes.inf.dishfy.application.ReceitaService;
import br.ufes.inf.dishfy.domain.Consumo;
import br.ufes.inf.dishfy.domain.Receita;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.inject.Model;
@Model
public class ConsumoController implements Serializable {
  @EJB
  private ConsumoService consumoService;
  
  @EJB
  private ReceitaService receitaService;

  private Integer idReceita;
  private Date date;
  private Receita receita;
  private Consumo consumo;
  
  @PostConstruct
  public void init() {
      consumo = new Consumo();
      receita = new Receita();
      		
  }
  public void saveConsumo(){
    consumo.setData(date);
    receita.setId(idReceita);
    consumo.setReceita(receitaService.getReceita(receita));
    


  }
}
