package br.ufes.inf.dishfy.control;

import br.ufes.inf.dishfy.application.ImagemService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class ImageBean {

    @EJB
    private ImagemService imagemService;

    public byte[] getImagemByReceita(int idReceita){
        byte[] imageByte = imagemService.getReceitaImagem(idReceita).getImage();
        // String imageString = new String(Base64.encodeBase64(imageByte));
        // return imageString;
        return imageByte;
      }

}