package br.ufes.inf.dishfy.persistence;



import java.util.List;

import br.ufes.inf.dishfy.domain.ImageDishfy;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.websocket.Session;


@Stateless
public class ImageDishfyImpl implements ImageDishfyDao{

    @PersistenceContext
    private EntityManager em;

    public ImageDishfy saveImage(ImageDishfy image){
        em.persist(image);
        return image;
    }

    
    public ImageDishfy updateImage(ImageDishfy image){
        em.merge(image);
        // em.persist(image);

        return image;
    }

    public ImageDishfy getImagemByReceita(int idReceita){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ImageDishfy> criteriaQuery = criteriaBuilder.createQuery(ImageDishfy.class);
        Root<ImageDishfy> root = criteriaQuery.from(ImageDishfy.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("receita"), idReceita));
        List<ImageDishfy> imagens = em.createQuery(criteriaQuery).getResultList();

        if(imagens.isEmpty()) return null;
        else return imagens.get(0);
    }
}
