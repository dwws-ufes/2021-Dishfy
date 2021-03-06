package br.ufes.inf.dishfy.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ufes.inf.dishfy.domain.Consumo;

public interface ConsumoDao {
    public Consumo saveConsumo(Consumo consumo);
    public Consumo getConsumoById(Integer id);
    public List<Consumo> getConsumo(ArrayList<Integer> idConsumo);
    public List<Consumo> getConsumos(int idUsuario);
    public void deleteConsumo(Consumo consumo);
    
}
