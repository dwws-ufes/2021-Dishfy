package br.ufes.inf.dishfy.domain;

public class Representative {
    public String name;
    public String image;
    

    public Representative(String name, String image) {
        this.name = name;
        this.image = image;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
