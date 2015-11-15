package Repository;

import DomainEntity.Sala;
import Util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class SalaRepository implements IGenericRepository<Sala>{

    @Override
    public void Insert(Sala entity) {
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
    public void Update(Sala entity) {
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
    public void Delete(Sala entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Sala> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Sala> salaList = em.createQuery("SELECT s FROM Sala s").getResultList();
        em.close();
        return (salaList);
    }
    
    public Sala obter(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Sala sala = em.find(Sala.class, id);
        em.close();
        return (sala);
    }
    
    public Sala obterPorNumero(int numero) {
        try {
            EntityManager em = JpaUtil.getEntityManager();
            Sala sala = (Sala) em.createNamedQuery("Sala.findByNumero")
                    .setParameter("numero", numero)
                    .getSingleResult();
            em.close();
            return (sala);
        } catch (Exception ex) {
            return null;
        }
    }
}
