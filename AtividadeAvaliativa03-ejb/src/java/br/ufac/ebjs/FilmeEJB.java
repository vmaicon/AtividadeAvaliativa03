package br.ufac.ebjs;

import br.ufac.dao.DAO;
import br.ufac.entidades.Filme;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
public class FilmeEJB extends DAO<Filme>{

    public void persist(Filme f) {
        em.merge(f);
    }
    
    public List<Filme> findAll(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Filme> cq = cb.createQuery(Filme.class);
        Root<Filme> f = cq.from(Filme.class);
        cq.select(f);
        TypedQuery<Filme> tq = em.createQuery(cq);
        
        return tq.getResultList();
    }
    
    public Filme findByTitle(String title){
        TypedQuery<Filme> f = (TypedQuery<Filme>) em.createQuery("SELECT f FROM Filme f WHERE f.titulo=?1");
        f.setParameter(1, title);
        System.out.println("FILME PESQUISADO: "+f.toString());
        return f.getSingleResult();
    }
}
