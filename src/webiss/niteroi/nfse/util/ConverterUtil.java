/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.util;

import java.text.Normalizer;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import webiss.niteroi.nfse.model.Envio;
import webiss.niteroi.nfse.model.Venda;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public class ConverterUtil {
    
    private static final int TAM_DISCRIMINACAO = 2000;
    private static final int TAM_RAZAO_SOCIAL_TOMADOR = 150;
    private static final int TAM_ENDERECO_TOMADOR = 125;
    private static final int TAM_NUMERO_ENDERECO = 10;
    private static final int TAM_COMPLEMENTO_ENDERECO = 60;
    private static final int TAM_BAIRRO_ENDERECO = 60;
    private static final int TAM_EMAIL_TOMADOR = 80;
    private static final int TAM_TELEFONE_TOMADOR = 20;
    
    public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
        return xgc.normalize();
    }
  
    public static Envio vendaToEnvio(Venda venda){
        Envio envio = new Envio();
        //Dados RPS
        envio.setSerieRps(venda.getSerieRps());
        envio.setTipoRps(venda.getTipoRps());
        envio.setStatusRps(venda.getStatusRps());
        envio.setAliquota(venda.getAliquota());
        envio.setIssRetido(venda.getIssRetido());
        envio.setValorIss((venda.getValorLiquido()*venda.getAliquota()));
        envio.setItemListaServico(venda.getItemListaServico());
        envio.setCodigoCnae(venda.getCodigoCnae());
        envio.setCodigoTributacaoMunicipio(venda.getCodigoTributacaoMunicipio());
        envio.setCodigoMunicipioServico(venda.getCodigoMunicipioServico());
        envio.setExigibilidadeIss(venda.getExigibilidadeIss());
        envio.setMunicipioIncidencia(venda.getMunicipioIncidencia());
        envio.setTipoDocumentoPrestador(venda.getTipoDocumentoPrestador());
        envio.setNumeroCnpjCpfPrestador(venda.getNumeroCnpjCpfPrestador());
        envio.setInscricaoMunicipalPrestador(venda.getInscricaoMunicipalPrestador());
        envio.setOptanteSimplesNacional(venda.getOptanteSimplesNacional());
        envio.setIncentivoFiscal(venda.getIncentivoFiscal());
        
        envio.setDataEmissaoRps(new Date());
        envio.setDataCompetenciaRps(new Date());
        envio.setValorServicos(venda.getValorLiquido());
        String discriminacao = venda.getDiscrimincaoServicos();
        if (venda.getValorDesconto() != 0){
            discriminacao = discriminacao + "\n * Desconto de R$ " + MyFormatter.doubleMoneyToString(venda.getValorDesconto());
        } else if (venda.getPercentualDesconto() != 0){
            discriminacao = discriminacao + "\n * Desconto de " + MyFormatter.doubleMoneyToString(venda.getPercentualDesconto()) +"%";
        }
        if (venda.getValorTaxaEntrega() != 0){
            discriminacao = discriminacao + "\n * Taxa de Entrega: " +MyFormatter.doubleMoneyToString(venda.getValorTaxaEntrega());
        }
        discriminacao = discriminacao + "\n * Forma de Pagamento: " + venda.getFormaPagamento();
        envio.setDiscriminacaoServico(ajustaTamanhoMaximo(discriminacao, TAM_DISCRIMINACAO));
        if (venda.getCpfCnpjCliente() != null){
            if (venda.getCpfCnpjCliente().trim().length() == 14){
                envio.setTipoDocumentoTomador("CNPJ");
            } else {
                envio.setTipoDocumentoTomador("CPF");
            }
        }
        envio.setNumeroCnpjCpfTomador(somenteNumeros(venda.getCpfCnpjCliente()));
        envio.setInscricaoMunicipalTomador(venda.getInscricaoMunicipalCliente());
        envio.setRazaoSocialTomador(ajustaTamanhoMaximo(venda.getNomeCliente(), TAM_RAZAO_SOCIAL_TOMADOR));
        envio.setEnderecoTomador(ajustaTamanhoMaximo(venda.getEnderecoCliente(), TAM_ENDERECO_TOMADOR));
        envio.setNumeroEnderecoTomador(ajustaTamanhoMaximo(venda.getNumeroEnderecoCliente(), TAM_NUMERO_ENDERECO));
        envio.setComplementoEnderecoTomador(ajustaTamanhoMaximo(venda.getComplementoCliente(), TAM_COMPLEMENTO_ENDERECO));
        envio.setBairroTomador(ajustaTamanhoMaximo(venda.getBairroCliente(), TAM_BAIRRO_ENDERECO));
        envio.setCodigoMunicipioTomador(venda.getCodigoMunicipioCliente());
        envio.setUfTomador(venda.getEstadoCliente());
        envio.setCepTomador(somenteNumeros(venda.getCepCliente()));
        String telefone = "";
        if (venda.getTelefoneCliente() != null){
            if(venda.getDddTelefoneCliente() != null){
                String ddd = venda.getDddTelefoneCliente();
                if (venda.getDddTelefoneCliente().substring(0, 1).equals("0")){
                    ddd = venda.getDddTelefoneCliente().substring(1);
                }
                telefone = ddd + venda.getTelefoneCliente();
            } else {
                telefone = venda.getTelefoneCliente();
            }
        } else if (venda.getCelularCliente() != null) {
            if (venda.getDddCelularCliente() != null) {
                String ddd = venda.getDddCelularCliente();
                if (venda.getDddCelularCliente().substring(0, 1).equals("0")){
                    ddd = venda.getDddCelularCliente().substring(1);
                }
                telefone = ddd + venda.getCelularCliente();
            } else {
                telefone = venda.getCelularCliente();
            }
        }
        envio.setTelefoneTomador(ajustaTamanhoMaximo(somenteNumeros(telefone), TAM_TELEFONE_TOMADOR));
        
        envio.setEmailTomador(ajustaTamanhoMaximo(extrairEmail(venda.getEmailCliente()), TAM_EMAIL_TOMADOR));
        envio.setUsuarioInsercao(venda.getNomeVendedor());
        //
        envio.setIsEnviada(0);
        envio.setIsProblematica(0);
        envio.setDataInsercao(new Date());
        //
        envio.setValorDeducoes(0.0);
        envio.setValorPis(0.0);
        envio.setValorCofins(0.0);
        envio.setValorIss(0.0);
        envio.setValorIr(0.0);
        envio.setValorCsll(0.0);
        envio.setOutrasRetencoes(0.0);
        envio.setDescontoCondicionado(0.0);
        envio.setDescontoIncondicionado(0.0);
        Formatter formatter = new Formatter();
        formatter.format("%.0f", venda.getNumeroVenda());
        envio.setNumeroVenda(Integer.valueOf(formatter.toString()));
        
        return envio;
    }
    
    private static String ajustaTamanhoMaximo(String value, int tam){
        if (value != null && value.length()>tam){
            value = value.substring(0, tam);
        }
        return removeAccents(value);
    }
    
    public static String removeAccents(String str) {
        if (str != null){
            str = Normalizer.normalize(str, Normalizer.Form.NFD);
            str = str.replaceAll("[^\\p{ASCII}]", "");
            str = str.toUpperCase();
        }
        return str;
    }
    
    public static String extrairEmail(String email) {
        String newEmail = null;
        if (email != null) {
            int posArroba = email.lastIndexOf("@");
            if (posArroba != -1) {
                int tam = email.length();
                int ini = posArroba;
                int fim = posArroba;
                char espaco = " ".charAt(0);
                while ((ini > 0) && (email.charAt(ini - 1) != espaco)) {
                    ini--;
                }
                while ((fim < (tam - 1)) && (email.charAt(fim + 1) != espaco)) {
                    fim++;
                }
                newEmail = email.substring(ini, fim + 1);
            }
        }
        return newEmail;
    }
    
    public static String somenteNumeros(String value){
        String numeros = "0123456789";
        if (value != null){
            String newValue = "";
            int tam = value.length();
            for (int i=0; i<tam; i++){
                String ch = value.substring(i, i+1);
                if (numeros.contains(ch)){
                    newValue = newValue + ch;
                }
            }
            return newValue;
        } else {
            return value;
        }
    }
}
