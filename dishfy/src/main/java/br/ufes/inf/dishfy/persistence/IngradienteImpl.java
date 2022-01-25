package br.ufes.inf.dishfy.persistence;

import java.util.List;

import br.ufes.inf.dishfy.domain.Ingrediente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;


@Stateless
public class IngradienteImpl implements IngredienteDao {

    @PersistenceContext
    private EntityManager em;

    public void saveIngrediente(Ingrediente ingrediente) {
        em.persist(ingrediente);

    }

    public List<Ingrediente> getIngredientes() {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> criteriaQuery = criteriaBuilder.createQuery(Ingrediente.class);
        criteriaQuery.select(criteriaQuery.from(Ingrediente.class));
        List<Ingrediente> ingredientes = em.createQuery(criteriaQuery).getResultList();
        return ingredientes;

    }

    public IngradienteImpl() {
    }


}
