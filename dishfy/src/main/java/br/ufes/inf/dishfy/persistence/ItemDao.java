package br.ufes.inf.dishfy.persistence;

import java.util.List;

import br.ufes.inf.dishfy.domain.Item;

public interface ItemDao {
    public void saveItem(Item item);
    public List<Item> getItems(int idReceita);
    public void deleteItem(Item item);

}
