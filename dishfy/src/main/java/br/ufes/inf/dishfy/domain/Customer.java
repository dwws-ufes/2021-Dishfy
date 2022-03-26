package br.ufes.inf.dishfy.domain;

import java.time.LocalDate;

public class Customer {
    
    private int id;
    private String name;
    private String company;
    private Country country;
    private LocalDate date;
    private int activity;
    private Representative representative;
    
    public Customer(int id, String name, String company,
        Country country, LocalDate date, int activity,
        Representative representative){
            this.id = id;
            this.name = name;
            this.company = company;
            this.country = country;
            this.date = date;
            this.activity = activity;
            this.representative = representative;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getActivity() {
        return this.activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public Representative getRepresentative() {
        return this.representative;
    }

    public void setRepresentative(Representative representative) {
        this.representative = representative;
    }

}
