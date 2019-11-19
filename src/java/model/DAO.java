/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Thiago Henrique Santos
 */
public class DAO<T> implements Serializable {
    private final Class<T> classe;
    private EntityManager manager;
    
    public DAO(EntityManager manager, Class<T> classe) {
        this.classe = classe;
        this.manager = manager;
    }
    
    public void adicionar(T t) {
        manager.persist(t);
    }
    
    public T consultar(Long id) {
        T instancia = manager.find(classe, id);
        return instancia;
    }
    
    public void alterar(T t) {
        manager.merge(t);
    }
    
    public void excluir(Long id) {
        T t = manager.find(classe, id);
        manager.remove(t);
    }
    
    public List<T> listarGenerico(String query, Object... params) {
        Query q = manager.createNamedQuery(query);
        for (int i = 0; i < params.length; i++) {
            q.setParameter(i + 1, params[i]);
        }
        List<T> lista = q.getResultList();
        return lista;
    }
}
