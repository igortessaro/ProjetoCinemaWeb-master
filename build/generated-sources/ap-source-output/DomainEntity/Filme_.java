package DomainEntity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Filme.class)
public abstract class Filme_ {

	public static volatile SingularAttribute<Filme, String> sinopse;
	public static volatile CollectionAttribute<Filme, Secao> secaoCollection;
	public static volatile SingularAttribute<Filme, Integer> ano;
	public static volatile SingularAttribute<Filme, String> genero;
	public static volatile SingularAttribute<Filme, String> nome;
	public static volatile SingularAttribute<Filme, Integer> id;
	public static volatile SingularAttribute<Filme, String> diretor;

}

