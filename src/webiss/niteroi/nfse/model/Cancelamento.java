/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
@Entity
@Table(name = "CANCELAMENTO")
@XmlRootElement
@NamedQuery(name = "cancelamentosPendentes", query = "SELECT c FROM Cancelamento c WHERE c.isCancelada = 0 AND c.isProblematica = 0")
public class Cancelamento implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "NUMERONOTA")
    private BigInteger numeroNota;
    
    @Basic(optional = false)
    @Column(name = "CNPJ")
    private String cnpj;
    
    @Basic(optional = false)
    @Column(name = "INSCRICAOMUNICIPAL")
    private String inscricaoMunicipal;
    
    @Basic(optional = false)
    @Column(name = "CODIGOMUNICIPIO")
    private Integer codigoMunicipio;
    
    @Basic(optional = false)
    @Column(name = "ISCANCELADA")
    private Integer isCancelada;
    
    @Basic(optional = false)
    @Column(name = "ISPROBLEMATICA")
    private Integer isProblematica;
    
    @Basic(optional = false)
    @Column(name = "USUARIOINSERCAO")
    private String usuarioInsercao;
    
    @Basic(optional = false)
    @Column(name = "DATAINSERCAO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataInsercao;
    
    @Basic(optional = false)
    @Column(name = "USUARIOALTERACAO")
    private String usuarioAlteracao;
    
    @Basic(optional = false)
    @Column(name = "DATAALTERACAO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @Basic(optional = false)
    @Column(columnDefinition = "CLOB", name = "XMLENVIO")
    private String xmlEnvio;
    
    @Basic(optional = false)
    @Column(columnDefinition = "CLOB", name = "XMLRETORNO")
    private String xmlRetorno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(BigInteger numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public Integer getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Integer codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public Integer getIsCancelada() {
        return isCancelada;
    }

    public void setIsCancelada(Integer isCancelada) {
        this.isCancelada = isCancelada;
    }

    public Integer getIsProblematica() {
        return isProblematica;
    }

    public void setIsProblematica(Integer isProblematica) {
        this.isProblematica = isProblematica;
    }

    public String getUsuarioInsercao() {
        return usuarioInsercao;
    }

    public void setUsuarioInsercao(String usuarioInsercao) {
        this.usuarioInsercao = usuarioInsercao;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(String usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
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

}
