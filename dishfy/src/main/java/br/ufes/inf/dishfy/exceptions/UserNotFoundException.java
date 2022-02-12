package br.ufes.inf.dishfy.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String email){
        super("Usuario com email " + email + " nao encontrado.");
    }
}
