package br.ufes.inf.dishfy.persistence;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import br.ufes.inf.dishfy.domain.Consumo;
import br.ufes.inf.dishfy.domain.Usuario;

public class UsuarioImpl implements UsuarioDao {
    private final EntityManager em;
    private Consumo consumo;

    public UsuarioImpl(EntityManager em, Consumo consumo) {
        this.em = em;
        this.consumo = consumo;
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
        List<Usuario> usuarios = em.createQuery(criteriaQuery).getResultList();
        return usuarios;

    }

}