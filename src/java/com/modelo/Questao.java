/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author usuario-X
 */
@Entity
@Table(name = "QUESTAO", catalog = "", schema = "FORMULARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questao.findAll", query = "SELECT q FROM Questao q"),
    @NamedQuery(name = "Questao.findByIdquestao", query = "SELECT q FROM Questao q WHERE q.idquestao = :idquestao"),
    @NamedQuery(name = "Questao.findByDescricao", query = "SELECT q FROM Questao q WHERE q.descricao = :descricao"),
    @NamedQuery(name = "Questao.findByDtinc", query = "SELECT q FROM Questao q WHERE q.dtinc = :dtinc")})
public class Questao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDQUESTAO")
    private Integer idquestao;
    @Column(name = "ATIVO")
    @NotNull
    private Integer ativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DTINC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtinc;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquestao")
    private List<QuestaoResposta> questaoRespostaList;

    public Questao() {
    }

    public Questao(Integer idquestao) {
        this.idquestao = idquestao;
    }

    public Questao(Integer idquestao, String descricao, Date dtinc) {
        this.idquestao = idquestao;
        this.descricao = descricao;
        this.dtinc = dtinc;
    }

    public Integer getIdquestao() {
        return idquestao;
    }

    public void setIdquestao(Integer idquestao) {
        this.idquestao = idquestao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtinc() {
        return dtinc;
    }

    public void setDtinc(Date dtinc) {
        this.dtinc = dtinc;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }
    

    @XmlTransient
    @JsonIgnore
    public List<QuestaoResposta> getQuestaoRespostaList() {
        return questaoRespostaList;
    }

    public void setQuestaoRespostaList(List<QuestaoResposta> questaoRespostaList) {
        this.questaoRespostaList = questaoRespostaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idquestao != null ? idquestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questao)) {
            return false;
        }
        Questao other = (Questao) object;
        if ((this.idquestao == null && other.idquestao != null) || (this.idquestao != null && !this.idquestao.equals(other.idquestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Questao[ idquestao=" + idquestao + " ]";
    }
    
}
