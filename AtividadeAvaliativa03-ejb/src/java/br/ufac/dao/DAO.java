/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufac.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maicon
 */
public abstract class DAO<E> {
    
    @PersistenceContext(unitName = "AtividadeAvaliativa03-ejbPU")
    protected EntityManager em;
    
    public abstract void persist(E e);
    public abstract List<E> findAll();
    
}
