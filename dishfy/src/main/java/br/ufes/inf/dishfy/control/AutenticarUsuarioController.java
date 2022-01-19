package br.ufes.inf.dishfy.control;

import java.io.Serializable;

import br.ufes.inf.dishfy.application.AutenticarService;
import br.ufes.inf.dishfy.domain.Usuario;

import jakarta.ejb.EJB;
import jakarta.enterprise.inject.Model;

@Model
public class AutenticarUsuarioController implements Serializable {
    @EJB
    private AutenticarService autenticarService;
    // private Usuario usuario = new Usuario(nome, login, senha, fotoPerfil, tamanhoMax);
    private String nome;
    private String email;
    private String senha;
    private String erroLogin = "E-mail ou senha incorretos. Tente novamente.";
    private String erroCadastro = "E-mail já cadastrado.";

    public void cadastrar(){
        Usuario usuario = new Usuario(nome, email, senha);        
    }
    
    

    // public String solicitaLogin(){}

    // public String solicitaLogout(){}

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
