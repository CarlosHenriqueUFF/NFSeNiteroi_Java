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
@Table(name = "ENVIO")
@XmlRootElement
@NamedQuery(name = "enviosPendentes", query = "SELECT e FROM Envio e WHERE e.isEnviada = 0 AND e.isProblematica = 0")
public class Envio implements Serializable {

    @Id
    @GeneratedValue(generator = "SqliteGenEnvio")
    @TableGenerator(name = "SqliteGenEnvio", table = "my_sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "ENVIO",
            initialValue = 1, allocationSize = 1)
    @Basic(optional = false)
    //@Column(name = "ID")
    //private Long id;

    // RPS            
    //@Basic(optional = false)
    @Column(name = "NUMERORPS")
    private Long numeroRps;
    
    @Basic(optional = false)
    @Column(name = "SERIERPS")
    private String serieRps;
    
    @Basic(optional = false)
    @Column(name = "TIPORPS")
    private String tipoRps;
    
    @Basic(optional = false)
    @Column(name = "DATAEMISSAORPS")
    @Temporal(TemporalType.DATE)
    private Date dataEmissaoRps;
    
    @Basic(optional = false)
    @Column(name = "STATUSRPS")
    private Integer statusRps;
    
    @Basic(optional = false)
    @Column(name = "DATACOMPETENCIARPS")
    @Temporal(TemporalType.DATE)
    private Date dataCompetenciaRps;

    // SERVIÇO
    @Basic(optional = false)
    @Column(name = "VALORSERVICOS")
    private Double valorServicos;
    
    @Basic(optional = false)
    @Column(name = "VALORDEDUCOES")
    private Double valorDeducoes;
    
    @Basic(optional = false)
    @Column(name = "VALORPIS")
    private Double valorPis;
    
    @Basic(optional = false)
    @Column(name = "VALORCOFINS")
    private Double valorCofins;
    
    @Basic(optional = false)
    @Column(name = "VALORINSS")
    private Double valorInss;
    
    @Basic(optional = false)
    @Column(name = "VALORIR")
    private Double valorIr;
    
    @Basic(optional = false)
    @Column(name = "VALORCSLL")
    private Double valorCsll;
    
    @Basic(optional = false)
    @Column(name = "OUTRASRETENCOES")
    private Double outrasRetencoes;
    
    @Basic(optional = false)
    @Column(name = "VALORISS")
    private Double valorIss;
    
    @Basic(optional = false)
    @Column(name = "ALIQUOTA")
    private Double aliquota;
    
    @Basic(optional = false)
    @Column(name = "DESCONTOINCONDICIONADO")
    private Double descontoIncondicionado;
    
    @Basic(optional = false)
    @Column(name = "DESCONTOCONDICIONADO")
    private Double descontoCondicionado;
    
    @Basic(optional = false)
    @Column(name = "ISSRETIDO")
    private Integer issRetido;
    
    @Basic(optional = false)
    @Column(name = "RESPONSAVELRETENCAO")
    private Integer responsavelRetencao;
    
    @Basic(optional = false)
    @Column(name = "ITEMLISTASERVICO")
    private String itemListaServico;
    
    @Basic(optional = false)
    @Column(name = "CODIGOCNAE")
    private Integer codigoCnae;
    
    @Basic(optional = false)
    @Column(name = "CODIGOTRIBUTACAOMUNICIPIO")
    private String codigoTributacaoMunicipio;
    
    @Basic(optional = false)
    @Column(name = "DISCRIMINACAOSERVICO")
    private String discriminacaoServico;
    
    @Basic(optional = false)
    @Column(name = "CODIGOMUNICIPIO")
    private Integer codigoMunicipioServico;
    
    @Basic(optional = false)
    @Column(name = "CODIGOPAIS")
    private String codigoPais;
    
    @Basic(optional = false)
    @Column(name = "EXIGIBILIDADEISS")
    private Integer exigibilidadeIss;
    
    @Basic(optional = false)
    @Column(name = "MUNICIPIOINCIDENCIA")
    private Integer municipioIncidencia;
    
    @Basic(optional = false)
    @Column(name = "NUMEROPROCESSO")
    private String numeroProcesso;

    // PRESTADOR
    @Basic(optional = false)
    @Column(name = "TPODOCUMENTOPRESTADOR")
    private String tipoDocumentoPrestador;
    
    @Basic(optional = false)
    @Column(name = "NUMEROCNPJCPFPRESTADOR")
    private String numeroCnpjCpfPrestador;
    
    @Basic(optional = false)
    @Column(name = "INSCRICAOMUNICIPALPRESTADOR")
    private String inscricaoMunicipalPrestador;

    // TOMADOR
    @Basic(optional = false)
    @Column(name = "TIPODOCUMENTOTOMADOR")
    private String tipoDocumentoTomador;
    
    @Basic(optional = false)
    @Column(name = "NUMEROCNPJCPFTOMADOR")
    private String numeroCnpjCpfTomador;
    
    @Basic(optional = false)
    @Column(name = "INSCRICAOMUNICIPALTOMADOR")
    private String inscricaoMunicipalTomador;
    
    @Basic(optional = false)
    @Column(name = "RAZAOSOCIALTOMADOR")
    private String razaoSocialTomador;
    
    @Basic(optional = false)
    @Column(name = "ENDERECOTOMADOR")
    private String enderecoTomador;
    
    @Basic(optional = false)
    @Column(name = "NUMEROENDERECOTOMADOR")
    private String numeroEnderecoTomador;
    
    @Basic(optional = false)
    @Column(name = "COMPLEMENTOENDERECOTOMADOR")
    private String complementoEnderecoTomador;
    
    @Basic(optional = false)
    @Column(name = "BAIRROTOMADOR")
    private String bairroTomador;
    
    @Basic(optional = false)
    @Column(name = "CODIGOMUNICIPIOTOMADOR")
    private Integer codigoMunicipioTomador;
    
    @Basic(optional = false)
    @Column(name = "UFTOMADOR")
    private String ufTomador;
    
    @Basic(optional = false)
    @Column(name = "CODIGOPAISTOMADOR")
    private Integer codigoPaisTomador;
    
    @Basic(optional = false)
    @Column(name = "CEPTOMADOR")
    private String cepTomador;
    
    @Basic(optional = false)
    @Column(name = "TELEFONETOMADOR")
    private String telefoneTomador;
    
    @Basic(optional = false)
    @Column(name = "EMAILTOMADOR")
    private String emailTomador;

    //CONSTRUÇÃO CIVIL
    @Basic(optional = false)
    @Column(name = "CODIGOOBRA")
    private String codigoObra;
    
    @Basic(optional = false)
    @Column(name = "ARTOBRA")
    private String artObra;

    // OUTRAS INFORMAÇÕES
    @Basic(optional = false)
    @Column(name = "REGIMEESPECIALTRIBUTACAO")
    private Integer regimeEspecialTributacao;
    
    @Basic(optional = false)
    @Column(name = "OPTANTESIMPLESNACIONAL")
    private Integer optanteSimplesNacional;
    
    @Basic(optional = false)
    @Column(name = "INCENTIVOFISCAL")
    private Integer incentivoFiscal;
    
    @Basic(optional = false)
    @Column(name = "ISENVIADA")
    private Integer isEnviada;
    
    @Basic(optional = false)
    @Column(name = "NUMERONFSE")
    private String numeroNfse;
    
    @Basic(optional = false)
    @Column(name = "ISPROBLEMATICA")
    private Integer isProblematica;

    //Outros
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
    
    // LOTE
    @Basic(optional = false)
    @Column(name = "NUMEROLOTE")
    private Integer numeroLote;
    
    @Basic(optional = false)
    @Column(name = "NUMEROVENDA")
    private Integer numeroVenda;
    
    @Basic(optional = false)
    @Column(name = "CODIGOVERIFICACAONFSE")
    private String codigoVerificacaoNfse;
    
    @Basic(optional = false)
    @Column(name = "DATAEMISSAONFSE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataEmissaoNfse;
    
    @Basic(optional = false)
    @Column(name = "OUTRASINFORMACOESNFSE")
    private String outrasInformacoesNfse;
    
    @Basic(optional = false)
    @Column(name = "BASECALCULONFSE")
    private Double baseCalculoNfse;
    
    @Basic(optional = false)
    @Column(name = "VALORLIQUIDONFSE")
    private Double valorLiquidoNfse;
    
    @Basic(optional = false)
    @Column(name = "VALORCREDITONFSE")
    private Double valorCreditoNfse;
    
    @Basic(optional = false)
    @Column(name = "CODIGOMUNICIPIOGERADORNFSE")
    private Integer codigoMunicipioGeradorNfse;
    
    @Basic(optional = false)
    @Column(name = "UFORGAOGERADORNFSE")
    private String ufOrgaoGeradorNfse;
    
    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public Long getNumeroRps() {
        return numeroRps;
    }

    public void setNumeroRps(Long numeroRps) {
        this.numeroRps = numeroRps;
    }

    public String getSerieRps() {
        return serieRps;
    }

    public void setSerieRps(String serieRps) {
        this.serieRps = serieRps;
    }

    public String getTipoRps() {
        return tipoRps;
    }

    public void setTipoRps(String tipoRps) {
        this.tipoRps = tipoRps;
    }

    public Date getDataEmissaoRps() {
        return dataEmissaoRps;
    }

    public void setDataEmissaoRps(Date dataEmissaoRps) {
        this.dataEmissaoRps = dataEmissaoRps;
    }

    public Integer getStatusRps() {
        return statusRps;
    }

    public void setStatusRps(Integer statusRps) {
        this.statusRps = statusRps;
    }

    public Date getDataCompetenciaRps() {
        return dataCompetenciaRps;
    }

    public void setDataCompetenciaRps(Date dataCompetenciaRps) {
        this.dataCompetenciaRps = dataCompetenciaRps;
    }

    public Double getValorServicos() {
        return valorServicos;
    }

    public void setValorServicos(Double valorServicos) {
        this.valorServicos = valorServicos;
    }

    public Double getValorDeducoes() {
        return valorDeducoes;
    }

    public void setValorDeducoes(Double valorDeducoes) {
        this.valorDeducoes = valorDeducoes;
    }

    public Double getValorPis() {
        return valorPis;
    }

    public void setValorPis(Double valorPis) {
        this.valorPis = valorPis;
    }

    public Double getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(Double valorCofins) {
        this.valorCofins = valorCofins;
    }

    public Double getValorInss() {
        return valorInss;
    }

    public void setValorInss(Double valorInss) {
        this.valorInss = valorInss;
    }

    public Double getValorIr() {
        return valorIr;
    }

    public void setValorIr(Double valorIr) {
        this.valorIr = valorIr;
    }

    public Double getValorCsll() {
        return valorCsll;
    }

    public void setValorCsll(Double valorCsll) {
        this.valorCsll = valorCsll;
    }

    public Double getOutrasRetencoes() {
        return outrasRetencoes;
    }

    public void setOutrasRetencoes(Double outrasRetencoes) {
        this.outrasRetencoes = outrasRetencoes;
    }

    public Double getValorIss() {
        return valorIss;
    }

    public void setValorIss(Double valorIss) {
        this.valorIss = valorIss;
    }

    public Double getAliquota() {
        return aliquota;
    }

    public void setAliquota(Double aliquota) {
        this.aliquota = aliquota;
    }

    public Double getDescontoIncondicionado() {
        return descontoIncondicionado;
    }

    public void setDescontoIncondicionado(Double descontoIncondicionado) {
        this.descontoIncondicionado = descontoIncondicionado;
    }

    public Double getDescontoCondicionado() {
        return descontoCondicionado;
    }

    public void setDescontoCondicionado(Double descontoCondicionado) {
        this.descontoCondicionado = descontoCondicionado;
    }

    public Integer getIssRetido() {
        return issRetido;
    }

    public void setIssRetido(Integer issRetido) {
        this.issRetido = issRetido;
    }

    public Integer getResponsavelRetencao() {
        return responsavelRetencao;
    }

    public void setResponsavelRetencao(Integer responsavelRetencao) {
        this.responsavelRetencao = responsavelRetencao;
    }

    public String getItemListaServico() {
        return itemListaServico;
    }

    public void setItemListaServico(String itemListaServico) {
        this.itemListaServico = itemListaServico;
    }

    public Integer getCodigoCnae() {
        return codigoCnae;
    }

    public void setCodigoCnae(Integer codigoCnae) {
        this.codigoCnae = codigoCnae;
    }

    public String getCodigoTributacaoMunicipio() {
        return codigoTributacaoMunicipio;
    }

    public void setCodigoTributacaoMunicipio(String codigoTributacaoMunicipio) {
        this.codigoTributacaoMunicipio = codigoTributacaoMunicipio;
    }

    public String getDiscriminacaoServico() {
        return discriminacaoServico;
    }

    public void setDiscriminacaoServico(String discriminacaoServico) {
        this.discriminacaoServico = discriminacaoServico;
    }

    public Integer getCodigoMunicipioServico() {
        return codigoMunicipioServico;
    }

    public void setCodigoMunicipioServico(Integer codigoMunicipioServico) {
        this.codigoMunicipioServico = codigoMunicipioServico;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Integer getExigibilidadeIss() {
        return exigibilidadeIss;
    }

    public void setExigibilidadeIss(Integer exigibilidadeIss) {
        this.exigibilidadeIss = exigibilidadeIss;
    }

    public Integer getMunicipioIncidencia() {
        return municipioIncidencia;
    }

    public void setMunicipioIncidencia(Integer municipioIncidencia) {
        this.municipioIncidencia = municipioIncidencia;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getTipoDocumentoPrestador() {
        return tipoDocumentoPrestador;
    }

    public void setTipoDocumentoPrestador(String tipoDocumentoPrestador) {
        this.tipoDocumentoPrestador = tipoDocumentoPrestador;
    }

    public String getNumeroCnpjCpfPrestador() {
        return numeroCnpjCpfPrestador;
    }

    public void setNumeroCnpjCpfPrestador(String numeroCnpjCpfPrestador) {
        this.numeroCnpjCpfPrestador = numeroCnpjCpfPrestador;
    }

    public String getInscricaoMunicipalPrestador() {
        return inscricaoMunicipalPrestador;
    }

    public void setInscricaoMunicipalPrestador(String inscricaoMunicipalPrestador) {
        this.inscricaoMunicipalPrestador = inscricaoMunicipalPrestador;
    }

    public String getTipoDocumentoTomador() {
        return tipoDocumentoTomador;
    }

    public void setTipoDocumentoTomador(String tipoDocumentoTomador) {
        this.tipoDocumentoTomador = tipoDocumentoTomador;
    }

    public String getNumeroCnpjCpfTomador() {
        return numeroCnpjCpfTomador;
    }

    public void setNumeroCnpjCpfTomador(String numeroCnpjCpfTomador) {
        this.numeroCnpjCpfTomador = numeroCnpjCpfTomador;
    }

    public String getInscricaoMunicipalTomador() {
        return inscricaoMunicipalTomador;
    }

    public void setInscricaoMunicipalTomador(String inscricaoMunicipalTomador) {
        this.inscricaoMunicipalTomador = inscricaoMunicipalTomador;
    }

    public String getRazaoSocialTomador() {
        return razaoSocialTomador;
    }

    public void setRazaoSocialTomador(String razaoSocialTomador) {
        this.razaoSocialTomador = razaoSocialTomador;
    }

    public String getEnderecoTomador() {
        return enderecoTomador;
    }

    public void setEnderecoTomador(String enderecoTomador) {
        this.enderecoTomador = enderecoTomador;
    }

    public String getNumeroEnderecoTomador() {
        return numeroEnderecoTomador;
    }

    public void setNumeroEnderecoTomador(String numeroEnderecoTomador) {
        this.numeroEnderecoTomador = numeroEnderecoTomador;
    }

    public String getComplementoEnderecoTomador() {
        return complementoEnderecoTomador;
    }

    public void setComplementoEnderecoTomador(String complementoEnderecoTomador) {
        this.complementoEnderecoTomador = complementoEnderecoTomador;
    }

    public String getBairroTomador() {
        return bairroTomador;
    }

    public void setBairroTomador(String bairroTomador) {
        this.bairroTomador = bairroTomador;
    }

    public Integer getCodigoMunicipioTomador() {
        return codigoMunicipioTomador;
    }

    public void setCodigoMunicipioTomador(Integer codigoMunicipioTomador) {
        this.codigoMunicipioTomador = codigoMunicipioTomador;
    }

    public String getUfTomador() {
        return ufTomador;
    }

    public void setUfTomador(String ufTomador) {
        this.ufTomador = ufTomador;
    }

    public Integer getCodigoPaisTomador() {
        return codigoPaisTomador;
    }

    public void setCodigoPaisTomador(Integer codigoPaisTomador) {
        this.codigoPaisTomador = codigoPaisTomador;
    }

    public String getCepTomador() {
        return cepTomador;
    }

    public void setCepTomador(String cepTomador) {
        this.cepTomador = cepTomador;
    }

    public String getTelefoneTomador() {
        return telefoneTomador;
    }

    public void setTelefoneTomador(String telefoneTomador) {
        this.telefoneTomador = telefoneTomador;
    }

    public String getEmailTomador() {
        return emailTomador;
    }

    public void setEmailTomador(String emailTomador) {
        this.emailTomador = emailTomador;
    }

    public String getCodigoObra() {
        return codigoObra;
    }

    public void setCodigoObra(String codigoObra) {
        this.codigoObra = codigoObra;
    }

    public String getArtObra() {
        return artObra;
    }

    public void setArtObra(String artObra) {
        this.artObra = artObra;
    }

    public Integer getRegimeEspecialTributacao() {
        return regimeEspecialTributacao;
    }

    public void setRegimeEspecialTributacao(Integer regimeEspecialTributacao) {
        this.regimeEspecialTributacao = regimeEspecialTributacao;
    }

    public Integer getOptanteSimplesNacional() {
        return optanteSimplesNacional;
    }

    public void setOptanteSimplesNacional(Integer optanteSimplesNacional) {
        this.optanteSimplesNacional = optanteSimplesNacional;
    }

    public Integer getIncentivoFiscal() {
        return incentivoFiscal;
    }

    public void setIncentivoFiscal(Integer incentivoFiscal) {
        this.incentivoFiscal = incentivoFiscal;
    }

    public Integer getIsEnviada() {
        return isEnviada;
    }

    public void setIsEnviada(Integer isEnviada) {
        this.isEnviada = isEnviada;
    }

    public String getNumeroNfse() {
        return numeroNfse;
    }

    public void setNumeroNfse(String numeroNfse) {
        this.numeroNfse = numeroNfse;
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

    public Integer getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(Integer numeroLote) {
        this.numeroLote = numeroLote;
    }

    public Integer getNumeroVenda() {
        return numeroVenda;
    }

    public void setNumeroVenda(Integer numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    public String getCodigoVerificacaoNfse() {
        return codigoVerificacaoNfse;
    }

    public void setCodigoVerificacaoNfse(String codigoVerificacaoNfse) {
        this.codigoVerificacaoNfse = codigoVerificacaoNfse;
    }

    public Date getDataEmissaoNfse() {
        return dataEmissaoNfse;
    }

    public void setDataEmissaoNfse(Date dataEmissaoNfse) {
        this.dataEmissaoNfse = dataEmissaoNfse;
    }

    public String getOutrasInformacoesNfse() {
        return outrasInformacoesNfse;
    }

    public void setOutrasInformacoesNfse(String outrasInformacoesNfse) {
        this.outrasInformacoesNfse = outrasInformacoesNfse;
    }

    public Double getBaseCalculoNfse() {
        return baseCalculoNfse;
    }

    public void setBaseCalculoNfse(Double baseCalculoNfse) {
        this.baseCalculoNfse = baseCalculoNfse;
    }

    public Double getValorLiquidoNfse() {
        return valorLiquidoNfse;
    }

    public void setValorLiquidoNfse(Double valorLiquidoNfse) {
        this.valorLiquidoNfse = valorLiquidoNfse;
    }

    public Double getValorCreditoNfse() {
        return valorCreditoNfse;
    }

    public void setValorCreditoNfse(Double valorCreditoNfse) {
        this.valorCreditoNfse = valorCreditoNfse;
    }

    public Integer getCodigoMunicipioGeradorNfse() {
        return codigoMunicipioGeradorNfse;
    }

    public void setCodigoMunicipioGeradorNfse(Integer codigoMunicipioGeradorNfse) {
        this.codigoMunicipioGeradorNfse = codigoMunicipioGeradorNfse;
    }

    public String getUfOrgaoGeradorNfse() {
        return ufOrgaoGeradorNfse;
    }

    public void setUfOrgaoGeradorNfse(String ufOrgaoGeradorNfse) {
        this.ufOrgaoGeradorNfse = ufOrgaoGeradorNfse;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroRps != null ? numeroRps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Envio)) {
            return false;
        }
        Envio other = (Envio) object;
        return !((this.numeroRps == null && other.numeroRps != null) || (this.numeroRps != null && !this.numeroRps.equals(other.numeroRps)));
    }

    @Override
    public String toString() {
        return "org.linepack.nfsemaringa.model.Envio[ numeroRps=" + numeroRps + " ]";
    }

    public void print() {
        System.out.println(
         "Envio{" + " numeroRps=" + numeroRps + ", serieRps=" + serieRps + ", tipoRps=" + tipoRps + ", isEnviada=" + isEnviada + ", numeroNfse=" + numeroNfse + ", isProblematica=" + isProblematica + ", usuarioInsercao=" + usuarioInsercao + ", dataInsercao=" + dataInsercao + ", usuarioAlteracao=" + usuarioAlteracao + ", dataAlteracao=" + dataAlteracao + ", numeroLote=" + numeroLote + '}');
    }

    
}
