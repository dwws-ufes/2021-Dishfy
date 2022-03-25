package br.ufes.inf.dishfy.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufes.inf.dishfy.domain.Consumo;
import jakarta.ejb.Local;

@Local
public interface ConsumoService extends Serializable{
    public Consumo saveConsumo(Consumo consumo);
    public void deleteConsumo(Consumo consumo);
    public Consumo getById(Integer id);
    public List<Consumo> getConsumoById(int idUsuario);
    public List<Consumo> getConsumo(ArrayList<Integer> idConsumo);    
}
