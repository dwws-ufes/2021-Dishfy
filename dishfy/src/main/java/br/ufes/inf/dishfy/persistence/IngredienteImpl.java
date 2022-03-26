package br.ufes.inf.dishfy.persistence;

import java.util.List;

import br.ufes.inf.dishfy.domain.Ingrediente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


@Stateless
public class IngredienteImpl implements IngredienteDao {

    @PersistenceContext
    private EntityManager em;

    public Ingrediente saveIngrediente(Ingrediente ingrediente) {
        em.persist(ingrediente);
        return ingrediente;
    }

    public List<Ingrediente> getIngredientes() {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> criteriaQuery = criteriaBuilder.createQuery(Ingrediente.class);
        criteriaQuery.select(criteriaQuery.from(Ingrediente.class));
        List<Ingrediente> ingredientes = em.createQuery(criteriaQuery).getResultList();
        return ingredientes;

    }

    public Ingrediente getIngredientesByName(String nome){

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> criteriaQuery = criteriaBuilder.createQuery(Ingrediente.class);
        Root<Ingrediente> root = criteriaQuery.from(Ingrediente.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("nome"), nome));
        List<Ingrediente> ingredientes = em.createQuery(criteriaQuery).getResultList();
        
        if(ingredientes.isEmpty()) return null;
        else return ingredientes.get(0);
    }

    public IngredienteImpl() {
    }

    public Ingrediente getIngredientesById(int ingredienteId){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> criteriaQuery = criteriaBuilder.createQuery(Ingrediente.class);
        Root<Ingrediente> root = criteriaQuery.from(Ingrediente.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), ingredienteId));
        List<Ingrediente> ingredientes = em.createQuery(criteriaQuery).getResultList();

        if(ingredientes.isEmpty()) return null;
        else return ingredientes.get(0);
    }


}
