package br.ufes.inf.dishfy.persistence;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.ejb.Stateless;
import jakarta.persistence.PersistenceContext;

import br.ufes.inf.dishfy.domain.Item;

@Stateless
public class ItemImpl implements ItemDao {
    @PersistenceContext
    private EntityManager em;

    public Item saveItem(Item item) {
        em.persist(item);
        return item;
    }

    public List<Item> getItems(int idReceita) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
        Root<Item> root = criteriaQuery.from(Item.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("receita_id"), idReceita));
        List<Item> items = em.createQuery(criteriaQuery).getResultList();
        return items;

    }

    public void deleteItem(Item item) {
        em.merge(item);
        em.remove(item);

    }

    public ItemImpl() {
    }
}
