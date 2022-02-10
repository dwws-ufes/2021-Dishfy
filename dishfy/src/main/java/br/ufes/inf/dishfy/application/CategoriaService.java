package br.ufes.inf.dishfy.application;

import java.io.Serializable;
import java.util.List;

import br.ufes.inf.dishfy.domain.Categoria;

public interface CategoriaService extends Serializable{
    public Categoria saveCategoria(Categoria categoria);
    public void deleteCategoria(Categoria categoria);
    public Categoria getCategoriaByName(String nome);
    public List<Categoria> getCategorias();
}
