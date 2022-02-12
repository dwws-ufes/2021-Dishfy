package br.ufes.inf.dishfy.persistence;



import br.ufes.inf.dishfy.domain.ImageDishfy;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
        em.persist(image);

        return image;
    }

}
