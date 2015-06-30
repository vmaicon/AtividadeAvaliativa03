package br.ufac.ebjs;

import br.ufac.dao.DAO;
import br.ufac.entidades.Ator;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
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
public class AtorEJB extends DAO<Ator>{

    @Override
    public void persist(Ator e) {
        em.merge(e);
    }

    @Override
    public List<Ator> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Ator> cq = cb.createQuery(Ator.class);
        Root<Ator> a = cq.from(Ator.class);
        cq.select(a);
        TypedQuery<Ator> tp = em.createQuery(cq);
        
        return tp.getResultList();
    }
}
