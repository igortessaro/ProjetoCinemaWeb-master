package Repository;

import DomainEntity.Filme;
import Util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class FilmeRepository implements IGenericRepository<Filme> {

    @Override
    public void Insert(Filme entity) {
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
    public void Update(Filme entity) {
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
    public void Delete(Filme entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
        em.close();
    }

    public Filme obter(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Filme filme = em.find(Filme.class, id);
        em.close();
        return (filme);
    }

    public List<Filme> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Filme> filmeList = em.createQuery("SELECT f FROM Filme f").getResultList();
        em.close();
        return (filmeList);
    }

    public Filme obter(String nome) {
        try {
            EntityManager em = JpaUtil.getEntityManager();
            Filme filme = (Filme) em.createNamedQuery("Filme.findByNome")
                    .setParameter("nome", nome)
                    .getSingleResult();
            em.close();
            return (filme);
        } catch (Exception ex) {
            return null;
        }
    }
}
