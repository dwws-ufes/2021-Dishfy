package br.ufes.inf.dishfy.persistence;

import java.util.List;

import br.ufes.inf.dishfy.domain.Categoria;
import br.ufes.inf.dishfy.exceptions.MultipleObjectException;

public interface CategoriaDao {
    public Categoria saveCategoria(Categoria categoria);
    public Categoria getCategoriaByName(String nome)  throws MultipleObjectException;
    public List<Categoria> getCategorias();
    public void deleteCategoria(Categoria categoria);
}
