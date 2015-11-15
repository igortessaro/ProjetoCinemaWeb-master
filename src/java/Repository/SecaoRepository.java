package Repository;

import DomainEntity.Secao;
import Util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class SecaoRepository implements IGenericRepository<Secao> {
    
    @Override
    public void Insert(Secao entity) {
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
    public void Update(Secao entity) {
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
    public void Delete(Secao entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Secao> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Secao> secaoList = em.createQuery("SELECT s FROM Secao s").getResultList();
        em.close();
        return (secaoList);
    }
    
    public Secao obter(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Secao secao = em.find(Secao.class, id);
        em.close();
        return (secao);
    }
}
