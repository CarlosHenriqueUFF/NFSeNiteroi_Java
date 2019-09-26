package webiss.niteroi.nfse.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-16T20:32:01")
@StaticMetamodel(Cancelamento.class)
public class Cancelamento_ { 

    public static volatile SingularAttribute<Cancelamento, Long> id;
    public static volatile SingularAttribute<Cancelamento, String> xmlEnvio;
    public static volatile SingularAttribute<Cancelamento, Integer> codigoMunicipio;
    public static volatile SingularAttribute<Cancelamento, Date> dataInsercao;
    public static volatile SingularAttribute<Cancelamento, Integer> isCancelada;
    public static volatile SingularAttribute<Cancelamento, String> usuarioInsercao;
    public static volatile SingularAttribute<Cancelamento, BigInteger> numeroNota;
    public static volatile SingularAttribute<Cancelamento, String> xmlRetorno;
    public static volatile SingularAttribute<Cancelamento, Date> dataAlteracao;
    public static volatile SingularAttribute<Cancelamento, String> cnpj;
    public static volatile SingularAttribute<Cancelamento, String> usuarioAlteracao;
    public static volatile SingularAttribute<Cancelamento, Integer> isProblematica;
    public static volatile SingularAttribute<Cancelamento, String> inscricaoMunicipal;

}