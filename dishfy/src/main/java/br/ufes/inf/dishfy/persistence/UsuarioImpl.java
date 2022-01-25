package br.ufes.inf.dishfy.persistence;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import br.ufes.inf.dishfy.domain.Consumo;
import br.ufes.inf.dishfy.domain.Usuario;

@Stateless
public class UsuarioImpl implements UsuarioDao {
    @PersistenceContext
    private EntityManager em;
    // private final EntityManager em;

    private Consumo consumo;

    public UsuarioImpl(){}
    
    public UsuarioImpl(EntityManager em, Consumo consumo) {
        this();
        this.em = em;
        this.consumo = consumo;
    }

    public Usuario saveUsuario(Usuario usuario) {
        // em.getTransaction().begin();
        em.persist(usuario);
        // em.getTransaction().commit();
        // em.close();
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

    public Usuario getUsuarioByEmail(String email) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> root = criteriaQuery.from(Usuario.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("email"), email));
        List<Usuario> usuarios = em.createQuery(criteriaQuery).getResultList();
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public List<Usuario> getAllUsuario() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        criteriaQuery.select(criteriaQuery.from(Usuario.class));
        List<Usuario> usuarios = em.createQuery(criteriaQuery).getResultList();
        return usuarios;

    }

    public void setEntityManager(EntityManager em){
        this.em = em;
    }

}