package br.ufes.inf.dishfy.control;

import java.io.Serializable;

import br.ufes.inf.dishfy.application.AutenticacaoService;
import br.ufes.inf.dishfy.application.UserAlreadyExistsException;
import br.ufes.inf.dishfy.application.UserNotFoundException;
import br.ufes.inf.dishfy.domain.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Model;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Model
@SessionScoped
public class AutenticarUsuarioController implements Serializable {
    @EJB
    private AutenticacaoService autenticacaoService;
    // private Usuario usuario = new Usuario(nome, login, senha, fotoPerfil, tamanhoMax);
    private String nome;
    private String email;
    private String senha;
    private String erroLogin = "E-mail ou senha incorretos. Tente novamente.";
    private String erroCadastro = "E-mail já cadastrado: ";
    private Usuario usuarioAtual;

    Usuario usuario;

    @PostConstruct
	public void init() {
		usuario = new Usuario();		
	}
    
    public String cadastrar(){
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        try {
            autenticacaoService.signUp(usuario);
        } catch (UserAlreadyExistsException e) {
            erroCadastro = e.getMessage();
            // TODO: trocar a pagina
            return "/index.xhtml";
        } finally {
            // usuario = new Usuario();
            nome = null;
            email = null;
            senha = null;
        }        
        return "/login/login.xhtml";
    }    

    public String solicitaLogin(){
        try {
            autenticacaoService.login(email, senha);
            HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
            request.logout();
            request.login(email, senha);
        } catch (UserNotFoundException e) {
            erroLogin = e.getMessage();
            return "/index.xhtml";
        } catch (ServletException e) {
            
        } finally {
            email = null;
            senha = null;
        }
        usuarioAtual = autenticacaoService.getLoggedUser();
        System.out.println("Usuario Logado: " + usuarioAtual.getNome());
        return "/core/home.xhtml";
    }

    // public String solicitaLogout(){}

    public boolean usuarioLogado() {
        return usuarioAtual != null;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getErroLogin() {
        return this.erroLogin;
    }

    public String getErroCadastro() {
        return this.erroCadastro;
    }

}
