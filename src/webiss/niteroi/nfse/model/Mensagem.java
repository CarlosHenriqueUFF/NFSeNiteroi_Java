/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
@Entity
@Table(name = "MENSAGEM")
@XmlRootElement
public class Mensagem implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "EVENTOGERADOR")
    private String eventoGerador;
    
    @Basic(optional = false)
    @Column(name = "IDEVENTOGERADOR")
    private Long idEventoGerador;
    
    @Basic(optional = false)
    @Column(name = "DATAINSERCAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInsercao;
    
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Basic(optional = false)
    @Column(name = "ACAO")
    private String acao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventoGerador() {
        return eventoGerador;
    }

    public void setEventoGerador(String eventoGerador) {
        this.eventoGerador = eventoGerador;
    }

    public Long getIdEventoGerador() {
        return idEventoGerador;
    }

    public void setIdEventoGerador(Long idEventoGerador) {
        this.idEventoGerador = idEventoGerador;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensagem)) {
            return false;
        }
        Mensagem other = (Mensagem) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.linepack.nfsemaringa.model.Mensagens[ id=" + id + " ]";
    }

}
