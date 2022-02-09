package br.ufes.inf.dishfy.application;

import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.hibernate.WrongClassException;

import br.ufes.inf.dishfy.Utils;
import br.ufes.inf.dishfy.domain.Usuario;
import br.ufes.inf.dishfy.exceptions.MultipleUserObjectException;
import br.ufes.inf.dishfy.exceptions.UserAlreadyExistsException;
import br.ufes.inf.dishfy.exceptions.UserNotFoundException;
import br.ufes.inf.dishfy.exceptions.WrongPasswordException;
import br.ufes.inf.dishfy.persistence.UsuarioDao;

@Stateless
public class AutenticacaoServiceImpl implements AutenticacaoService{

    @EJB
    private UsuarioDao usuarioDao;

    @Inject
    private Pbkdf2PasswordHash passwordHash;

    @Inject
	private Event<AutenticacaoEvent> autenticacaoEvent;
	
	@Resource
	private SessionContext sessionContext;

    public void signUp(Usuario usuario) throws UserAlreadyExistsException, MultipleUserObjectException {
        Usuario consultado = usuarioDao.getUsuarioByEmail(usuario.getEmail());
        if(consultado != null){
            throw new UserAlreadyExistsException(usuario.getEmail());
        }

        usuario.setSenha(passwordHash.generate(usuario.getSenha().toCharArray()));
        System.out.println(usuario.getSenha());
        usuarioDao.saveUsuario(usuario);        
    }

    public void login(String email, String senha) throws UserNotFoundException, WrongPasswordException {
        
        try {
            Usuario usuario = usuarioDao.getUsuarioByEmail(email);
            String senhaUsuario;

            // Verifica se o usuario com esse email existe
            if(usuario != null){
                senhaUsuario = usuario.getSenha();
            } else {
                throw new UserNotFoundException(email);
            }
            
            // Verifica se a senha esta correta
            if(passwordHash.verify(senha.toCharArray(), senhaUsuario)){
                Usuario usuarioAtual = usuario;
                senhaUsuario = null;
                autenticacaoEvent.fire(new AutenticacaoEvent(usuarioAtual));
            } else {
                throw new WrongPasswordException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Usuario getLoggedUser() throws MultipleUserObjectException {
        try{
            System.out.println("SESSION CONTEXT: " + sessionContext.getCallerPrincipal().getName());
            return usuarioDao.getUsuarioByEmail(sessionContext.getCallerPrincipal().getName());
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void logout(){}
    
}
