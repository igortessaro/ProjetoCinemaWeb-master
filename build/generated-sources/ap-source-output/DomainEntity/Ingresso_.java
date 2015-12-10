package DomainEntity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ingresso.class)
public abstract class Ingresso_ {

	public static volatile SingularAttribute<Ingresso, Date> dataHoraCompra;
	public static volatile SingularAttribute<Ingresso, BigDecimal> valor;
	public static volatile SingularAttribute<Ingresso, Integer> id;
	public static volatile SingularAttribute<Ingresso, Secao> secaoId;

}

