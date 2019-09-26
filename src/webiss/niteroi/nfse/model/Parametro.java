package webiss.niteroi.nfse.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
@Entity
@Table(name = "PARAMETRO")
@XmlRootElement
@NamedQuery(name = "parametroAtivo", query = "SELECT p FROM Parametro p where p.isAtivo = 1")
public class Parametro implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "NOMECERTIFICADOJKS")
    private String nomeCertificadoJKS;
    
    @Basic(optional = false)
        @Column(name = "SENHACERTIFICADO")
    private String senhaCertificado;
    
    @Basic(optional = false)
    @Column(name = "ISATIVO")
    private Integer isAtivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(Integer isAtivo) {
        this.isAtivo = isAtivo;
    }

}
