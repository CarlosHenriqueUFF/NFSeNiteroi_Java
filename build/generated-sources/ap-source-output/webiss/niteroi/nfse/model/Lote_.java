package webiss.niteroi.nfse.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-16T20:32:01")
@StaticMetamodel(Lote.class)
public class Lote_ { 

    public static volatile SingularAttribute<Lote, Integer> isProblematico;
    public static volatile SingularAttribute<Lote, String> xmlEnvio;
    public static volatile SingularAttribute<Lote, Date> dataHoraEnvio;
    public static volatile SingularAttribute<Lote, String> xmlRetorno;
    public static volatile SingularAttribute<Lote, String> protocolo;
    public static volatile SingularAttribute<Lote, Integer> isEnviado;
    public static volatile SingularAttribute<Lote, Date> dataHoraRecebimento;
    public static volatile SingularAttribute<Lote, Date> dataHoraCriacao;
    public static volatile SingularAttribute<Lote, Long> numero;

}