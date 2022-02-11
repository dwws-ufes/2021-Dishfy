package br.ufes.inf.dishfy.application;

import java.io.Serializable;

import br.ufes.inf.dishfy.domain.ImageDishfy;
import jakarta.ejb.Local;

@Local
public interface ImagemPersitService extends Serializable {
    
    public ImageDishfy  saveImage(ImageDishfy image);
    public ImageDishfy  updateImage(ImageDishfy image);
}
