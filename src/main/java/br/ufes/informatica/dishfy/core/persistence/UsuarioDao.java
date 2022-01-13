package br.ufes.informatica.dishfy.core.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufes.informatica.dishfy.core.domain.Consumo;
import br.ufes.informatica.dishfy.core.domain.Usuario;

public interface UsuarioDao {

    Usuario saveUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario);

    Usuario insertOrUpdate(Usuario usuario);

    

    void deleteUsuario(Usuario usuario);

    Usuario getUsuario(Usuario usuario);

    List<Usuario> getAllUsuario();



}
