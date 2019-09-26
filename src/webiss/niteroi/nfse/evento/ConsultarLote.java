package webiss.niteroi.nfse.evento;

import CodigoAutoGerado.ConsultarLoteRpsRequest;
import br.org.abrasf.nfse.ConsultarLoteRpsResposta;
import br.org.abrasf.nfse.ConsultarLoteRpsEnvio;
import br.org.abrasf.nfse.TcCompNfse;
import br.org.abrasf.nfse.TcCpfCnpj;
import br.org.abrasf.nfse.TcIdentificacaoPrestador;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import webiss.niteroi.nfse.DAO.LoteDAO;
import webiss.niteroi.nfse.model.Lote;
import webiss.niteroi.nfse.util.Conexao;
import webiss.niteroi.nfse.util.MarshallerUtil;
import webiss.niteroi.nfse.util.UnmarshallerUtil;
import org.xml.sax.SAXException;
import webiss.niteroi.nfse.model.ListaNfseGeradas;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public class ConsultarLote extends EventoModelo<Lote> {
    
    private final List<Lote> listLote;
    
    public ConsultarLote(Conexao conexao) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException, ParserConfigurationException, SAXException, MarshalException, XMLSignatureException, TransformerException, JAXBException, NoSuchMethodException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        this.listLote = new LoteDAO().getListByNamedQuery("lotesEnviados");
        if (!this.listLote.isEmpty()){
            for (Lote lote : this.listLote){
                this.objetoModelo = lote;
                super.run(conexao);
            }
        } else {
            System.out.println("Não existe Lote para ser consultado");
        }
    }

    @Override
    protected String formaXml(Lote lote) {
        String xml = null;
        try {
                // PRESTADOR
            TcIdentificacaoPrestador prestador = new TcIdentificacaoPrestador();
            TcCpfCnpj cpfCnpjPrestador = new TcCpfCnpj();
            cpfCnpjPrestador.setCnpj("17268481000113");
            prestador.setCpfCnpj(cpfCnpjPrestador);
            prestador.setInscricaoMunicipal("1626688");
                
            ConsultarLoteRpsEnvio consulta = new ConsultarLoteRpsEnvio();
            consulta.setPrestador(prestador);
            consulta.setProtocolo(lote.getProtocolo());

            xml = MarshallerUtil.marshal(ConsultarLoteRpsEnvio.class, consulta);
            
        } catch (JAXBException | IllegalArgumentException ex) {
            Logger.getLogger(ConsultarLote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xml;
    }

    @Override
    protected String enviaXml(String xmlEnvio) {
        ConsultarLoteRpsRequest r = new ConsultarLoteRpsRequest();
        r.setNfseCabecMsg(this.cabecMsg);
        r.setNfseDadosMsg(xmlEnvio);
        return super.getConnectionPort().consultarLoteRps(r).getOutputXML();
        //return null;
    }

    @Override
    protected ListaNfseGeradas retornaXml(String xmlRetorno) {
        System.out.println("xml retorno");
        System.out.println(xmlRetorno);
        Map<Integer, BigInteger> map = new HashMap<>();
        try {
            ConsultarLoteRpsResposta resposta = (ConsultarLoteRpsResposta) UnmarshallerUtil.unmarshal(ConsultarLoteRpsResposta.class, xmlRetorno);
            
            switch (resposta.getSituacao()){
                case 1:
                    System.out.println("Lote: "+this.objetoModelo.getNumero() + " - Protocolo: " + this.objetoModelo.getProtocolo() + "Situação: Não Recebido");
                    break;
                case 2:
                    System.out.println("Lote: "+this.objetoModelo.getNumero() + " - Protocolo: " + this.objetoModelo.getProtocolo() + "Situação: Não Processado");
                    break;
                case 3:
                    System.out.println("Lote: "+this.objetoModelo.getNumero() + " - Protocolo: " + this.objetoModelo.getProtocolo() + "Situação: Processado com Erro");
                    break;
                case 4: 
                    System.out.println("Lote: "+this.objetoModelo.getNumero() + " - Protocolo: " + this.objetoModelo.getProtocolo() + "Situação: Processado com Sucesso");
                    break;
            }
            int problematica = 0;
            int enviada = 0;
            if (resposta.getListaMensagemRetorno() != null) {
                super.setMensagemRetorno(resposta.getListaMensagemRetorno().getMensagemRetorno(), "ConsultarLote", this.objetoModelo.getNumero());
                //this.objetoModelo.setIsProblematico(1);
                //problematica = 1;
            } else if (resposta.getListaMensagemRetornoLote() != null) {
                super.setMensagemRetornoLote(resposta.getListaMensagemRetornoLote().getMensagemRetorno(), "ConsultarLote", this.objetoModelo.getNumero());
                //this.objetoModelo.setIsProblematico(1);
                //problematica = 1;
            } else {
                //this.objetoModelo.setIsEnviado(1);
                //this.objetoModelo.setProtocolo(resposta.getProtocolo());
                //this.objetoModelo.setDataHoraRecebimento(resposta.getDataRecebimento().toGregorianCalendar().getTime());
                //enviada =1;
                
                List<TcCompNfse> listaNfse = (List<TcCompNfse>) resposta.getListaNfse().getCompNfse();
                if (listaNfse != null){
                    for (TcCompNfse tcCompNfse : listaNfse){
                        BigInteger numeroNfse = tcCompNfse.getNfse().getInfNfse().getNumero();
                        Integer numeroRps = tcCompNfse.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getRps().getIdentificacaoRps().getNumero().intValue();
                        map.put(numeroRps, numeroNfse);
                    }
                }
                
                if (resposta.getListaNfse().getListaMensagemAlertaRetorno() != null){
                    super.setMensagemAlertaRetorno(resposta.getListaNfse().getListaMensagemAlertaRetorno().getMensagemRetorno(), "EnvioLoteSincrono", this.objetoModelo.getNumero());
                }
            }
            
        } catch (JAXBException | IllegalArgumentException ex) {
            Logger.getLogger(ConsultarLote.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
