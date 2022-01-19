package br.ufes.inf.dishfy.application;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
@LocalBean
public class AutenticarService {
    @PersistenceContext
    private EntityManager entityManager;

    // public String signUp(String nome, String email, String senha){

    // }
}