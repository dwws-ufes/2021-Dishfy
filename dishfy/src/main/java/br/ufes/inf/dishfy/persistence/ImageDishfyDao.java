package br.ufes.inf.dishfy.persistence;

import br.ufes.inf.dishfy.domain.ImageDishfy;
import jakarta.ejb.Local;

@Local
public interface ImageDishfyDao {
    
    public ImageDishfy updateImage(ImageDishfy image);
    public ImageDishfy saveImage(ImageDishfy image);
    public ImageDishfy getImagemByReceita(int idReceita);
}
