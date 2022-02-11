package br.ufes.inf.dishfy.control;

import java.io.Serializable;
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
        
    }

}
