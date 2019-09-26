
package CodigoAutoGerado;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "NfseWSServiceSoap", targetNamespace = "http://nfse.abrasf.org.br/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface NfseWSServiceSoap {


    /**
     * 
     * @param parameters
     * @return
     *     returns CodigoAutoGerado.CancelarNfseResponse
     */
    @WebMethod(operationName = "CancelarNfse", action = "http://nfse.abrasf.org.br/CancelarNfse")
    @WebResult(name = "CancelarNfseResponse", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
    public CancelarNfseResponse cancelarNfse(
        @WebParam(name = "CancelarNfseRequest", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
        CancelarNfseRequest parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns CodigoAutoGerado.ConsultarLoteRpsResponse
     */
    @WebMethod(operationName = "ConsultarLoteRps", action = "http://nfse.abrasf.org.br/ConsultarLoteRps")
    @WebResult(name = "ConsultarLoteRpsResponse", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
    public ConsultarLoteRpsResponse consultarLoteRps(
        @WebParam(name = "ConsultarLoteRpsRequest", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
        ConsultarLoteRpsRequest parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns CodigoAutoGerado.ConsultarNfseServicoPrestadoResponse
     */
    @WebMethod(operationName = "ConsultarNfseServicoPrestado", action = "http://nfse.abrasf.org.br/ConsultarNfseServicoPrestado")
    @WebResult(name = "ConsultarNfseServicoPrestadoResponse", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
    public ConsultarNfseServicoPrestadoResponse consultarNfseServicoPrestado(
        @WebParam(name = "ConsultarNfseServicoPrestadoRequest", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
        ConsultarNfseServicoPrestadoRequest parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns CodigoAutoGerado.ConsultarNfseServicoTomadoResponse
     */
    @WebMethod(operationName = "ConsultarNfseServicoTomado", action = "http://nfse.abrasf.org.br/ConsultarNfseServicoTomado")
    @WebResult(name = "ConsultarNfseServicoTomadoResponse", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
    public ConsultarNfseServicoTomadoResponse consultarNfseServicoTomado(
        @WebParam(name = "ConsultarNfseServicoTomadoRequest", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
        ConsultarNfseServicoTomadoRequest parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns CodigoAutoGerado.ConsultarNfsePorFaixaResponse
     */
    @WebMethod(operationName = "ConsultarNfsePorFaixa", action = "http://nfse.abrasf.org.br/ConsultarNfsePorFaixa")
    @WebResult(name = "ConsultarNfsePorFaixaResponse", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
    public ConsultarNfsePorFaixaResponse consultarNfsePorFaixa(
        @WebParam(name = "ConsultarNfsePorFaixaRequest", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
        ConsultarNfsePorFaixaRequest parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns CodigoAutoGerado.ConsultarNfsePorRpsResponse
     */
    @WebMethod(operationName = "ConsultarNfsePorRps", action = "http://nfse.abrasf.org.br/ConsultarNfsePorRps")
    @WebResult(name = "ConsultarNfsePorRpsResponse", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
    public ConsultarNfsePorRpsResponse consultarNfsePorRps(
        @WebParam(name = "ConsultarNfsePorRpsRequest", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
        ConsultarNfsePorRpsRequest parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns CodigoAutoGerado.RecepcionarLoteRpsResponse
     */
    @WebMethod(operationName = "RecepcionarLoteRps", action = "http://nfse.abrasf.org.br/RecepcionarLoteRps")
    @WebResult(name = "RecepcionarLoteRpsResponse", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
    public RecepcionarLoteRpsResponse recepcionarLoteRps(
        @WebParam(name = "RecepcionarLoteRpsRequest", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
        RecepcionarLoteRpsRequest parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns CodigoAutoGerado.GerarNfseResponse
     */
    @WebMethod(operationName = "GerarNfse", action = "http://nfse.abrasf.org.br/GerarNfse")
    @WebResult(name = "GerarNfseResponse", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
    public GerarNfseResponse gerarNfse(
        @WebParam(name = "GerarNfseRequest", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
        GerarNfseRequest parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns CodigoAutoGerado.SubstituirNfseResponse
     */
    @WebMethod(operationName = "SubstituirNfse", action = "http://nfse.abrasf.org.br/SubstituirNfse")
    @WebResult(name = "SubstituirNfseResponse", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
    public SubstituirNfseResponse substituirNfse(
        @WebParam(name = "SubstituirNfseRequest", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
        SubstituirNfseRequest parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns CodigoAutoGerado.RecepcionarLoteRpsSincronoResponse
     */
    @WebMethod(operationName = "RecepcionarLoteRpsSincrono", action = "http://nfse.abrasf.org.br/RecepcionarLoteRpsSincrono")
    @WebResult(name = "RecepcionarLoteRpsSincronoResponse", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
    public RecepcionarLoteRpsSincronoResponse recepcionarLoteRpsSincrono(
        @WebParam(name = "RecepcionarLoteRpsSincronoRequest", targetNamespace = "http://nfse.abrasf.org.br/", partName = "parameters")
        RecepcionarLoteRpsSincronoRequest parameters);

}