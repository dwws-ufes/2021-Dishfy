package br.ufes.inf.dishfy.persistence;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import br.ufes.inf.dishfy.domain.Receita;


public class ReceitaImpl implements ReceitaDao {
    private final EntityManager em;

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

    

    
}
