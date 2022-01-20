package br.ufes.inf.dishfy.application;

import java.io.Serializable;

import jakarta.ejb.Local;

import br.ufes.inf.dishfy.domain.Usuario;

@Local
public interface AutenticacaoService extends Serializable {
    
    public void signUp(Usuario usuario) throws UserAlreadyExistsException;

    public void login() throws UserNotFound;

    public void logout();
}