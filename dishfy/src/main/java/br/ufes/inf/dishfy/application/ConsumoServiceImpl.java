package br.ufes.inf.dishfy.application;

import java.util.ArrayList;
import java.util.List;

import br.ufes.inf.dishfy.domain.Consumo;
import br.ufes.inf.dishfy.persistence.ConsumoDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class ConsumoServiceImpl implements ConsumoService {
    @EJB
    private ConsumoDao consumoDao;

    public Consumo saveConsumo(Consumo consumo){
        return consumoDao.saveConsumo(consumo);
    }

    public void deleteConsumo(Consumo consumo){
        consumoDao.deleteConsumo(consumo);
    }
    public Consumo getById(Integer id){
        return consumoDao.getConsumoById(id);

    }
    public List<Consumo> getConsumo(ArrayList<Integer> idConsumo){

        return consumoDao.getConsumo(idConsumo);

    }


}
