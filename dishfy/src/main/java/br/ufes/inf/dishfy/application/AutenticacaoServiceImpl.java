package br.ufes.inf.dishfy.application;

import br.ufes.inf.dishfy.domain.Usuario;

public class AutenticacaoServiceImpl implements AutenticacaoService{

    public void signUp(Usuario usuario) throws UserAlreadyExistsException {
        if(!entityManager.contains(usuario)){
            throw new UserAlreadyExistsException(usuario.getEmail());
        }
        // TODO: Implementar o security
        // TODO: Como setar chave primaria para ser um atributo específico?
        entityManager.persist(usuario);
    }
    
}
