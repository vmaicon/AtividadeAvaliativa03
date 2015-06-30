
package br.ufac.mb;

import br.ufac.ebjs.AtorEJB;
import br.ufac.entidades.Ator;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author maicon
 */
@ManagedBean
@RequestScoped
public class AtorMB {
    @EJB
    private AtorEJB atorEJB;
    private Ator ator;
    private List<Ator> atores;

    public List<Ator> getAtores() {
        if(atores == null) return atorEJB.findAll();
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    /**
     * Creates a new instance of AtorMB
     */
    public AtorMB() {}
    
    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }
}
