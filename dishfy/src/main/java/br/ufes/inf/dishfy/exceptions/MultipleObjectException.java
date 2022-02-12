package br.ufes.inf.dishfy.exceptions;

public class MultipleObjectException extends Exception {
    public MultipleObjectException(String id){
        super("Multiplos objetos com id: " + id);
    }
}
