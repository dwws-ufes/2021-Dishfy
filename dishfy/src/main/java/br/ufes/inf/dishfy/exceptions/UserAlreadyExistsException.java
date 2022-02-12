package br.ufes.inf.dishfy.exceptions;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String email) {
        super("Usuario com email " + email + " ja existe.");
    }
}
