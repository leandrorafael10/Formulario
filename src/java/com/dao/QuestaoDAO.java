/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.modelo.Questao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario-X
 */
@Repository("questaoDAO")
public class QuestaoDAO implements AbstractDAO<Questao,Integer>{
    
    @Autowired
    private SessionFactory sf;

    public SessionFactory getSf() {
        return sf;
    }

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<Questao> listar() {
        return  (List<Questao>)getSf().getCurrentSession().createQuery("from com.modelo.Questao q where q.ativo = 1").list();
    }

    @Override
    public Questao buscar(Integer k) {
        Query query = getSf().getCurrentSession().createQuery("from com.modelo.Questao q where q.idquestao = :id").setInteger("id", k);
        return (Questao)query.uniqueResult();
    }

    @Override
    public void atualizar(Questao obj) {
        getSf().getCurrentSession().update(obj);
    }

    @Override
    public void excluir(Questao obj) {
        getSf().getCurrentSession().delete(obj);
    }

    @Override
    public void salvar(Questao obj) {
        getSf().getCurrentSession().save(obj);
    }

    public List<Questao> listarTodos() {
        return  (List<Questao>)getSf().getCurrentSession().createQuery("from com.modelo.Questao q ").list();
    }
            
}
