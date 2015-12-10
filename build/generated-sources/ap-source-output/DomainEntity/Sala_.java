package DomainEntity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sala.class)
public abstract class Sala_ {

	public static volatile SingularAttribute<Sala, Boolean> tresD;
	public static volatile CollectionAttribute<Sala, Secao> secaoCollection;
	public static volatile SingularAttribute<Sala, Integer> numero;
	public static volatile SingularAttribute<Sala, Integer> quantidadeAssentos;
	public static volatile SingularAttribute<Sala, Integer> id;

}

