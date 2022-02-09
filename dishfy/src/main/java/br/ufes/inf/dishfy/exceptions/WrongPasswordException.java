package br.ufes.inf.dishfy.exceptions;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Senha incorreta");
    }
}
