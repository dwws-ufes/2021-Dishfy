package br.ufes.inf.dishfy.application;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String email) {
        super("Usuario com email " + email + " ja existe.");
    }
}
