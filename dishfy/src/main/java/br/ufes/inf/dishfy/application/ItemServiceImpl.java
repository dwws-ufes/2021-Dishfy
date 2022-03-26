package br.ufes.inf.dishfy.application;

import java.util.List;

import br.ufes.inf.dishfy.domain.Item;
import br.ufes.inf.dishfy.persistence.ItemDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class ItemServiceImpl implements ItemService{

    @EJB
    private ItemDao itemDao;

    public Item salvarItem(Item item){
        itemDao.saveItem(item);
        return item;
    }

    public List<Item> getItems(int receita_id){
        return itemDao.getItems(receita_id);
    }
}
