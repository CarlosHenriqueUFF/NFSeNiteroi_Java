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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
@Entity
@Table(name = "LOTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "lotesEnviados", query = "SELECT l FROM Lote l WHERE l.isEnviado = 1 AND l.protocolo IS NOT NULL"),
    @NamedQuery(name = "lotesPendentes", query = "SELECT l FROM Lote l WHERE l.isEnviado = 0 AND l.isProblematico = 0"),
    @NamedQuery(name = "maxNumeroLote", query = "SELECT l FROM Lote l WHERE l.isEnviado = 0 ORDER BY l.numero DESC"),
    @NamedQuery(name = "getLoteByNumero", query = "SELECT l FROM Lote l WHERE l.numero = :numero")})
public class Lote implements Serializable {

    @Id
    @GeneratedValue(generator = "SqliteGenLote")
    @TableGenerator(name = "SqliteGenLote", table = "my_sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "LOTE",
            initialValue = 1, allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private Long numero;
    
    @Basic(optional = false)
    @Column(name = "PROTOCOLO")
    private String protocolo;
    
    @Basic(optional = false)
    @Column(name = "DATAHORACRIACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCriacao;
    
    @Basic(optional = false)
    @Column(name = "DATAHORAENVIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraEnvio;

    @Basic(optional = false)
    @Column(name = "ISENVIADO")
    private Integer isEnviado;
    
    @Basic(optional = false)
    @Column(name = "ISPROBLEMATICO")
    private Integer isProblematico;

    @Basic(optional = false)
    @Column(name = "DATAHORARECEBIMENTO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHoraRecebimento;
    
    @Basic(optional = false)
    @Column(columnDefinition = "CLOB", name = "XMLENVIO")
    private String xmlEnvio;
    
    @Basic(optional = false)
    @Column(columnDefinition = "CLOB", name = "XMLRETORNO")
    private String xmlRetorno;
    

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Date getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(Date dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public Date getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public void setDataHoraEnvio(Date dataHoraEnvio) {
        this.dataHoraEnvio = dataHoraEnvio;
    }

    public Integer getIsEnviado() {
        return isEnviado;
    }

    public void setIsEnviado(Integer isEnviado) {
        this.isEnviado = isEnviado;
    }

    public Integer getIsProblematico() {
        return isProblematico;
    }

    public void setIsProblematico(Integer isProblematico) {
        this.isProblematico = isProblematico;
    }

    public Date getDataHoraRecebimento() {
        return dataHoraRecebimento;
    }

    public void setDataHoraRecebimento(Date dataHoraRecebimento) {
        this.dataHoraRecebimento = dataHoraRecebimento;
    }

    public String getXmlEnvio() {
        return xmlEnvio;
    }

    public void setXmlEnvio(String xmlEnvio) {
        this.xmlEnvio = xmlEnvio;
    }

    public String getXmlRetorno() {
        return xmlRetorno;
    }

    public void setXmlRetorno(String xmlRetorno) {
        this.xmlRetorno = xmlRetorno;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        return !((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero)));
    }

    @Override
    public String toString() {
        return "org.linepack.nfsemaringa.model.Envio[ numero=" + numero + " ]";
    }

}
