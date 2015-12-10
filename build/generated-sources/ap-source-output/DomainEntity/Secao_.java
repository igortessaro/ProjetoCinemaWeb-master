package DomainEntity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Secao.class)
public abstract class Secao_ {

	public static volatile SingularAttribute<Secao, Filme> filmeId;
	public static volatile SingularAttribute<Secao, Date> dataHoraInicio;
	public static volatile SingularAttribute<Secao, Sala> salaId;
	public static volatile SingularAttribute<Secao, Integer> id;
	public static volatile CollectionAttribute<Secao, Ingresso> ingressoCollection;
	public static volatile SingularAttribute<Secao, Integer> tempoDuracaoMinutos;

}

