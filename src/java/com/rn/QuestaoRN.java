/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rn;

import com.dao.QuestaoDAO;
import com.modelo.Questao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario-X
 */

@Service("questaoRN")
public class QuestaoRN {
    
    @Autowired
    private QuestaoDAO questaoDAO;

    public QuestaoDAO getQuestaoDAO() {
        return questaoDAO;
    }

    public void setQuestaoDAO(QuestaoDAO questaoDAO) {
        this.questaoDAO = questaoDAO;
    }
    
    public List<Questao> listar(){
        return getQuestaoDAO().listar();
    }
    public List<Questao> listarTodos(){
        return getQuestaoDAO().listarTodos();
    }
    public void salvar(Questao questao){
        getQuestaoDAO().salvar(questao);
    }
    public void atualizar(Questao questao){
        getQuestaoDAO().atualizar(questao);
    }
    
    
}
