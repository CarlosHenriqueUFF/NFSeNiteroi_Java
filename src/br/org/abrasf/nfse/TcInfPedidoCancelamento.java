//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.24 at 01:57:35 PM BRT 
//


package br.org.abrasf.nfse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tcInfPedidoCancelamento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tcInfPedidoCancelamento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentificacaoNfse" type="{http://www.abrasf.org.br/nfse.xsd}tcIdentificacaoNfse"/>
 *         &lt;element name="CodigoCancelamento" type="{http://www.abrasf.org.br/nfse.xsd}tsCodigoCancelamentoNfse" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.abrasf.org.br/nfse.xsd}tsIdTag" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcInfPedidoCancelamento", propOrder = {
    "identificacaoNfse",
    "codigoCancelamento"
})
public class TcInfPedidoCancelamento {

    @XmlElement(name = "IdentificacaoNfse", required = true)
    protected TcIdentificacaoNfse identificacaoNfse;
    @XmlElement(name = "CodigoCancelamento")
    protected Byte codigoCancelamento;
    @XmlAttribute(name = "Id")
    protected String id;

    /**
     * Gets the value of the identificacaoNfse property.
     * 
     * @return
     *     possible object is
     *     {@link TcIdentificacaoNfse }
     *     
     */
    public TcIdentificacaoNfse getIdentificacaoNfse() {
        return identificacaoNfse;
    }

    /**
     * Sets the value of the identificacaoNfse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TcIdentificacaoNfse }
     *     
     */
    public void setIdentificacaoNfse(TcIdentificacaoNfse value) {
        this.identificacaoNfse = value;
    }

    /**
     * Gets the value of the codigoCancelamento property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getCodigoCancelamento() {
        return codigoCancelamento;
    }

    /**
     * Sets the value of the codigoCancelamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setCodigoCancelamento(Byte value) {
        this.codigoCancelamento = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
