package br.ufes.inf.dishfy.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import br.ufes.inf.dishfy.domain.ImageDishfy;
import jakarta.ejb.Stateless;
import jakarta.servlet.http.Part;

@Stateless
public class ImagemServiceImpl implements ImagemService {

    private byte[] imageContents;
    private String imageName;
    private Part uploadedFile;


    public void uploadImage() {
            
        try (InputStream input = uploadedFile.getInputStream()) {
            imageContents = input.readAllBytes();
            
        }
        catch (IOException e) {
            e.printStackTrace();

        }
        
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


      
        public String getImageName() {
            return imageName;
        }


        public void setImageName(String imageName) {
            this.imageName = imageName;
        }


        public Part getUploadedFile() {
            return uploadedFile;
        }


        public void setUploadedFile(Part uploadedFile) {
            this.uploadedFile = uploadedFile;
        }

        public byte[] getImageContents() {
            return imageContents;
        }

        public void setImageContents(byte[] imageContents) {
            this.imageContents = imageContents;
        }


    
}