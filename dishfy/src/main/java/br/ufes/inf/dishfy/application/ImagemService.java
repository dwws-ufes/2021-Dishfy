package br.ufes.inf.dishfy.application;

import java.io.Serializable;

import br.ufes.inf.dishfy.domain.ImageDishfy;
import jakarta.ejb.Local;
import jakarta.servlet.http.Part;
@Local
public interface ImagemService extends Serializable {
    
    public void uploadImage();
    public String writeImage(String caminho,ImageDishfy image);
    public String getImageName();
    public void setImageName(String imageName);
    public Part getUploadedFile();
    public void setUploadedFile(Part uploadedFile);
}
