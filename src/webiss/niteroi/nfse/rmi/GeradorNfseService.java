/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.rmi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import webiss.niteroi.nfse.DAO.ParametroDAO;
import webiss.niteroi.nfse.evento.EnviarLoteSincrono;
import webiss.niteroi.nfse.evento.GerarNfse;
import webiss.niteroi.nfse.model.ListaNfseGeradas;
import webiss.niteroi.nfse.model.Parametro;
import webiss.niteroi.nfse.model.Venda;
import webiss.niteroi.nfse.util.Conexao;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public class GeradorNfseService extends UnicastRemoteObject implements GeradorNfseRemote {
    
    public GeradorNfseService() throws RemoteException{}

    @Override
    public ListaNfseGeradas gerarNotaFiscal(Venda venda) throws RemoteException {
        Parametro parametros;
        Conexao conexao;
        ListaNfseGeradas listaNfse = new ListaNfseGeradas();
        try {
            parametros = new ParametroDAO().getByNamedQuery("parametroAtivo");
        } catch (InstantiationException | IllegalAccessException ex) {
            listaNfse.setMensagemErro(ex.getMessage());
            parametros = null;
            Logger.getLogger(GeradorNfseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (parametros == null) {
            System.out.println("Não há parametros ATIVOS, verifique!");
            listaNfse.setMensagemErro("Não há parametros ATIVOS, verifique!\n"+listaNfse.getMensagemErro());
        } else {
            try {
                conexao = new Conexao(parametros.getNomeCertificadoJKS(), parametros.getSenhaCertificado());
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                listaNfse.setMensagemErro(ex.getMessage());
                conexao = null;
                Logger.getLogger(GeradorNfseService.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            GerarNfse gerar = null;
            try {
                if (conexao != null){
                    gerar = new GerarNfse(conexao);
                } else {
                    listaNfse.setMensagemErro("Conexao nula\n"+listaNfse.getMensagemErro());
                }
            } catch (InvalidAlgorithmParameterException ex) {
                listaNfse.setMensagemErro(ex.getMessage());
                Logger.getLogger(GeradorNfseService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (KeyStoreException | IOException | CertificateException | UnrecoverableEntryException | ParserConfigurationException | SAXException | javax.xml.crypto.MarshalException | XMLSignatureException | TransformerException | JAXBException | NoSuchMethodException | SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                listaNfse.setMensagemErro(ex.getMessage());
                Logger.getLogger(GeradorNfseService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                listaNfse.setMensagemErro(ex.getMessage());
                Logger.getLogger(GeradorNfseService.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (gerar != null){
                listaNfse = gerar.gerar(venda);
            } else {
                listaNfse.setMensagemErro("Objeto gerar é nulo\n"+listaNfse.getMensagemErro());
            }
         
        }
        return listaNfse;
    }

    @Override
    public ListaNfseGeradas gerarNotaFiscalEmLote(List<Venda> vendas) throws RemoteException {
        Parametro parametros;
        Conexao conexao;
        ListaNfseGeradas listaNfse = new ListaNfseGeradas();
        try {
            parametros = new ParametroDAO().getByNamedQuery("parametroAtivo");
        } catch (InstantiationException | IllegalAccessException ex) {
            listaNfse.setMensagemErro(ex.getMessage());
            parametros = null;
            Logger.getLogger(GeradorNfseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (parametros == null) {
            System.out.println("Não há parametros ATIVOS, verifique!");
            listaNfse.setMensagemErro("Não há parametros ATIVOS, verifique!\n"+listaNfse.getMensagemErro());
        } else {
            try {
                conexao = new Conexao(parametros.getNomeCertificadoJKS(), parametros.getSenhaCertificado());
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                listaNfse.setMensagemErro(ex.getMessage());
                conexao = null;
                Logger.getLogger(GeradorNfseService.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            EnviarLoteSincrono enviarLote = null;
            try {
                if (conexao != null){
                    enviarLote = new EnviarLoteSincrono(conexao);
                } else {
                    listaNfse.setMensagemErro("Conexao nula\n"+listaNfse.getMensagemErro());
                }
            } catch (InvalidAlgorithmParameterException ex) {
                listaNfse.setMensagemErro(ex.getMessage());
                Logger.getLogger(GeradorNfseService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (KeyStoreException | IOException | CertificateException | UnrecoverableEntryException | ParserConfigurationException | SAXException | javax.xml.crypto.MarshalException | XMLSignatureException | TransformerException | JAXBException | NoSuchMethodException | SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                listaNfse.setMensagemErro(ex.getMessage());
                Logger.getLogger(GeradorNfseService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                listaNfse.setMensagemErro(ex.getMessage());
                Logger.getLogger(GeradorNfseService.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (enviarLote != null){
                listaNfse = enviarLote.gerar(vendas);
            } else {
                listaNfse.setMensagemErro("Objeto gerar é nulo\n"+listaNfse.getMensagemErro());
            }
         
        }
        return listaNfse;
    }
    
    /**
     * @param args the command line arguments
    */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Iniciando o rmiregistry...");
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("rmiregistry iniciado como sucesso!");
        } catch (RemoteException ex) {
            System.err.println("Erro ao iniciar o rmiregistry.");
            Logger.getLogger(GeradorNfseRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Iniciando o servidor...");
        try {
            GeradorNfseRemote service = new GeradorNfseService();
            Naming.rebind("RemoteNfse", service);
            System.out.println("Servidor iniciado como sucesso!");
        } catch (RemoteException | MalformedURLException ex) {
            System.err.println("Erro ao iniciar o servidor.");
            Logger.getLogger(GeradorNfseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
