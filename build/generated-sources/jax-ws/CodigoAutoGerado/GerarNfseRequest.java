
package CodigoAutoGerado;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nfseCabecMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="nfseDadosMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
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
    "nfseCabecMsg",
    "nfseDadosMsg"
})
@XmlRootElement(name = "GerarNfseRequest")
public class GerarNfseRequest {

    protected String nfseCabecMsg;
    protected String nfseDadosMsg;

    /**
     * Obtém o valor da propriedade nfseCabecMsg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNfseCabecMsg() {
        return nfseCabecMsg;
    }

    /**
     * Define o valor da propriedade nfseCabecMsg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNfseCabecMsg(String value) {
        this.nfseCabecMsg = value;
    }

    /**
     * Obtém o valor da propriedade nfseDadosMsg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNfseDadosMsg() {
        return nfseDadosMsg;
    }

    /**
     * Define o valor da propriedade nfseDadosMsg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNfseDadosMsg(String value) {
        this.nfseDadosMsg = value;
    }

}
