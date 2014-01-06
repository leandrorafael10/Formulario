/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario-X
 */
@Entity
@Table(name = "QUESTAO_RESPOSTA", catalog = "", schema = "FORMULARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestaoResposta.findAll", query = "SELECT q FROM QuestaoResposta q"),
    @NamedQuery(name = "QuestaoResposta.findByIdquestaoResposta", query = "SELECT q FROM QuestaoResposta q WHERE q.idquestaoResposta = :idquestaoResposta"),
    @NamedQuery(name = "QuestaoResposta.findByDtinc", query = "SELECT q FROM QuestaoResposta q WHERE q.dtinc = :dtinc")})
public class QuestaoResposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDQUESTAO_RESPOSTA")
    private Integer idquestaoResposta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DTINC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtinc;
    @JoinColumn(name = "IDRESPOSTA", referencedColumnName = "IDRESPOSTA")
    @ManyToOne(optional = false)
    private Resposta idresposta;
    @JoinColumn(name = "IDQUESTAO", referencedColumnName = "IDQUESTAO")
    @ManyToOne(optional = false)
    private Questao idquestao;
    @JoinColumn(name = "IDPESSOA", referencedColumnName = "IDPESSOA")
    @ManyToOne
    private Pessoa idpessoa;

    public QuestaoResposta() {
    }

    public QuestaoResposta(Integer idquestaoResposta) {
        this.idquestaoResposta = idquestaoResposta;
    }

    public QuestaoResposta(Integer idquestaoResposta, Date dtinc) {
        this.idquestaoResposta = idquestaoResposta;
        this.dtinc = dtinc;
    }

    public Integer getIdquestaoResposta() {
        return idquestaoResposta;
    }

    public void setIdquestaoResposta(Integer idquestaoResposta) {
        this.idquestaoResposta = idquestaoResposta;
    }

    public Date getDtinc() {
        return dtinc;
    }

    public void setDtinc(Date dtinc) {
        this.dtinc = dtinc;
    }

    public Resposta getIdresposta() {
        return idresposta;
    }

    public void setIdresposta(Resposta idresposta) {
        this.idresposta = idresposta;
    }

    public Questao getIdquestao() {
        return idquestao;
    }

    public void setIdquestao(Questao idquestao) {
        this.idquestao = idquestao;
    }

    public Pessoa getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Pessoa idpessoa) {
        this.idpessoa = idpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idquestaoResposta != null ? idquestaoResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestaoResposta)) {
            return false;
        }
        QuestaoResposta other = (QuestaoResposta) object;
        if ((this.idquestaoResposta == null && other.idquestaoResposta != null) || (this.idquestaoResposta != null && !this.idquestaoResposta.equals(other.idquestaoResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.QuestaoResposta[ idquestaoResposta=" + idquestaoResposta + " ]";
    }
    
}
