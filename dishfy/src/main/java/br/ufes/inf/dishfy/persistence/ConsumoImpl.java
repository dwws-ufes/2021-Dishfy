package br.ufes.inf.dishfy.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ufes.inf.dishfy.domain.Consumo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Stateless
public class ConsumoImpl implements ConsumoDao {

    @PersistenceContext
    private EntityManager em;

    public ConsumoImpl() {
    }

    public Consumo saveConsumo(Consumo consumo){

        em.persist(consumo);

        return consumo;

    }
    public Consumo getConsumoById(Integer id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Consumo> criteriaQuery = criteriaBuilder.createQuery(Consumo.class);
        Root<Consumo> root = criteriaQuery.from(Consumo.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));
        List<Consumo> consumo = em.createQuery(criteriaQuery).getResultList();
        for (Consumo u : consumo) {
            if (u.getId()==id) {
                return u;
            }
        }
        return null;
    }

    /* Para realizar o filtro de consumo de um usuário
       É necessário extrair da tabela Usuario_Consumo
       Os ids de consumo vinculados ao usuário  
    
    */ 

    public List<Consumo> getConsumo(ArrayList<Integer> idConsumo) {

        List<Consumo> consumo = new ArrayList<Consumo>();
        Consumo aux;
        for(Integer u : idConsumo){

            aux = getConsumoById(u); 

            if (aux!=null){
                consumo.add(aux);
            }
        }

        return consumo;

    }

    public List<Consumo> getConsumos(int idUsuario) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Consumo> criteriaQuery = criteriaBuilder.createQuery(Consumo.class);
        Root<Consumo> root = criteriaQuery.from(Consumo.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("usuario"), idUsuario));
        List<Consumo> consumos = em.createQuery(criteriaQuery).getResultList();
        return consumos;

    }

    public void deleteConsumo(Consumo consumo) {
        em.merge(consumo);
        em.remove(consumo);

    }
    
}
