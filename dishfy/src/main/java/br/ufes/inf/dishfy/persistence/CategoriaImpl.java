package br.ufes.inf.dishfy.persistence;

import java.util.List;

import br.ufes.inf.dishfy.domain.Categoria;
import br.ufes.inf.dishfy.exceptions.MultipleObjectException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Stateless
public class CategoriaImpl implements CategoriaDao {

    @PersistenceContext
    private EntityManager em;

    public CategoriaImpl() {
        
    }

    public Categoria saveCategoria(Categoria categoria){
        em.persist(categoria);
        return categoria;
    }

    public Categoria getCategoriaByName(String nome) throws MultipleObjectException {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Categoria> criteriaQuery = criteriaBuilder.createQuery(Categoria.class);
        Root<Categoria> root = criteriaQuery.from(Categoria.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("nome"), nome));
        List<Categoria> categorias = em.createQuery(criteriaQuery).getResultList();

        if(categorias.isEmpty()) return null;
        else if(categorias.size() != 1) throw new MultipleObjectException("Categoria"+nome);
        else return categorias.get(0);
    }

    public List<Categoria> getCategorias(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Categoria> criteriaQuery = criteriaBuilder.createQuery(Categoria.class);
        criteriaQuery.select(criteriaQuery.from(Categoria.class));
        List<Categoria> categorias = em.createQuery(criteriaQuery).getResultList();
        return categorias;
    }

    public void deleteCategoria(Categoria categoria){
        em.merge(categoria);
        em.remove(categoria);
    }
}
