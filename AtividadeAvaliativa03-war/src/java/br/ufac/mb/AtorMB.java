package br.ufac.mb;

import br.ufac.ebjs.AtorEJB;
import br.ufac.ebjs.FilmeEJB;
import br.ufac.entidades.Ator;
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
public class AtorMB {

    @EJB
    private AtorEJB atorEJB;
    @EJB
    private FilmeEJB filmeEJB;
    private Ator ator;
    private Filme filme;
    private List<Filme> filmes;
    private List<Ator> atores;
    private List<String> filmesString;

    /**
     * Creates a new instance of AtorMB
     */
    public AtorMB() {
        ator = new Ator();
        filme = new Filme();
        if (ator.getFilmes() == null) {
            ator.setFilmes(new ArrayList<Filme>());
        }
    }

    public String incluir() {
        atorEJB.persist(ator);
        ator = new Ator();

        return null;
    }

    public Ator getAtor() {
        return ator;
    }

    public List<Ator> getAtores() {
        if (atores == null) {
            return atorEJB.findAll();
        }
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getFilmes() {
        if (filmes == null) {
            filmes = filmeEJB.findAll();
        }
        return filmes;
    }

    public List<String> getFilmesString() {
        return filmesString;
    }

    public void setFilmesString(List<String> filmesString) {
        this.filmesString = filmesString;
    }
    
    public void adicionaFilmes(){
        if(filmesString == null)filmesString = new ArrayList<String>();
        for (String f : filmesString) {
            filme = new Filme();
            filme = filmeEJB.findByTitle(f);
            ator.getFilmes().add(filme);
        }
    }
}
