package br.ufes.inf.dishfy.application;

import br.ufes.inf.dishfy.domain.Usuario;
import br.ufes.inf.dishfy.persistence.UsuarioDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

    @EJB
    private UsuarioDao usuarioDao;

    public Usuario updateUsuario(Usuario usuario){
        return usuarioDao.updateUsuario(usuario);
    }
}
