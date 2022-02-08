package br.ufes.inf.dishfy.application;

import br.ufes.inf.dishfy.domain.Usuario;
//coment
public class AutenticacaoEvent {
    private Usuario usuario;

    public AutenticacaoEvent(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
