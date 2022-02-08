package br.ufes.inf.dishfy.application;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String email){
        super("Usuario com email " + email + " nao encontrado.");
    }
}
