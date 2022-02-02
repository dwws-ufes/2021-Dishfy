package br.ufes.inf.dishfy.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ufes.inf.dishfy.domain.Consumo;

public interface ConsumoDao {
    public Consumo saveConsumo(Consumo consumo);
    public Consumo getUsuarioById(Integer id);
    public List<Consumo> getConsumo(ArrayList<Integer> idConsumo);
    public void deleteUsuario(Consumo consumo);
    
}
