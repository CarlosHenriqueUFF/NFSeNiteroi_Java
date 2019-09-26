package webiss.niteroi.nfse.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-16T20:32:01")
@StaticMetamodel(Mensagem.class)
public class Mensagem_ { 

    public static volatile SingularAttribute<Mensagem, Long> id;
    public static volatile SingularAttribute<Mensagem, String> codigo;
    public static volatile SingularAttribute<Mensagem, String> acao;
    public static volatile SingularAttribute<Mensagem, Long> idEventoGerador;
    public static volatile SingularAttribute<Mensagem, Date> dataInsercao;
    public static volatile SingularAttribute<Mensagem, String> eventoGerador;
    public static volatile SingularAttribute<Mensagem, String> descricao;

}