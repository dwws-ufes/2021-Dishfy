package br.ufes.inf.dishfy.exceptions;

public class MultipleUserObjectException extends Exception {
    public MultipleUserObjectException(String email){
        super("Multiplos usuarios com email: " + email);
    }
}
