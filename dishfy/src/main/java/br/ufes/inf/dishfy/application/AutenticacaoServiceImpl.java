package br.ufes.inf.dishfy.application;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import br.ufes.inf.dishfy.domain.Usuario;
import br.ufes.inf.dishfy.persistence.UsuarioDao;

@Stateless
public class AutenticacaoServiceImpl implements AutenticacaoService{

    @EJB
    private UsuarioDao usuarioDao;

    public void signUp(Usuario usuario) throws UserAlreadyExistsException {
        Usuario consultado = usuarioDao.getUsuarioByEmail(usuario.getEmail());
        if(consultado != null){
            throw new UserAlreadyExistsException(usuario.getEmail());
        }
        
        usuarioDao.saveUsuario(usuario);
        
    }

    public void login() throws UserNotFound{}

    public void logout(){}
    
}
