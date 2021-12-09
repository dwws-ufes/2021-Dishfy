package br.ufes.informatica.dishfy.core.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.informatica.dishfy.core.domain.Workshop;

@Local
public interface WorkshopDAO extends BaseDAO<Workshop> {

}
