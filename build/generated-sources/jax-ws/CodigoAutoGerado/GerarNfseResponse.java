
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
 *         &lt;element name="outputXML" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
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
    "outputXML"
})
@XmlRootElement(name = "GerarNfseResponse")
public class GerarNfseResponse {

    protected String outputXML;

    /**
     * Obtém o valor da propriedade outputXML.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputXML() {
        return outputXML;
    }

    /**
     * Define o valor da propriedade outputXML.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputXML(String value) {
        this.outputXML = value;
    }

}
