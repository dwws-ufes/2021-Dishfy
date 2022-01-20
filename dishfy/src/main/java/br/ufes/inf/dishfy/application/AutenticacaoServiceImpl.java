package br.ufes.inf.dishfy.application;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import br.ufes.inf.dishfy.domain.Usuario;
import br.ufes.inf.dishfy.persistence.UsuarioDao;

@Stateless
public class AutenticacaoServiceImpl implements AutenticacaoService{

    @EJB
    private UsuarioDao usuarioDao;

    public void signUp(Usuario usuario) throws UserAlreadyExistsException {
        if(usuarioDao.getUsuarioByEmail(usuario.getEmail()) == null){
            throw new UserAlreadyExistsException(usuario.getEmail());
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Dishfy");
        usuarioDao.setEntityManager(emf.createEntityManager());
        usuarioDao.saveUsuario(usuario);
        emf.close();
    }

    public void login() throws UserNotFound{}

    public void logout(){}
    
}
