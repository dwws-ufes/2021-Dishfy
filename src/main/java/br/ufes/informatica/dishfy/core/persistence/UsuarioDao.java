package br.ufes.informatica.dishfy.core.persistence;

import br.ufes.informatica.dishfy.core.domain.Usuario;

public interface UsuarioDao {

    Usuario saveUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario);

    Usuario insertOrUpdate(Usuario usuario);

}
