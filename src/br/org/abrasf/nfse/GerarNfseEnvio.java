//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.24 at 01:57:35 PM BRT 
//


package br.org.abrasf.nfse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rps" type="{http://www.abrasf.org.br/nfse.xsd}tcDeclaracaoPrestacaoServico"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rps"
})
@XmlRootElement(name = "GerarNfseEnvio")
public class GerarNfseEnvio {

    @XmlElement(name = "Rps", required = true)
    protected TcDeclaracaoPrestacaoServico rps;

    /**
     * Gets the value of the rps property.
     * 
     * @return
     *     possible object is
     *     {@link TcDeclaracaoPrestacaoServico }
     *     
     */
    public TcDeclaracaoPrestacaoServico getRps() {
        return rps;
    }

    /**
     * Sets the value of the rps property.
     * 
     * @param value
     *     allowed object is
     *     {@link TcDeclaracaoPrestacaoServico }
     *     
     */
    public void setRps(TcDeclaracaoPrestacaoServico value) {
        this.rps = value;
    }

}