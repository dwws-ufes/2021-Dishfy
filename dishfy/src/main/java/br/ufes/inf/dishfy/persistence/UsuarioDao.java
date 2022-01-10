package br.ufes.inf.dishfy.persistence;

import java.util.List;

import jakarta.persistence.EntityManager;

import br.ufes.inf.dishfy.domain.Consumo;
import br.ufes.inf.dishfy.domain.Usuario;

public interface UsuarioDao {

    Usuario saveUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario);

    Usuario insertOrUpdate(Usuario usuario);

    void UsuarioImpl(EntityManager em, Consumo consumo);

    void deleteUsuario(Usuario usuario);

    Usuario getUsuario(Usuario usuario);

    List<Usuario> getAllUsuario();



}
