package br.ufes.inf.dishfy.persistence;

import br.ufes.inf.dishfy.domain.ImageDishfy;
import jakarta.ejb.Local;

@Local
public interface ImageDishfyDao {
    
    public void updateImage(ImageDishfy image);
    public void saveImage(ImageDishfy image);

}
