/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufac.mb;

import br.ufac.ebjs.AtorEJB;
import br.ufac.ebjs.DiretorEJB;
import br.ufac.ebjs.FilmeEJB;
import br.ufac.entidades.Ator;
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
public class FilmeMB {
    
    @EJB
    private FilmeEJB filmeEJB;
    @EJB
    private AtorEJB atorEJB;
    @EJB
    private DiretorEJB diretorEJB;

    private Filme filme;
    private Ator ator;
    private Diretor diretor;
    private List<Ator> atores;
    private List<Diretor> diretores;
    
    private List<String> atoresString;
    

    /**
     * Creates a new instance of FilmeMB
     */
    public FilmeMB() {
        filme = new Filme();
        ator = new Ator();
        diretor = new Diretor();
        if(filme.getAtores() == null){
            filme.setAtores(new ArrayList<Ator>());
        }
    }
    
    public void addAtor(){
        if(atoresString == null) setAtoresString(new ArrayList<String>());
        for (String a: atoresString) {
            ator = new Ator();
            ator = atorEJB.findById(Long.valueOf(a));
            filme.getAtores().add(ator);
        }
    }
    
    public String incluir(){
        filme.getDiretor().setId(diretor.getId());
        filmeEJB.persist(filme);
        filme = new Filme();
        
        return null;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getAtores() {
        return atores = atorEJB.findAll();
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public List<String> getAtoresString() {
        return atoresString;
    }

    public void setAtoresString(List<String> atoresString) {
        this.atoresString = atoresString;
    }

    
//    Retorna todos os diretores
    
    public List<Diretor> getDiretores() {
        return diretores = diretorEJB.findAll();
    }

    public void setDiretores(List<Diretor> diretores) {
        this.diretores = diretores;
    }
    
    
}
