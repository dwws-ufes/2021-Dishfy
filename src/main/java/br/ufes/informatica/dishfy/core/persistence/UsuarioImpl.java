package br.ufes.informatica.dishfy.core.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        criteriaQuery.select(criteriaQuery.from(Usuario.class));
        return em.createQuery(criteriaQuery).getResultList();

    }

}
