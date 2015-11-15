package Repository;

import DomainEntity.Ingresso;
import Util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class IngressoRepository implements IGenericRepository<Ingresso>{
    @Override
    public void Insert(Ingresso entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (entity.getId() == null) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void Update(Ingresso entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (entity.getId() == null) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void Delete(Ingresso entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Ingresso> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Ingresso> ingressoList = em.createQuery("SELECT i FROM Ingresso i").getResultList();
        em.close();
        return (ingressoList);
    }
    
    public Ingresso obter(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Ingresso ingresso = em.find(Ingresso.class, id);
        em.close();
        return (ingresso);
    }
}
