package br.ufes.inf.dishfy.application;

import br.ufes.inf.dishfy.persistence.ReceitaDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class ReceitaServiceImpl implements ReceitaService {
    @EJB
    private ReceitaDao receitaDao;
}
