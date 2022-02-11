package br.ufes.inf.dishfy.persistence;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import br.ufes.inf.dishfy.domain.Receita;
import br.ufes.inf.dishfy.exceptions.MultipleObjectException;

@Stateless
public class ReceitaImpl implements ReceitaDao {
    @PersistenceContext
    private EntityManager em;

    public ReceitaImpl() {
        
    }
     
    


    public ReceitaImpl(EntityManager em) {
        this.em = em;
    }




    public Receita saveReceita(Receita receita){
        em.persist(receita);
        return receita;

    }

    public Receita updateReceita(Receita receita) {
        em.merge(receita);
        em.persist(receita);
        return receita;

    }
    public Receita insertOrUpdate(Receita receita) {
        if (receita.getId() > 0) {
            return this.updateReceita(receita);
        }
        return this.saveReceita(receita);

    }
    public Receita getReceita(Receita receita) {
        return em.find(Receita.class, receita);

    }

    public List<Receita> getAllReceita() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Receita> criteriaQuery = criteriaBuilder.createQuery(Receita.class);
        criteriaQuery.select(criteriaQuery.from(Receita.class));
        List<Receita> receitas = em.createQuery(criteriaQuery).getResultList();
        return receitas;

    }

    public void deleteReceita(Receita receita) {
        em.merge(receita);
        em.remove(receita);

    }

    public Receita getReceitaById(int receitaId) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Receita> criteriaQuery = criteriaBuilder.createQuery(Receita.class);
        Root<Receita> root = criteriaQuery.from(Receita.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), receitaId));
        List<Receita> receitas = em.createQuery(criteriaQuery).getResultList();

        if(receitas.isEmpty()) return null;
        else return receitas.get(0);
    }
    
}
