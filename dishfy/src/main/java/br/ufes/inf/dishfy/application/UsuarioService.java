package br.ufes.inf.dishfy.application;

import java.io.Serializable;

import br.ufes.inf.dishfy.domain.Usuario;
import jakarta.ejb.Local;

@Local
public interface UsuarioService extends Serializable {

    public Usuario updateUsuario(Usuario usuario);    
}
