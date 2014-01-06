/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bean;

import com.rn.QuestaoRN;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author usuario-X
 */
@ManagedBean(name="questaoBean")
@ViewScoped
public class QuestaoBean {
    
    @ManagedProperty("#{QuestaoRN}")
    private QuestaoRN questaoRN;

    public QuestaoRN getQuestaoRN() {
        return questaoRN;
    }

    public void setQuestaoRN(QuestaoRN questaoRN) {
        this.questaoRN = questaoRN;
    }
    
    
}
