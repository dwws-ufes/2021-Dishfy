package br.ufes.inf.dishfy.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufes.inf.dishfy.application.AutenticacaoService;
import br.ufes.inf.dishfy.application.ReceitaService;
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

    Usuario usuarioLogado;

    String receita;

    List<Receita> usuarioReceitas;

    @PostConstruct
	public void init() {
        try {
            usuarioLogado = autenticacaoService.getLoggedUser();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        usuarioReceitas = usuarioLogado.getReceitas();
	}

    public void adicionarReceita(int receitaId){
        Receita receita = receitaService.getReceitaById(receitaId);
        List<Receita> listaReceita = usuarioLogado.getReceitas();
        listaReceita.add(receita);
        usuarioLogado.setReceitas(listaReceita);
    }

    public void consumirReceita(int receitaId){
        
    }

    public List<Receita> getUsuarioReceitas() {
        return this.usuarioReceitas;
    }

    public void setUsuarioReceitas(List<Receita> usuarioReceitas) {
        this.usuarioReceitas = usuarioReceitas;
    }

}
