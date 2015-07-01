package br.ufac.ebjs;

import br.ufac.dao.DAO;
import br.ufac.entidades.Filme;
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
public class FilmeEJB extends DAO<Filme>{

    @Override
    public void persist(Filme f) {
        em.merge(f);
    }
    
    @Override
    public List<Filme> findAll(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Filme> cq = cb.createQuery(Filme.class);
        Root<Filme> f = cq.from(Filme.class);
        cq.select(f);
        TypedQuery<Filme> tq = em.createQuery(cq);
        
        return tq.getResultList();
    }
    
    /*
    Retorna uma isntância do filme a partir de uma query com o parametro 
    titulo.
    O TypeQuery<Filme> retorna a instância da classe referênciada.
    */
    public Filme findByTitle(String title){
        TypedQuery<Filme> f = (TypedQuery<Filme>) em.createQuery("SELECT f FROM Filme f WHERE f.titulo=?1");
        f.setParameter(1, title);
        return f.getSingleResult();
    }
}
