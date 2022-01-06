package br.ufes.informatica.dishfy.core.persistence;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.ufes.informatica.dishfy.core.domain.Receita;
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
        List<Receita> usuarios = em.createQuery(criteriaQuery).getResultList();
        return usuarios;

    }

    

    
}
