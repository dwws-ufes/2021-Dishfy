package br.ufes.inf.dishfy.control;

import java.io.Serializable;
import java.util.ArrayList;

import br.ufes.inf.dishfy.application.AutenticacaoService;
import br.ufes.inf.dishfy.domain.Usuario;
import br.ufes.inf.dishfy.exceptions.MultipleObjectException;
import br.ufes.inf.dishfy.exceptions.UserAlreadyExistsException;
import br.ufes.inf.dishfy.exceptions.UserNotFoundException;
import br.ufes.inf.dishfy.exceptions.WrongPasswordException;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Model;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.Password;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Model
@SessionScoped
public class AutenticarUsuarioController implements Serializable {
    @EJB
    private AutenticacaoService autenticacaoService;
    // private Usuario usuario = new Usuario(nome, login, senha, fotoPerfil, tamanhoMax);
    private String nome;
    private String email;
    private String senha;
    private String erroLogin;
    private String erroCadastro;
    private Usuario usuarioAtual;

    @Inject
    private FacesContext facesContext;

    @Inject
    private SecurityContext securityContext;

    Usuario usuario;

    @PostConstruct
	public void init() {
		usuario = new Usuario();
        try {
            usuarioAtual = autenticacaoService.getLoggedUser();            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
    
    public String cadastrar(){
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setReceitas(new ArrayList<>());
        usuario.setConsumo(new ArrayList<>());

        try {
            usuario = autenticacaoService.signUp(usuario);
        } catch (UserAlreadyExistsException e) {
            erroCadastro = e.getMessage();
            // TODO: trocar a pagina
            return "/index.xhtml";
        } catch (MultipleObjectException e) {
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

    public String solicitaLogin() throws Exception{
        try {
            autenticacaoService.login(email, senha);

            HttpServletRequest request = (HttpServletRequest) facesContext
                .getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) facesContext
                .getExternalContext().getResponse();
            
            Credential credential = new UsernamePasswordCredential(email, new Password(senha));
            AuthenticationStatus status = securityContext.authenticate(request, response,
                AuthenticationParameters.withParams().credential(credential));

            if(status == null || AuthenticationStatus.SEND_FAILURE.equals(status)) {
                throw new Exception("Container Rejected");
            }
            if(AuthenticationStatus.SEND_CONTINUE.equals(status)){
                facesContext.responseComplete();
            }
        } catch (UserNotFoundException e) {
            erroLogin = e.getMessage();
            return "/index.xhtml";
        } catch (WrongPasswordException e) {
            erroLogin = e.getMessage();
            return "/index.xhtml";
        } catch (ServletException e) {}
        finally {
            email = null;
            senha = null;
        }
        usuarioAtual = autenticacaoService.getLoggedUser();
        System.out.println("Usuario Logado: " + usuarioAtual.getNome());
        return "/core/home.xhtml";
    }

    public String solicitaLogout(){
        System.out.println("BORAPOHA");
        usuarioAtual = null;
        return "/index.xhtml";
    }

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

    public Usuario getUsuarioAtual() {
        return this.usuarioAtual;
    }

    public void setUsuarioAtual(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }


}
