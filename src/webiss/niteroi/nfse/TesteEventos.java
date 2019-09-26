/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import webiss.niteroi.nfse.DAO.ParametroDAO;
import webiss.niteroi.nfse.evento.Cancelar;
import webiss.niteroi.nfse.evento.ConsultarLote;
import webiss.niteroi.nfse.evento.EnviarLote;
import webiss.niteroi.nfse.evento.EnviarLoteSincrono;
import webiss.niteroi.nfse.evento.GerarNfse;
import webiss.niteroi.nfse.model.Parametro;
import webiss.niteroi.nfse.util.Conexao;
import org.xml.sax.SAXException;
import webiss.niteroi.nfse.model.Envio;
import webiss.niteroi.nfse.model.ListaNfseGeradas;
import webiss.niteroi.nfse.model.Venda;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public class TesteEventos {

    public static void main(String[] args) throws NoSuchAlgorithmException, JAXBException, InvalidAlgorithmParameterException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException, ParserConfigurationException, SAXException, MarshalException, XMLSignatureException, TransformerException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException, InstantiationException, Exception, Exception {
        Parametro parametros = new ParametroDAO().getByNamedQuery("parametroAtivo");
        if (parametros == null) {
            System.out.println("Não há parametros ATIVOS, verifique!");
        } else {
            Conexao conexao = new Conexao(parametros.getNomeCertificadoJKS(), parametros.getSenhaCertificado());
            //Métodos implementados
            Cancelar cancelar = new Cancelar(conexao);
            EnviarLote enviarLote = new EnviarLote(conexao);
            ConsultarLote consulta = new ConsultarLote(conexao);
            EnviarLoteSincrono enviar = new EnviarLoteSincrono(conexao);
            GerarNfse gerar = new GerarNfse(conexao);
            
            Venda venda = new Venda();
            venda.setBairroCliente("Itauna");
            venda.setCelularCliente("999999999");
            venda.setCepCliente("24000000");
            venda.setCidadeCliente("São Gonçalo");
            venda.setCodigoClienteFarmaFacil(1265);
            venda.setCodigoMunicipioCliente(9999999);
            venda.setCodigoTaxaEntrega(101);
            venda.setComplementoCliente("Vila Verde - casa 03");
            venda.setCpfCnpjCliente("11111111111");
            venda.setDataEmissaoVenda(new Date());
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, 3);
            venda.setDataPrevisaoEntrega(c.getTime());
            venda.setDddCelularCliente("21");
            venda.setDddTelefoneCliente("21");
            venda.setDiscrimincaoServicos("SHAMPOO SILIMARINA 1000ML 1 UN 129.00 - PAGAMENTO A VISTAS");
            venda.setEmailCliente("i@gmail.com");
            venda.setEnderecoCliente("Rua do ouvidor");
            venda.setEstadoCliente("RJ");
            venda.setLocalEntrega("LOJA");
            venda.setNomeCliente("Luana Nunes");
            venda.setNomeVendedor("Guilherme");
            venda.setNumeroEnderecoCliente("545");
            venda.setNumeroVenda(200908);
            venda.setObservacao("Entregar após as 14:00hs");
            venda.setOrcamentoVenda(false);
            venda.setProximidadeCliente("Ao lado do Salão da Majú");
            venda.setTelefoneCliente("34567890");
            venda.setValorAcrescimo(0);
            venda.setValorBruto(187.00);
            venda.setValorDesconto(12.00);
            venda.setValorEntrada(100.00);
            venda.setValorLiquido(175.00);
            venda.setValorTaxaEntrega(5.00);
            
            Venda venda2 = new Venda();
            venda2.setBairroCliente("Coelho");
            venda2.setCelularCliente("999999999");
            venda2.setCepCliente("24230000");
            venda2.setCidadeCliente("São Gonçalo");
            venda2.setCodigoClienteFarmaFacil(987);
            venda2.setCodigoMunicipioCliente(9999999);
            venda2.setCodigoTaxaEntrega(50);
            venda2.setComplementoCliente("APTO 402 BL 01");
            venda2.setCpfCnpjCliente("11111111111");
            venda2.setDataEmissaoVenda(new Date());
            Calendar c2 = Calendar.getInstance();
            c2.add(Calendar.DAY_OF_MONTH, 5);
            venda2.setDataPrevisaoEntrega(c2.getTime());
            venda2.setDddCelularCliente("21");
            venda2.setDddTelefoneCliente("21");
            venda2.setDiscrimincaoServicos("BISCOITO DE BOSHWELLA 90 UNIDADES SABOR CARNE - 230.00");
            venda2.setEmailCliente("c@hotmail.com.br");
            venda2.setEnderecoCliente("Estrada Juvenal de Andrade");
            venda2.setEstadoCliente("RJ");
            venda2.setLocalEntrega("COELHO");
            venda2.setNomeCliente("Tatiana Martins");
            venda2.setNomeVendedor("Rose");
            venda2.setNumeroEnderecoCliente("120");
            venda2.setNumeroVenda(200910);
            venda2.setObservacao("Pagamento em Cheque");
            venda2.setOrcamentoVenda(false);
            venda2.setProximidadeCliente("Ao lado do Posto de Gasolina");
            venda2.setTelefoneCliente("45678901");
            venda2.setValorAcrescimo(0);
            venda2.setValorBruto(230.00);
            venda2.setValorDesconto(0.00);
            venda2.setValorEntrada(0.00);
            venda2.setValorLiquido(230.00);
            venda2.setValorTaxaEntrega(5.00);
            
            List<Venda> vendas = new ArrayList<>();
            vendas.add(venda);
            vendas.add(venda2);
            
            ListaNfseGeradas listaNfse = enviar.gerar(vendas);
            if (listaNfse.getMensagemErro() != null){
                System.out.println("ERROR:");
                System.out.println(listaNfse.getMensagemErro());
            } else if (listaNfse.getListNfse() != null){
                for (Envio envio : listaNfse.getListNfse()){
                    System.out.println("************* NFSe salva com sucesso!!! ********************");
                    envio.print();
                }
            } else {
                System.out.println("Nenhum dado no objeto de retorno");
            }
            
        }
        
        //Método para ser executado para gerar o arquivo jssecacerts
        //InstallCert.main(new String[] {new String("homologacao.webiss.com.br") });
    }

}
