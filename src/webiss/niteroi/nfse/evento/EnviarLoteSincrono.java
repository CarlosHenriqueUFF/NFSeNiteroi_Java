package webiss.niteroi.nfse.evento;

import CodigoAutoGerado.RecepcionarLoteRpsSincronoRequest;
import br.org.abrasf.nfse.EnviarLoteRpsSincronoResposta;
import br.org.abrasf.nfse.EnviarLoteRpsSincronoEnvio;
import br.org.abrasf.nfse.TcCompNfse;
import br.org.abrasf.nfse.TcContato;
import br.org.abrasf.nfse.TcCpfCnpj;
import br.org.abrasf.nfse.TcDadosConstrucaoCivil;
import br.org.abrasf.nfse.TcDadosServico;
import br.org.abrasf.nfse.TcDadosTomador;
import br.org.abrasf.nfse.TcDeclaracaoPrestacaoServico;
import br.org.abrasf.nfse.TcEndereco;
import br.org.abrasf.nfse.TcIdentificacaoPrestador;
import br.org.abrasf.nfse.TcIdentificacaoRps;
import br.org.abrasf.nfse.TcIdentificacaoTomador;
import br.org.abrasf.nfse.TcInfDeclaracaoPrestacaoServico;
import br.org.abrasf.nfse.TcInfRps;
import br.org.abrasf.nfse.TcLoteRps;
import br.org.abrasf.nfse.TcLoteRps.ListaRps;
import br.org.abrasf.nfse.TcMensagemRetorno;
import br.org.abrasf.nfse.TcMensagemRetornoLote;
import br.org.abrasf.nfse.TcValoresDeclaracaoServico;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import webiss.niteroi.nfse.DAO.EnvioDAO;
import webiss.niteroi.nfse.DAO.LoteDAO;
import webiss.niteroi.nfse.model.Envio;
import webiss.niteroi.nfse.model.Lote;
import webiss.niteroi.nfse.util.Conexao;
import webiss.niteroi.nfse.util.ConverterUtil;
import webiss.niteroi.nfse.util.MarshallerUtil;
import webiss.niteroi.nfse.util.UnmarshallerUtil;
import org.xml.sax.SAXException;
import webiss.niteroi.nfse.model.ListaNfseGeradas;
import webiss.niteroi.nfse.model.Venda;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public class EnviarLoteSincrono extends EventoModelo<Lote> {
    
    private List<Envio> listEnvio;
    private final Conexao conexao;
    
    public EnviarLoteSincrono(Conexao conexao) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException, ParserConfigurationException, SAXException, MarshalException, XMLSignatureException, TransformerException, JAXBException, NoSuchMethodException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        this.conexao = conexao;
    }
    
    public ListaNfseGeradas gerar(List<Venda> vendas){
        ListaNfseGeradas listaNfse = new ListaNfseGeradas();
        String msgErro = null;
        this.listEnvio = new ArrayList<>();
        if (vendas != null && !vendas.isEmpty()){
            for (Venda venda : vendas){
                Envio envio = ConverterUtil.vendaToEnvio(venda);
                envio = new EnvioDAO().insertReturn(envio);
                if (envio != null){
                    this.listEnvio.add(envio);
                }
            }
        }
        if (!this.listEnvio.isEmpty()){
            this.objetoModelo = new Lote();
            this.objetoModelo.setIsEnviado(0);
            this.objetoModelo.setIsProblematico(0);
            this.objetoModelo.setDataHoraCriacao(new Date());
            this.objetoModelo = new LoteDAO().insertReturn(this.objetoModelo);
            try {
                if (this.objetoModelo != null){
                    listaNfse = super.run(conexao);
                } else {
                    listaNfse.setMensagemErro("O Lote de envio criado é nulo");
                }
            } catch (InvalidAlgorithmParameterException ex) {
                Logger.getLogger(GerarNfse.class.getName()).log(Level.SEVERE, null, ex);
                msgErro = ex.getMessage();
                listaNfse.setMensagemErro(msgErro);
            } catch (KeyStoreException | IOException | CertificateException | UnrecoverableEntryException | ParserConfigurationException | SAXException | MarshalException | XMLSignatureException | TransformerException | JAXBException | NoSuchMethodException | SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(GerarNfse.class.getName()).log(Level.SEVERE, null, ex);
                msgErro = ex.getMessage();
                listaNfse.setMensagemErro(msgErro);
            } catch (Exception ex) {
                Logger.getLogger(GerarNfse.class.getName()).log(Level.SEVERE, null, ex);
                msgErro = ex.getMessage();
                listaNfse.setMensagemErro(msgErro);
            }
        } else {
            listaNfse.setMensagemErro(msgErro);
        }
        return  listaNfse;
    }

    @Override
    protected String formaXml(Lote lote) {
        String xml = null;
        ListaRps lista = new ListaRps();
        TcCpfCnpj cpfCnpjPrestador = new TcCpfCnpj();
        String inscricaoMunicipalPrestador = "";
        try {
            for (Envio envio: this.listEnvio){
                // RPS                                
                TcIdentificacaoRps identificacaoRps = new TcIdentificacaoRps();
                identificacaoRps.setNumero(BigInteger.valueOf(envio.getNumeroRps()));
                identificacaoRps.setSerie(envio.getSerieRps());
                identificacaoRps.setTipo(Byte.valueOf(envio.getTipoRps()));

                TcInfRps rps = new TcInfRps();
                rps.setIdentificacaoRps(identificacaoRps);
                rps.setDataEmissao(ConverterUtil.dateToXMLGregorianCalendar(envio.getDataEmissaoRps()));
                rps.setStatus(envio.getStatusRps().byteValue());

                // SERVIÇO
                TcValoresDeclaracaoServico valores = new TcValoresDeclaracaoServico();
                valores.setValorServicos(new BigDecimal(envio.getValorServicos()).setScale(2,BigDecimal.ROUND_HALF_UP));
                if (envio.getValorDeducoes() != null){
                    valores.setValorDeducoes(new BigDecimal(envio.getValorDeducoes()).setScale(2,BigDecimal.ROUND_HALF_UP));
                }
                if (envio.getValorPis() != null){
                    valores.setValorPis(new BigDecimal(envio.getValorPis()).setScale(2,BigDecimal.ROUND_HALF_UP));
                }
                if (envio.getValorCofins() != null){
                    valores.setValorCofins(new BigDecimal(envio.getValorCofins()).setScale(2,BigDecimal.ROUND_HALF_UP));
                }
                if (envio.getValorInss() != null){
                    valores.setValorInss(new BigDecimal(envio.getValorInss()).setScale(2,BigDecimal.ROUND_HALF_UP));
                }
                if (envio.getValorIr() != null){
                    valores.setValorIr(new BigDecimal(envio.getValorIr()).setScale(2,BigDecimal.ROUND_HALF_UP));
                }
                if (envio.getValorCsll() != null){
                    valores.setValorCsll(new BigDecimal(envio.getValorCsll()).setScale(2,BigDecimal.ROUND_HALF_UP));
                }
                if (envio.getOutrasRetencoes() != null){
                    valores.setOutrasRetencoes(new BigDecimal(envio.getOutrasRetencoes()).setScale(2,BigDecimal.ROUND_HALF_UP));
                }
                if (envio.getValorIss() != null){
                    valores.setValorIss(new BigDecimal(envio.getValorIss()).setScale(2,BigDecimal.ROUND_HALF_UP));
                }
                if (envio.getAliquota() != null){
                    valores.setAliquota(new BigDecimal(envio.getAliquota()).setScale(2,BigDecimal.ROUND_HALF_UP));
                }
                if (envio.getDescontoIncondicionado() != null){
                    valores.setDescontoIncondicionado(new BigDecimal(envio.getDescontoIncondicionado()).setScale(2,BigDecimal.ROUND_HALF_UP));
                }
                if (envio.getDescontoCondicionado() != null){
                    valores.setDescontoCondicionado(new BigDecimal(envio.getDescontoCondicionado()).setScale(2,BigDecimal.ROUND_HALF_UP));
                }

                TcDadosServico servico = new TcDadosServico();
                servico.setValores(valores);
                if (envio.getIssRetido() != null){
                    servico.setIssRetido(envio.getIssRetido().byteValue());
                }
                if (envio.getResponsavelRetencao() != null){
                    servico.setResponsavelRetencao(envio.getResponsavelRetencao().byteValue());
                }
                servico.setItemListaServico(envio.getItemListaServico());
                servico.setCodigoCnae(envio.getCodigoCnae());
                servico.setCodigoTributacaoMunicipio(envio.getCodigoTributacaoMunicipio());
                servico.setDiscriminacao(envio.getDiscriminacaoServico());
                servico.setCodigoMunicipio(envio.getCodigoMunicipioServico());
                servico.setCodigoPais(envio.getCodigoPais());
                servico.setExigibilidadeISS(envio.getExigibilidadeIss().byteValue());
                servico.setMunicipioIncidencia(envio.getMunicipioIncidencia());
                servico.setNumeroProcesso(envio.getNumeroProcesso());

                // PRESTADOR
                TcIdentificacaoPrestador prestador = new TcIdentificacaoPrestador();
                cpfCnpjPrestador = new TcCpfCnpj();
                if (envio.getTipoDocumentoPrestador().trim().equalsIgnoreCase("CPF")) {
                    cpfCnpjPrestador.setCpf(envio.getNumeroCnpjCpfPrestador());
                } else {
                    cpfCnpjPrestador.setCnpj(envio.getNumeroCnpjCpfPrestador());
                }
                prestador.setCpfCnpj(cpfCnpjPrestador);
                prestador.setInscricaoMunicipal(envio.getInscricaoMunicipalPrestador());
                inscricaoMunicipalPrestador = envio.getInscricaoMunicipalPrestador();

                // TOMADOR
                TcIdentificacaoTomador idTomador = new TcIdentificacaoTomador();
                TcCpfCnpj cpfCnpjTomador = new TcCpfCnpj();
                if (envio.getTipoDocumentoTomador().trim().equalsIgnoreCase("CPF")) {
                    cpfCnpjTomador.setCpf(envio.getNumeroCnpjCpfTomador());
                } else {
                    cpfCnpjTomador.setCnpj(envio.getNumeroCnpjCpfTomador());
                }
                idTomador.setCpfCnpj(cpfCnpjTomador);
                idTomador.setInscricaoMunicipal(envio.getInscricaoMunicipalTomador());
                
                TcDadosTomador tomador = new TcDadosTomador();
                tomador.setIdentificacaoTomador(idTomador);
                tomador.setRazaoSocial(envio.getRazaoSocialTomador());

                TcEndereco endereco = new TcEndereco();
                endereco.setEndereco(envio.getEnderecoTomador());
                endereco.setNumero(envio.getNumeroEnderecoTomador());
                endereco.setComplemento(envio.getComplementoEnderecoTomador());
                endereco.setBairro(envio.getBairroTomador());
                endereco.setCodigoMunicipio(envio.getCodigoMunicipioTomador());
                endereco.setUf(envio.getUfTomador());
                endereco.setCodigoPais(envio.getCodigoPais());
                endereco.setCep(envio.getCepTomador());

                tomador.setEndereco(endereco);

                TcContato contato = new TcContato();
                contato.setTelefone(envio.getTelefoneTomador());
                contato.setEmail(envio.getEmailTomador());

                tomador.setContato(contato);

                // GERAL
                TcInfDeclaracaoPrestacaoServico inf = new TcInfDeclaracaoPrestacaoServico();
                inf.setId("Rps"+envio.getNumeroRps().toString());
                inf.setRps(rps);
                inf.setCompetencia(ConverterUtil.dateToXMLGregorianCalendar(envio.getDataCompetenciaRps()));
                System.out.println(inf.getCompetencia().toString());
                System.out.println(inf.getCompetencia().toXMLFormat());
                inf.setServico(servico);
                inf.setPrestador(prestador);
                inf.setTomador(tomador);

                // CONSTRUÇÃO CIVIL            
                if (envio.getCodigoObra() != null) {
                    TcDadosConstrucaoCivil civil = new TcDadosConstrucaoCivil();
                    civil.setCodigoObra(envio.getCodigoObra());
                    civil.setArt(envio.getArtObra());
                    inf.setConstrucaoCivil(civil);
                }

                if (envio.getRegimeEspecialTributacao() != null) {
                    inf.setRegimeEspecialTributacao(envio.getRegimeEspecialTributacao().byteValue());
                }
                inf.setOptanteSimplesNacional(envio.getOptanteSimplesNacional().byteValue());
                inf.setIncentivoFiscal(envio.getIncentivoFiscal().byteValue());

                TcDeclaracaoPrestacaoServico declaracao = new TcDeclaracaoPrestacaoServico();
                declaracao.setInfDeclaracaoPrestacaoServico(inf);

                lista.getRps().add(declaracao);
                
                envio.setNumeroLote(lote.getNumero().intValue());
                new EnvioDAO().update(envio);
            }
                //Lote RPS
            TcLoteRps loteRps = new TcLoteRps();
            loteRps.setCpfCnpj(cpfCnpjPrestador);
            loteRps.setId("Lote"+lote.getNumero().toString());
            loteRps.setInscricaoMunicipal(inscricaoMunicipalPrestador);
            BigInteger bi = BigInteger.valueOf(lote.getNumero());
            loteRps.setNumeroLote(bi);
            loteRps.setQuantidadeRps(this.listEnvio.size());
            loteRps.setVersao(this.versao);
            loteRps.setListaRps(lista);

            EnviarLoteRpsSincronoEnvio nfseEnvio = new EnviarLoteRpsSincronoEnvio();
            nfseEnvio.setLoteRps(loteRps);

            xml = MarshallerUtil.marshal(EnviarLoteRpsSincronoEnvio.class, nfseEnvio);
            
        } catch (DatatypeConfigurationException | JAXBException | IllegalArgumentException ex) {
            Logger.getLogger(EnviarLoteSincrono.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xml;
    }

    @Override
    protected String enviaXml(String xmlEnvio) {
        this.objetoModelo.setDataHoraEnvio(new Date());
        new LoteDAO().update(this.objetoModelo);
        RecepcionarLoteRpsSincronoRequest r = new RecepcionarLoteRpsSincronoRequest();
        r.setNfseCabecMsg(this.cabecMsg);
        r.setNfseDadosMsg(xmlEnvio);
        return super.getConnectionPort().recepcionarLoteRpsSincrono(r).getOutputXML();
        //return null;
    }

    @Override
    protected ListaNfseGeradas retornaXml(String xmlRetorno) {
        ListaNfseGeradas listaNfse = new ListaNfseGeradas();
        System.out.println("xml retorno");
        System.out.println(xmlRetorno);
        Map<Long, TcCompNfse> map = new HashMap<>();
        try {
            EnviarLoteRpsSincronoResposta resposta = (EnviarLoteRpsSincronoResposta) UnmarshallerUtil.unmarshal(EnviarLoteRpsSincronoResposta.class, xmlRetorno);
            int problematica = 0;
            int enviada = 0;
            if (resposta.getListaMensagemRetorno() != null) {
                super.setMensagemRetorno(resposta.getListaMensagemRetorno().getMensagemRetorno(), "EnvioLoteSincrono", this.objetoModelo.getNumero());
                this.objetoModelo.setIsProblematico(1);
                problematica = 1;
                String mensagem = "";
                for (TcMensagemRetorno msg : resposta.getListaMensagemRetorno().getMensagemRetorno()){
                    mensagem = mensagem + "\n" + "Mensagem: " + msg.getMensagem() + " - Correção: " + msg.getCorrecao();
                }
                listaNfse.setMensagemErro(mensagem);
            } else if (resposta.getListaMensagemRetornoLote() != null) {
                super.setMensagemRetornoLote(resposta.getListaMensagemRetornoLote().getMensagemRetorno(), "EnvioLoteSincrono", this.objetoModelo.getNumero());
                this.objetoModelo.setIsProblematico(1);
                problematica = 1;
                String mensagem = "";
                for (TcMensagemRetornoLote msg : resposta.getListaMensagemRetornoLote().getMensagemRetorno()){
                    mensagem = mensagem + "\n" + msg.getMensagem();
                }
                listaNfse.setMensagemErro(mensagem);
            } else {
                this.objetoModelo.setIsEnviado(1);
                this.objetoModelo.setProtocolo(resposta.getProtocolo());
                this.objetoModelo.setDataHoraRecebimento(resposta.getDataRecebimento().toGregorianCalendar().getTime());
                enviada =1;
                
                List<TcCompNfse> listaNfseGerada = resposta.getListaNfse().getCompNfse();
                if (listaNfseGerada != null){
                    for (TcCompNfse tcCompNfse : listaNfseGerada){
                        Long numeroRps = tcCompNfse.getNfse().getInfNfse().getDeclaracaoPrestacaoServico().getInfDeclaracaoPrestacaoServico().getRps().getIdentificacaoRps().getNumero().longValue();
                        map.put(numeroRps, tcCompNfse);
                    }
                }
                
                if (resposta.getListaNfse().getListaMensagemAlertaRetorno() != null){
                    super.setMensagemAlertaRetorno(resposta.getListaNfse().getListaMensagemAlertaRetorno().getMensagemRetorno(), "EnvioLoteSincrono", this.objetoModelo.getNumero());
                }
            }
            new LoteDAO().update(this.objetoModelo);
            for (Envio envio: this.listEnvio){
                envio.setUsuarioAlteracao("CONECTOR");
                envio.setDataAlteracao(new Date());
                envio.setIsProblematica(problematica);
                envio.setIsEnviada(enviada);
                if (map.containsKey(envio.getNumeroRps())){
                    TcCompNfse tcCompNfse = map.get(envio.getNumeroRps());
                    envio.setNumeroNfse(String.valueOf(tcCompNfse.getNfse().getInfNfse().getNumero()));
                    envio.setAliquota(tcCompNfse.getNfse().getInfNfse().getValoresNfse().getAliquota().doubleValue());
                    envio.setValorIss(tcCompNfse.getNfse().getInfNfse().getValoresNfse().getValorIss().doubleValue());
                    envio.setCodigoVerificacaoNfse(tcCompNfse.getNfse().getInfNfse().getCodigoVerificacao());
                    envio.setDataEmissaoNfse(tcCompNfse.getNfse().getInfNfse().getDataEmissao().toGregorianCalendar().getTime());
                    envio.setOutrasInformacoesNfse(tcCompNfse.getNfse().getInfNfse().getOutrasInformacoes());
                    envio.setBaseCalculoNfse(tcCompNfse.getNfse().getInfNfse().getValoresNfse().getBaseCalculo().doubleValue());
                    envio.setValorLiquidoNfse(tcCompNfse.getNfse().getInfNfse().getValoresNfse().getValorLiquidoNfse().doubleValue());
                    if (tcCompNfse.getNfse().getInfNfse().getValorCredito() != null){
                        envio.setValorCreditoNfse(tcCompNfse.getNfse().getInfNfse().getValorCredito().doubleValue());
                    }
                    envio.setCodigoMunicipioGeradorNfse(tcCompNfse.getNfse().getInfNfse().getOrgaoGerador().getCodigoMunicipio());
                    envio.setUfOrgaoGeradorNfse(tcCompNfse.getNfse().getInfNfse().getOrgaoGerador().getUf());
                }
                new EnvioDAO().update(envio);
                listaNfse.addEnvio(envio);
            }
        } catch (JAXBException | IllegalArgumentException ex) {
            Logger.getLogger(EnviarLoteSincrono.class
                    .getName()).log(Level.SEVERE, null, ex);
            listaNfse.setMensagemErro(""+ex.getMessage());
        }
        return listaNfse;
    }

}
