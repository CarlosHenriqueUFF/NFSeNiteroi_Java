package webiss.niteroi.nfse.evento;

import CodigoAutoGerado.RecepcionarLoteRpsRequest;
import br.org.abrasf.nfse.EnviarLoteRpsResposta;
import br.org.abrasf.nfse.EnviarLoteRpsEnvio;
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
import java.util.Date;
import java.util.List;
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

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public class EnviarLote extends EventoModelo<Lote> {
    
    private final List<Envio> listEnvio;
    
    public EnviarLote(Conexao conexao) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException, ParserConfigurationException, SAXException, MarshalException, XMLSignatureException, TransformerException, JAXBException, NoSuchMethodException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        this.listEnvio = new EnvioDAO().getListByNamedQuery("enviosPendentes");
        if (!this.listEnvio.isEmpty()){
            this.objetoModelo = new Lote();
            this.objetoModelo.setIsEnviado(0);
            this.objetoModelo.setIsProblematico(0);
            this.objetoModelo.setDataHoraCriacao(new Date());
            this.objetoModelo = new LoteDAO().insertReturn(this.objetoModelo);
            if (this.objetoModelo != null){
                super.run(conexao);
            } else {
                System.out.println("O Lote de envio é nulo");
            }
        } else {
            System.out.println("Não existe Rps para ser enviada");
        }
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
                valores.setValorDeducoes(new BigDecimal(envio.getValorDeducoes()).setScale(2,BigDecimal.ROUND_HALF_UP));
                valores.setValorPis(new BigDecimal(envio.getValorPis()).setScale(2,BigDecimal.ROUND_HALF_UP));
                valores.setValorCofins(new BigDecimal(envio.getValorCofins()).setScale(2,BigDecimal.ROUND_HALF_UP));
                valores.setValorInss(new BigDecimal(envio.getValorInss()).setScale(2,BigDecimal.ROUND_HALF_UP));
                valores.setValorIr(new BigDecimal(envio.getValorIr()).setScale(2,BigDecimal.ROUND_HALF_UP));
                valores.setValorCsll(new BigDecimal(envio.getValorCsll()).setScale(2,BigDecimal.ROUND_HALF_UP));
                valores.setOutrasRetencoes(new BigDecimal(envio.getOutrasRetencoes()).setScale(2,BigDecimal.ROUND_HALF_UP));
                valores.setValorIss(new BigDecimal(envio.getValorIss()).setScale(2,BigDecimal.ROUND_HALF_UP));
                valores.setAliquota(new BigDecimal(envio.getAliquota()).setScale(2,BigDecimal.ROUND_HALF_UP));
                valores.setDescontoIncondicionado(new BigDecimal(envio.getDescontoIncondicionado()).setScale(2,BigDecimal.ROUND_HALF_UP));
                valores.setDescontoCondicionado(new BigDecimal(envio.getDescontoCondicionado()).setScale(2,BigDecimal.ROUND_HALF_UP));

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

            EnviarLoteRpsEnvio nfseEnvio = new EnviarLoteRpsEnvio();
            nfseEnvio.setLoteRps(loteRps);

            xml = MarshallerUtil.marshal(EnviarLoteRpsEnvio.class, nfseEnvio);
            
        } catch (DatatypeConfigurationException | JAXBException | IllegalArgumentException ex) {
            Logger.getLogger(EnviarLote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xml;
    }

    @Override
    protected String enviaXml(String xmlEnvio) {
        this.objetoModelo.setDataHoraEnvio(new Date());
        new LoteDAO().update(this.objetoModelo);
        RecepcionarLoteRpsRequest r = new RecepcionarLoteRpsRequest();
        r.setNfseCabecMsg(this.cabecMsg);
        r.setNfseDadosMsg(xmlEnvio);
        return super.getConnectionPort().recepcionarLoteRps(r).getOutputXML();
        //return null;
    }

    @Override
    protected ListaNfseGeradas retornaXml(String xmlRetorno) {
        System.out.println("xml retorno");
        System.out.println(xmlRetorno);
        try {
            EnviarLoteRpsResposta resposta = (EnviarLoteRpsResposta) UnmarshallerUtil.unmarshal(EnviarLoteRpsResposta.class, xmlRetorno);
            int problematica = 0;
            int enviada = 0;
            if (resposta.getListaMensagemRetorno() != null) {
                super.setMensagemRetorno(resposta.getListaMensagemRetorno().getMensagemRetorno(), "EnvioLote", this.objetoModelo.getNumero());
                this.objetoModelo.setIsProblematico(1);
                problematica = 1;
            } else {
                this.objetoModelo.setIsEnviado(1);
                this.objetoModelo.setProtocolo(resposta.getProtocolo());
                this.objetoModelo.setDataHoraRecebimento(resposta.getDataRecebimento().toGregorianCalendar().getTime());
                enviada =1;
            }
            new LoteDAO().update(this.objetoModelo);
            for (Envio envio: this.listEnvio){
                envio.setUsuarioAlteracao("CONECTOR");
                envio.setDataAlteracao(new Date());
                envio.setIsProblematica(problematica);
                envio.setIsEnviada(enviada);
                new EnvioDAO().update(envio);
            }
        } catch (JAXBException | IllegalArgumentException ex) {
            Logger.getLogger(EnviarLote.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
