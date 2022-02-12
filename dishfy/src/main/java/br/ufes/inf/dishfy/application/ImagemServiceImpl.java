package br.ufes.inf.dishfy.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import br.ufes.inf.dishfy.domain.ImageDishfy;
import br.ufes.inf.dishfy.persistence.ImageDishfyDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.servlet.http.Part;

@Stateless
public class ImagemServiceImpl implements ImagemService {

    private byte[] imageContents;

    private ImageDishfy image;

    @EJB
    private ImageDishfyDao imageDishfyDao;

    public ImageDishfy uploadImage(String name, Part file) {
            
        image = new ImageDishfy();
        image.setNome(name);
        try {
            InputStream input = file.getInputStream();
            imageContents = input.readAllBytes();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        image.setImage(imageContents);

        return imageDishfyDao.saveImage(image);
    }

    public String writeImage(String caminho,ImageDishfy image){

        try{

            OutputStream os = new FileOutputStream(
                new File(caminho+image.getNome()));
            os.write(image.getImage());
            return caminho+image.getNome();

        }catch(Exception exception)
        {
            return null;
        }       

    }

    public byte[] getImageContents() {
        return imageContents;
    }

    public void setImageContents(byte[] imageContents) {
        this.imageContents = imageContents;
    }
    
}
