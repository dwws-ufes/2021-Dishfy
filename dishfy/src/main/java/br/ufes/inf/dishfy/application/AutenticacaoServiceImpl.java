package br.ufes.inf.dishfy.application;

import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.ufes.inf.dishfy.Utils;
import br.ufes.inf.dishfy.domain.Usuario;
import br.ufes.inf.dishfy.persistence.UsuarioDao;

@Stateless
public class AutenticacaoServiceImpl implements AutenticacaoService{

    @EJB
    private UsuarioDao usuarioDao;

    @Inject
	private Event<AutenticacaoEvent> autenticacaoEvent;
	
	@Resource
	private SessionContext sessionContext;

    public void signUp(Usuario usuario) throws UserAlreadyExistsException {
        Usuario consultado = usuarioDao.getUsuarioByEmail(usuario.getEmail());
        if(consultado != null){
            throw new UserAlreadyExistsException(usuario.getEmail());
        }

        try {
            usuario.setSenha(Utils.produceBase64EncodedMd5Hash(usuario.getSenha()));
            usuarioDao.saveUsuario(usuario);
        }  catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
    }

    public void login(String email, String senha) throws UserNotFoundException {
        
        try {
            Usuario usuario = usuarioDao.getUsuarioByEmail(email);
            String senhaUsuario;
            if(usuario != null){
                senhaUsuario = usuario.getSenha();
            } else {
                throw new UserNotFoundException(email);

            }
            String senhaMD5 = Utils.produceBase64EncodedMd5Hash(senha);

            if(senhaUsuario.equals(senhaMD5)){
                Usuario usuarioAtual = usuario;
                senhaUsuario = null;
                autenticacaoEvent.fire(new AutenticacaoEvent(usuarioAtual));
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public Usuario getLoggedUser(){
        try{
            return usuarioDao.getUsuarioByEmail(sessionContext.getCallerPrincipal().getName());
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void logout(){}
    
}
