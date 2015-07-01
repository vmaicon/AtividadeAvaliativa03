package br.ufac.ebjs;

import br.ufac.dao.DAO;
import br.ufac.entidades.Diretor;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author maicon
 */
@Stateless
@LocalBean
public class DiretorEJB extends DAO<Diretor> {

    public void persist(Diretor d) {
        em.persist(d);
    }

    /**
     * Método implementado com critéria
     * @return Retorna uma lista de Diretores
     */
    public List<Diretor> findAll(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Diretor> cq = cb.createQuery(Diretor.class);
        Root<Diretor> d = cq.from(Diretor.class);
        cq.select(d);
        TypedQuery<Diretor> tq = em.createQuery(cq);
        
        return tq.getResultList();
    }

    public Diretor findById(Long id) {
        return em.find(Diretor.class, id);
    }
}