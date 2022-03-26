package br.ufes.inf.dishfy.application;

import java.io.Serializable;
import java.util.List;

import br.ufes.inf.dishfy.domain.Item;
import jakarta.ejb.Local;

@Local
public interface ItemService extends Serializable {
    public Item salvarItem(Item item);
    public List<Item> getItems(int receita_id);
}
