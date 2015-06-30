package br.ufac.mb;

import br.ufac.ebjs.DiretorEJB;
import br.ufac.entidades.Diretor;
import br.ufac.entidades.Filme;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author maicon
 */
@ManagedBean
@ViewScoped
public class DiretorMB {

    @EJB
    private DiretorEJB diretorEJB;
    private Diretor diretor;
    private Filme filme;
    private List<Diretor> diretores;

    /**
     * Creates a new instance of DiretorMB
     */
    public DiretorMB() {
        diretor = new Diretor();
        filme = new Filme();
    }

    public void addFilmes() {
        if (diretor.getFilmes() == null) {
            diretor.setFilmes(new ArrayList<Filme>());
        }

        diretor.getFilmes().add(filme);
        filme = new Filme();
    }

    public String incluir() {
        diretorEJB.persist(diretor);
        diretor = new Diretor();
        return null;
    }

    public List<Diretor> getDiretores() {
        if (diretores == null) {
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

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

}
