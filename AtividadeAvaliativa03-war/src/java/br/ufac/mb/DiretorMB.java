package br.ufac.mb;

import br.ufac.ebjs.DiretorEJB;
import br.ufac.entidades.Diretor;
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
public class DiretorMB {
    
    @EJB
    private DiretorEJB diretorEJB;
    private Diretor diretor = new Diretor();
    private List<Diretor> diretores;
    
    /**
     * Creates a new instance of DiretorMB
     */
    public DiretorMB() {
    }
    

    public List<Diretor> getDiretores() {
        if(diretores == null){
            diretores = diretorEJB.findAll();
        }
        return diretores;
    }

    public void setDiretores(List<Diretor> diretores) {
        this.diretores = diretores;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    
    public String incluir(){
        diretorEJB.persist(diretor);
        return null;
    }
    
    
    
}
