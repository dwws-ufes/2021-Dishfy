package br.ufes.inf.dishfy.application;

import java.io.Serializable;

import br.ufes.inf.dishfy.domain.ImageDishfy;
import jakarta.ejb.Local;
import jakarta.servlet.http.Part;
@Local
public interface ImagemService extends Serializable {
    
    public ImageDishfy uploadImage(String name, Part file);
    public String writeImage(String caminho,ImageDishfy image);
    public byte[] getImageContents();
    public void setImageContents(byte[] imageContents);
}
