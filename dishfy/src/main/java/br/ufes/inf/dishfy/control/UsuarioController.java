package br.ufes.inf.dishfy.control;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import br.ufes.inf.dishfy.application.AutenticacaoService;
import br.ufes.inf.dishfy.application.ConsumoService;
import br.ufes.inf.dishfy.application.ReceitaService;
import br.ufes.inf.dishfy.domain.Consumo;
import br.ufes.inf.dishfy.domain.Receita;
import br.ufes.inf.dishfy.domain.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Model;

@Model
@SessionScoped
public class UsuarioController implements Serializable {
    
    @EJB
    private AutenticacaoService autenticacaoService;

    @EJB
    private ReceitaService receitaService;

    @EJB
    private ConsumoService consumoService;

    Usuario usuario;

    String receita;

    @PostConstruct
	public void init() {
        try {
            usuario = autenticacaoService.getLoggedUser();            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    public void adicionarReceita(int receitaId){
        Receita receita = receitaService.getReceitaById(receitaId);
        List<Receita> listaReceita = usuario.getReceitas();
        listaReceita.add(receita);
        usuario.setReceitas(listaReceita);
    }

    public void consumirReceita(int receitaId){

        Receita receitaF = receitaService.getReceitaById(receitaId);
        Consumo consumo = new Consumo();
        consumo.setReceita(receitaF);
        consumo.setData(new Timestamp(new Date().getTime()));
        consumo.setCalorias();
        consumoService.saveConsumo(consumo);
        usuario.setCaloriasTotal(receitaF.getCalorias());
        usuario.getReceitas().add(receitaF);
        usuario.getConsumo().add(consumo);
    }

}
