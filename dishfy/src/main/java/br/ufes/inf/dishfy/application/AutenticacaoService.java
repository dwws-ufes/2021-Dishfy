package br.ufes.inf.dishfy.application;

import java.io.Serializable;

import jakarta.ejb.Local;

import br.ufes.inf.dishfy.domain.Usuario;
import br.ufes.inf.dishfy.exceptions.MultipleObjectException;
import br.ufes.inf.dishfy.exceptions.UserAlreadyExistsException;
import br.ufes.inf.dishfy.exceptions.UserNotFoundException;
import br.ufes.inf.dishfy.exceptions.WrongPasswordException;

@Local
public interface AutenticacaoService extends Serializable {
    
    public Usuario signUp(Usuario usuario) throws UserAlreadyExistsException, MultipleObjectException;

    public void login(String email, String password) throws UserNotFoundException, WrongPasswordException;

    public Usuario getLoggedUser() throws MultipleObjectException;

    public void logout();
}