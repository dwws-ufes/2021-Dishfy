package br.ufes.informatica.dishfy.core.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.eclipse.jgit.util.LongList;

import br.ufes.informatica.dishfy.core.domain.Consumo;
import br.ufes.informatica.dishfy.core.domain.Usuario;

public class UsuarioImpl {
    private final EntityManager em;

    public UsuarioImpl(EntityManager em, Consumo consumo) {
        this.em = em;
    }

    public Usuario saveUsuario(Usuario usuario) {
        em.persist(usuario);
        return usuario;

    }

    public Usuario updateUsuario(Usuario usuario) {
        em.merge(usuario);
        em.persist(usuario);
        return usuario;

    }

    public Usuario insertOrUpdate(Usuario usuario) {
        if (usuario.getId() > 0) {
            return this.updateUsuario(usuario);
        }
        return this.saveUsuario(usuario);

    }

    public void deleteUsuario(Usuario usuario) {
        em.merge(usuario);
        em.remove(usuario);

    }

    public void saveConsumo(Consumo consumo) {
        em.persist(consumo);
    }

    public Usuario getUsuario(Usuario usuario) {
        return em.find(Usuario.class, usuario);

    }

    public List<Usuario> getAllUsuario() {
        // consulta jpql
        String jpql = "select u from Usuario as u";
        Query createQuery = em.createQuery(jpql);
        List<Usuario> usuarios = createQuery.getResultList();
        return usuarios;
    }

}
