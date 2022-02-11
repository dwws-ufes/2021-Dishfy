package br.ufes.inf.dishfy.application;

import br.ufes.inf.dishfy.domain.ImageDishfy;
import br.ufes.inf.dishfy.persistence.ImageDishfyDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class ImagemPersitServiceImpl implements ImagemPersitService{
    
    @EJB 
    private ImageDishfyDao imageDishfyDao;
    
    public ImageDishfy  saveImage(ImageDishfy image){
           
       return imageDishfyDao.saveImage(image);

    }
    
    public ImageDishfy  updateImage(ImageDishfy image){
        return imageDishfyDao.updateImage(image);
    }
}
