/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public class Venda implements Serializable{
    //atributos não exibidos para os atendentes, somente uso interno
    private boolean orcamentoVenda;
    private double codigoTaxaEntrega;
    private String observacao;
    private String mensagemVenda;
    private double codigoClienteFarmaFacil;
    //Dados básicos da venda
    private double numeroVenda;
    private Date dataEmissaoVenda;
    private String localEntrega;
    //Valores da venda
    private double valorLiquido;
    private double valorBruto;
    private double valorDesconto;
    private double valorAcrescimo;
    private double valorEntrada;
    private double valorTaxaEntrega;
     private double percentualDesconto;
    //Dados do cliente
    private String nomeCliente;
    private String dddTelefoneCliente;
    private String telefoneCliente;
    private String dddCelularCliente;
    private String celularCliente;
    private String cpfCnpjCliente;
    private String emailCliente;
    private String inscricaoMunicipalCliente;
    private Integer codigoMunicipioCliente;
    //Endereço do cliente
    private String enderecoCliente;
    private String numeroEnderecoCliente;
    private String complementoCliente;
    private String cepCliente;
    private String proximidadeCliente;
    private String bairroCliente;
    private String cidadeCliente;
    private String estadoCliente;
    //Vendedor
    private String nomeVendedor;
    //Data de Entrega
    private Date dataPrevisaoEntrega;
    
    private String discrimincaoServicos;
    private String formaPagamento;
    
    private String serieRps;
    private String tipoRps;
    private int statusRps;
    private double aliquota;
    private int issRetido;
    private String itemListaServico;
    private Integer codigoCnae;
    private String codigoTributacaoMunicipio;
    private Integer codigoMunicipioServico;
    private int exigibilidadeIss;
    private Integer municipioIncidencia;
    private String tipoDocumentoPrestador;
    private String numeroCnpjCpfPrestador;
    private String inscricaoMunicipalPrestador;
    private int optanteSimplesNacional;
    private int incentivoFiscal;

    public Venda() {
    }

    public Date getDataPrevisaoEntrega() {
        return dataPrevisaoEntrega;
    }

    public void setDataPrevisaoEntrega(Date dataPrevisaoEntrega) {
        this.dataPrevisaoEntrega = dataPrevisaoEntrega;
    }
    
    public double getCodigoClienteFarmaFacil() {
        return codigoClienteFarmaFacil;
    }

    public void setCodigoClienteFarmaFacil(double codigoClienteFarmaFacil) {
        this.codigoClienteFarmaFacil = codigoClienteFarmaFacil;
    }
    
    public double getValorTaxaEntrega() {
        return valorTaxaEntrega;
    }

    public void setValorTaxaEntrega(double valorTaxaEntrega) {
        this.valorTaxaEntrega = valorTaxaEntrega;
    }
    
    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }
    
    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getValorAcrescimo() {
        return valorAcrescimo;
    }

    public void setValorAcrescimo(double valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    public String getLocalEntrega() {
        return localEntrega;
    }

    public void setLocalEntrega(String localEntrega) {
        this.localEntrega = localEntrega;
    }
    
    public double getNumeroVenda() {
        return numeroVenda;
    }
    
    public void setNumeroVenda(double numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    public Date getDataEmissaoVenda() {
        return dataEmissaoVenda;
    }

    public void setDataEmissaoVenda(Date dataEmissaoVenda) {
        this.dataEmissaoVenda = dataEmissaoVenda;
    }

    public boolean isOrcamentoVenda() {
        return orcamentoVenda;
    }

    public void setOrcamentoVenda(boolean orcamentoVenda) {
        this.orcamentoVenda = orcamentoVenda;
    }
    
    public void setOrcamentoVenda(int orcamentoVenda) {
        this.orcamentoVenda = orcamentoVenda != 0;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getCodigoTaxaEntrega() {
        return codigoTaxaEntrega;
    }

    public void setCodigoTaxaEntrega(double codigoTaxaEntrega) {
        this.codigoTaxaEntrega = codigoTaxaEntrega;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getNumeroEnderecoCliente() {
        return numeroEnderecoCliente;
    }

    public void setNumeroEnderecoCliente(String numeroEnderecoCliente) {
        this.numeroEnderecoCliente = numeroEnderecoCliente;
    }

    public String getComplementoCliente() {
        return complementoCliente;
    }

    public void setComplementoCliente(String complementoCliente) {
        this.complementoCliente = complementoCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public String getProximidadeCliente() {
        return proximidadeCliente;
    }

    public void setProximidadeCliente(String proximidadeCliente) {
        this.proximidadeCliente = proximidadeCliente;
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getDddTelefoneCliente() {
        return dddTelefoneCliente;
    }

    public void setDddTelefoneCliente(String dddTelefoneCliente) {
        this.dddTelefoneCliente = dddTelefoneCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getDddCelularCliente() {
        return dddCelularCliente;
    }

    public void setDddCelularCliente(String dddCelularCliente) {
        this.dddCelularCliente = dddCelularCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    public String getCpfCnpjCliente() {
        return cpfCnpjCliente;
    }

    public void setCpfCnpjCliente(String cpfCnpjCliente) {
        this.cpfCnpjCliente = cpfCnpjCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getMensagemVenda() {
        return mensagemVenda;
    }

    public void setMensagemVenda(String mensagemVenda) {
        this.mensagemVenda = mensagemVenda;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getInscricaoMunicipalCliente() {
        return inscricaoMunicipalCliente;
    }

    public void setInscricaoMunicipalCliente(String inscricaoMunicipalCliente) {
        this.inscricaoMunicipalCliente = inscricaoMunicipalCliente;
    }

    public Integer getCodigoMunicipioCliente() {
        return codigoMunicipioCliente;
    }

    public void setCodigoMunicipioCliente(Integer codigoMunicipioCliente) {
        this.codigoMunicipioCliente = codigoMunicipioCliente;
    }

    public String getDiscrimincaoServicos() {
        return discrimincaoServicos;
    }

    public void setDiscrimincaoServicos(String discrimincaoServicos) {
        this.discrimincaoServicos = discrimincaoServicos;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
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

    public int getStatusRps() {
        return statusRps;
    }

    public void setStatusRps(int statusRps) {
        this.statusRps = statusRps;
    }

    public double getAliquota() {
        return aliquota;
    }

    public void setAliquota(double aliquota) {
        this.aliquota = aliquota;
    }

    public int getIssRetido() {
        return issRetido;
    }

    public void setIssRetido(int issRetido) {
        this.issRetido = issRetido;
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

    public Integer getCodigoMunicipioServico() {
        return codigoMunicipioServico;
    }

    public void setCodigoMunicipioServico(Integer codigoMunicipioServico) {
        this.codigoMunicipioServico = codigoMunicipioServico;
    }

    public int getExigibilidadeIss() {
        return exigibilidadeIss;
    }

    public void setExigibilidadeIss(int exigibilidadeIss) {
        this.exigibilidadeIss = exigibilidadeIss;
    }

    public Integer getMunicipioIncidencia() {
        return municipioIncidencia;
    }

    public void setMunicipioIncidencia(Integer municipioIncidencia) {
        this.municipioIncidencia = municipioIncidencia;
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

    public int getOptanteSimplesNacional() {
        return optanteSimplesNacional;
    }

    public void setOptanteSimplesNacional(int optanteSimplesNacional) {
        this.optanteSimplesNacional = optanteSimplesNacional;
    }

    public int getIncentivoFiscal() {
        return incentivoFiscal;
    }

    public void setIncentivoFiscal(int incentivoFiscal) {
        this.incentivoFiscal = incentivoFiscal;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public void print(){
        
    }
    
    @Override
    public String toString() {
        return "VendaFarmaFacil{" + "numeroVenda=" + numeroVenda + "\n"
                + " dataEmissaoVenda=" + dataEmissaoVenda + "\n"
                + " orcamentoVenda=" + orcamentoVenda + "\n"
                + " valorBruto=" + valorBruto + "\n"
                + " valorAcrescimo=" + valorAcrescimo + "\n"
                + " valorDesconto=" + valorDesconto + "\n"
                + " valorEntrada=" +valorEntrada + "\n"
                + " valorTaxaEntrega=" + valorTaxaEntrega + "\n"
                + " percentualDesconto=" + percentualDesconto + "\n"
                + " valorLiquido=" + valorLiquido + "\n"
                + " observacao=" + observacao + "\n"
                + " codigoTaxaEntrega=" + codigoTaxaEntrega + "\n"
                + " localEntrega=" +localEntrega + "\n"
                + " codigoCliente=" + codigoClienteFarmaFacil + "\n"
                + " nomeCliente=" + nomeCliente + "\n"
                + " enderecoCliente=" + enderecoCliente + "\n"
                + " numeroEnderecoCliente=" + numeroEnderecoCliente + "\n"
                + " complementoCliente=" + complementoCliente + "\n"
                + " cepCliente=" + cepCliente + "\n"
                + " proximidadeCliente=" + proximidadeCliente + "\n"
                + " bairroCliente=" + bairroCliente + "\n"
                + " cidadeCliente=" + cidadeCliente + "\n"
                + " estadoCliente=" + estadoCliente + "\n"
                + " dddTelefoneCliente=" + dddTelefoneCliente + "\n"
                + " telefoneCliente=" + telefoneCliente + "\n"
                + " dddCelularCliente=" + dddCelularCliente + "\n"
                + " celularCliente=" + celularCliente + "\n"
                + " cpfCnpjCliente=" + cpfCnpjCliente + "\n"
                + " emailCliente=" + emailCliente + "\n"
                + " mensagemVenda=" + mensagemVenda + "\n"
                + " nomeVendedor=" + nomeVendedor + "\n"
                + " inscricaoMunicipalCliente=" + inscricaoMunicipalCliente + "\n"
                + " codigoMunicipioCliente=" + codigoMunicipioCliente + "\n"
                + " discrimincaoServicos=" + discrimincaoServicos + "\n"
                + " formaPagamento=" + formaPagamento + "\n"
                + " serieRps=" + serieRps + "\n"
                + " tipoRps=" + tipoRps + "\n"
                + " statusRps=" + statusRps + "\n"
                + " aliquota=" + aliquota + "\n"
                + " issRetido=" + issRetido + "\n"
                + " itemListaServico=" + itemListaServico + "\n"
                + " codigoCnae=" + codigoCnae + "\n"
                + " codigoTributacaoMunicipio=" + codigoTributacaoMunicipio + "\n"
                + " codigoMunicipioServico=" + codigoMunicipioServico + "\n"
                + " exigibilidadeIss=" + exigibilidadeIss + "\n"
                + " municipioIncidencia=" + municipioIncidencia + "\n"
                + " tipoDocumentoPrestador=" + tipoDocumentoPrestador + "\n"
                + " numeroCnpjCpfPrestador=" + numeroCnpjCpfPrestador + "\n"
                + " inscricaoMunicipalPrestador=" + inscricaoMunicipalPrestador + "\n"
                + " optanteSimplesNacional=" + optanteSimplesNacional + "\n"
                + " incentivoFiscal=" + incentivoFiscal + '}';
    }

}
