package br.ufes.inf.dishfy.application;

import java.io.Serializable;

import br.ufes.inf.dishfy.domain.Item;
import jakarta.ejb.Local;

@Local
public interface ItemService extends Serializable {
    public Item salvarItem(Item item);
}
