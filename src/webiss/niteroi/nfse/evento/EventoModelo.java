/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.evento;

import CodigoAutoGerado.NfseWSService;
import CodigoAutoGerado.NfseWSServiceSoap;
import br.org.abrasf.nfse.TcMensagemRetorno;
import br.org.abrasf.nfse.TcMensagemRetornoLote;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import webiss.niteroi.nfse.DAO.DAOModelo;
import webiss.niteroi.nfse.DAO.MensagemDAO;
import webiss.niteroi.nfse.assinatura.AssinaturaDigital;
import webiss.niteroi.nfse.assinatura.CertificadoConfig;
import webiss.niteroi.nfse.assinatura.TipoCertificado;
import webiss.niteroi.nfse.model.Mensagem;
import webiss.niteroi.nfse.util.AssinadorXml;
import webiss.niteroi.nfse.util.Conexao;
import webiss.niteroi.nfse.util.NfseValidador;
import org.xml.sax.SAXException;
import webiss.niteroi.nfse.model.ListaNfseGeradas;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 * @param <T>
 */
public abstract class EventoModelo<T> {

    protected Boolean isSigned;
    protected T objetoModelo;
    protected String cabecMsg = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
      + "<cabecalho xmlns=\"http://www.abrasf.org.br/nfse.xsd\" versao=\"2.02\">"
      + "<versaoDados>2.02</versaoDados>"
      + "</cabecalho>";
    protected String versao = "2.02";

    public EventoModelo() {
        this.isSigned = true;
    }

    protected ListaNfseGeradas run(Conexao conexao) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException, ParserConfigurationException, SAXException, MarshalException, XMLSignatureException, TransformerException, JAXBException, NoSuchMethodException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        ListaNfseGeradas listaNfse = new ListaNfseGeradas();
        String xmlEnvio = this.formaXml(this.objetoModelo);
        System.out.println("xml original");
        System.out.println(xmlEnvio);
        System.out.println("");
        System.out.println("");
        boolean valido = true;
        try {
            new NfseValidador().from(xmlEnvio).validate();
        } catch (Exception e){
            valido = false;
            listaNfse.setMensagemErro("ERRO NA VALIDAÇÃO DO XML ASSINADO\n"+e.getMessage());
        }
        if (valido){
            if (isSigned) {
                CertificadoConfig.CertificadoConfigBuilder certificadoConfigBuilder = new CertificadoConfig.CertificadoConfigBuilder(TipoCertificado.A3_CARD, "12345678");
                CertificadoConfig certificadoConfig = new CertificadoConfig(certificadoConfigBuilder);
                AssinaturaDigital assinatura = new AssinaturaDigital(certificadoConfig);
                xmlEnvio = assinatura.assinarXML(xmlEnvio);
                System.out.println("xml assinado");
                System.out.println(xmlEnvio);
                System.out.println("");
                System.out.println("");
                try {
                    new NfseValidador().from(xmlEnvio).validate();
                } catch (Exception e){
                    valido = false;
                    listaNfse.setMensagemErro("ERRO NA VALIDAÇÃO DO XML\n"+e.getMessage());
                }
            }
            if (valido){
                atualizaXmlOrigem(xmlEnvio, "setXmlEnvio");
                String xmlRetorno = this.enviaXml(xmlEnvio);
                atualizaXmlOrigem(xmlRetorno, "setXmlRetorno");
                listaNfse = this.retornaXml(xmlRetorno);
            }
        }
        return listaNfse;
    }
    
    protected abstract String formaXml(T objetoModelo);
    
    protected String assinaXml(String xml, String tag, String keyStorePath, String password) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException, ParserConfigurationException, SAXException, MarshalException, XMLSignatureException, TransformerException, JAXBException {
        return AssinadorXml.getXmlAssinado(xml, tag, keyStorePath, password);
    }

    protected NfseWSServiceSoap getConnectionPort() {
        return new NfseWSService().getNfseWSServiceSoap();
    }

    protected abstract String enviaXml(String xmlEnvio);

    protected abstract ListaNfseGeradas retornaXml(String xmlRetorno);

    protected void setMensagemRetorno(List<TcMensagemRetorno> mensagens, String eventoGerador, Long idEventoGerador) {
        new MensagemDAO().deleteMensagensAnteriores(eventoGerador, idEventoGerador);
        for (TcMensagemRetorno mensagemRetorno : mensagens) {
            Mensagem mensagemModel = new Mensagem();
            mensagemModel.setEventoGerador(eventoGerador);
            mensagemModel.setIdEventoGerador(idEventoGerador);
            mensagemModel.setDataInsercao(new Date());
            mensagemModel.setCodigo(mensagemRetorno.getCodigo());
            mensagemModel.setDescricao(mensagemRetorno.getMensagem());
            mensagemModel.setAcao(mensagemRetorno.getCorrecao());
            new MensagemDAO().insert(mensagemModel);
        }
    }
    
    protected void setMensagemRetornoLote(List<TcMensagemRetornoLote> mensagens, String eventoGerador, Long idEventoGerador) {
        new MensagemDAO().deleteMensagensAnteriores(eventoGerador, idEventoGerador);
        for (TcMensagemRetornoLote mensagemRetorno : mensagens) {
            Mensagem mensagemModel = new Mensagem();
            mensagemModel.setEventoGerador(eventoGerador);
            mensagemModel.setIdEventoGerador(idEventoGerador);
            mensagemModel.setDataInsercao(new Date());
            mensagemModel.setCodigo(mensagemRetorno.getCodigo());
            mensagemModel.setDescricao(mensagemRetorno.getMensagem());
            String numero = String.valueOf(mensagemRetorno.getIdentificacaoRps().getNumero());
            String serie = mensagemRetorno.getIdentificacaoRps().getSerie();
            String tipo = String.valueOf(mensagemRetorno.getIdentificacaoRps().getTipo());
            String rps = "Numero: "+numero+" - Serie: "+serie+" - Tipo: "+tipo;
            mensagemModel.setAcao(rps);
            new MensagemDAO().insert(mensagemModel);
        }
    }
    
    protected void setMensagemAlertaRetorno(List<TcMensagemRetorno> mensagens, String eventoGerador, Long idEventoGerador) {
        new MensagemDAO().deleteMensagensAnteriores(eventoGerador, idEventoGerador);
        for (TcMensagemRetorno mensagemRetorno : mensagens) {
            Mensagem mensagemModel = new Mensagem();
            mensagemModel.setEventoGerador(eventoGerador);
            mensagemModel.setIdEventoGerador(idEventoGerador);
            mensagemModel.setDataInsercao(new Date());
            mensagemModel.setCodigo(mensagemRetorno.getCodigo());
            mensagemModel.setDescricao(mensagemRetorno.getMensagem());
            mensagemModel.setAcao(mensagemRetorno.getCorrecao());
            new MensagemDAO().insert(mensagemModel);
        }
    }

    /**
     *
     * @param xml
     * @param nomeMetodo must be setXmlEnvio or setXmlRetorno
     * @throws java.lang.NoSuchMethodException
     * @throws java.sql.SQLException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     */
    protected void atualizaXmlOrigem(String xml, String nomeMetodo) throws NoSuchMethodException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method metodo = this.objetoModelo.getClass().getMethod(nomeMetodo, String.class);
        metodo.invoke(this.objetoModelo, xml);
        DAOModelo daoModelo = new DAOModelo();
        String retorno = daoModelo.update(this.objetoModelo);
        System.out.println(nomeMetodo+": "+retorno);
        if (retorno != null){
            System.out.println("Erro ao executar método: "+nomeMetodo);
        }
    }

}
