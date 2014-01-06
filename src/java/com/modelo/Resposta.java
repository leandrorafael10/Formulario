/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "RESPOSTA", catalog = "", schema = "FORMULARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resposta.findAll", query = "SELECT r FROM Resposta r"),
    @NamedQuery(name = "Resposta.findByIdresposta", query = "SELECT r FROM Resposta r WHERE r.idresposta = :idresposta"),
    @NamedQuery(name = "Resposta.findByDescricao", query = "SELECT r FROM Resposta r WHERE r.descricao = :descricao"),
    @NamedQuery(name = "Resposta.findByAtivo", query = "SELECT r FROM Resposta r WHERE r.ativo = :ativo")})
public class Resposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESPOSTA")
    private Integer idresposta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATIVO")
    private short ativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idresposta")
    private List<QuestaoResposta> questaoRespostaList;

    public Resposta() {
    }

    public Resposta(Integer idresposta) {
        this.idresposta = idresposta;
    }

    public Resposta(Integer idresposta, String descricao, short ativo) {
        this.idresposta = idresposta;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public Integer getIdresposta() {
        return idresposta;
    }

    public void setIdresposta(Integer idresposta) {
        this.idresposta = idresposta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public short getAtivo() {
        return ativo;
    }

    public void setAtivo(short ativo) {
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
        hash += (idresposta != null ? idresposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resposta)) {
            return false;
        }
        Resposta other = (Resposta) object;
        if ((this.idresposta == null && other.idresposta != null) || (this.idresposta != null && !this.idresposta.equals(other.idresposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Resposta[ idresposta=" + idresposta + " ]";
    }
    
}
