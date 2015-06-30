
package br.ufac.mb;

import br.ufac.ebjs.AtorEJB;
import br.ufac.entidades.Ator;
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

    /**
     * Creates a new instance of AtorMB
     */
    public AtorMB() {
    }
    
}
