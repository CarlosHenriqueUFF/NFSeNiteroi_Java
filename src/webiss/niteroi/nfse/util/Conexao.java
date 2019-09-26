/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public final class Conexao {

    private String nomeCertificadoJKS;
    private String senhaCertificado;
    
    public Conexao(String nomeCertificadoJKS, String senhaCertificado) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        this.nomeCertificadoJKS = nomeCertificadoJKS;
        this.senhaCertificado = senhaCertificado;
        this.certifica();
    }
    public void certifica() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        System.clearProperty("javax.net.ssl.keyStore");
        System.clearProperty("javax.net.ssl.keyStorePassword");
        System.clearProperty("javax.net.ssl.trustStore");

        /*System.setProperty("javax.net.ssl.keyStoreType", "JKS");
        System.setProperty("javax.net.ssl.keyStore", nomeCertificadoJKS);
        System.setProperty("javax.net.ssl.keyStorePassword", senhaCertificado);*/
        
        System.setProperty("javax.net.ssl.keyStoreType", "PKCS11");
        System.setProperty("javax.net.ssl.keyStoreProvider", "SunPKCS11-SmartCard"); // Tem q saber qual o provider dele (SmartCard, Safesig, etc).
        System.setProperty("javax.net.ssl.keyStore", "NONE");
        System.setProperty("javax.net.ssl.keyStorePassword", senhaCertificado);

        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStore", "jssecacerts");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");        
    }

    public String getNomeCertificadoJKS() {
        return nomeCertificadoJKS;
    }

    public void setNomeCertificadoJKS(String nomeCertificadoJKS) {
        this.nomeCertificadoJKS = nomeCertificadoJKS;
    }

    public String getSenhaCertificado() {
        return senhaCertificado;
    }

    public void setSenhaCertificado(String senhaCertificado) {
        this.senhaCertificado = senhaCertificado;
    }
    
    

}
