package br.ufes.inf.dishfy.persistence;

import java.util.List;
import br.ufes.inf.dishfy.domain.Usuario;
import br.ufes.inf.dishfy.exceptions.MultipleObjectException;
import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;

@Local
public interface UsuarioDao {

    public Usuario saveUsuario(Usuario usuario);
    
    public Usuario updateUsuario(Usuario usuario);

    public Usuario insertOrUpdate(Usuario usuario);

    public void deleteUsuario(Usuario usuario);

    public Usuario getUsuario(Usuario usuario);

    public Usuario getUsuarioByEmail(String email) throws MultipleObjectException;

    public List<Usuario> getAllUsuario();

    public void setEntityManager(EntityManager em);

}
