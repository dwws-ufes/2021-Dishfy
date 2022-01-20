package br.ufes.inf.dishfy.application;

public class UserNotFound extends Exception {
    public UserNotFound(String email){
        super("Usuario com email " + email + " nao encontrado.");
    }
}
