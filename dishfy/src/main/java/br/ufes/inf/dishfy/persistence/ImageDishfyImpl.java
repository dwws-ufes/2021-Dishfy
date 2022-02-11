package br.ufes.inf.dishfy.persistence;

import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;

import br.ufes.inf.dishfy.domain.ImageDishfy;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Stateless
public class ImageDishfyImpl implements ImageDishfyDao{

    @PersistenceContext
    private EntityManager em;

    public void saveImage(ImageDishfy image){
        em.persist(image);
    }

    public void updateImage(ImageDishfy image){

        em.merge(image);
        em.persist(image);
    }

    
    

    

   


    
}
