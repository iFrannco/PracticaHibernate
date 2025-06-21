package dao;

import common.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import modelo.Banco;

import java.util.ArrayList;
import java.util.List;

public class BancoDAO {

    public void guardarBanco(Banco banco) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(banco);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Banco> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        List<Banco> bancos = new ArrayList<>();

        try {
            bancos = em.createNativeQuery("SELECT * FROM bancos", Banco.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return bancos;
    }

}
