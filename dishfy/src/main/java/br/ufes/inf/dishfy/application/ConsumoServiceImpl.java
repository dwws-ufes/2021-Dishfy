package br.ufes.inf.dishfy.application;

import br.ufes.inf.dishfy.persistence.UsuarioDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class ConsumoServiceImpl implements ConsumoService {
    @EJB
    private UsuarioDao usuarioDao;
}
