package br.ufes.inf.dishfy.domain;

public class Country {
    private int code;
    private String name;
    private String acron;
    

    public Country(int code, String name, String acron) {
        this.code = code;
        this.name = name;
        this.acron = acron;
    }


    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcron() {
        return this.acron;
    }

    public void setAcron(String acron) {
        this.acron = acron;
    }

}
