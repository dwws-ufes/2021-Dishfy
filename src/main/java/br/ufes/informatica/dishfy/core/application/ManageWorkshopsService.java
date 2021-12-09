package br.ufes.informatica.dishfy.core.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.informatica.dishfy.core.domain.Workshop;

@Local
public interface ManageWorkshopsService extends CrudService<Workshop> {

}
