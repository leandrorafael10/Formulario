/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.List;

/**
 *
 * @author usuario-X
 */
public interface AbstractDAO<Obj, K> {

    List<Obj> listar();

    Obj buscar(K k);
    
    void atualizar(Obj obj);
    
    void excluir(Obj obj);
    
    void salvar(Obj obj);
    
}
