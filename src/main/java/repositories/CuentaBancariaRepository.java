package repositories;

import common.Tx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import modelo.CuentaBancaria;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CuentaBancariaRepository {
    private EntityManagerFactory emf;

    public CuentaBancariaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(CuentaBancaria cuentaBancaria) {
        new Tx(emf).inTx(em -> {
            em.persist(cuentaBancaria);
        });
    }

    public List<CuentaBancaria> findAll() {
        return new Tx(emf).inTx((Function<EntityManager, List<CuentaBancaria>>) em ->
                em.createNativeQuery("SELECT * FROM cuentas_bancarias", CuentaBancaria.class).getResultList());
    }

    public Optional<CuentaBancaria> findByNumber(String numeroCuentaBancaria) {
        return new Tx(emf).inTx((Function<EntityManager, Optional<CuentaBancaria>>) em -> em.createQuery("SELECT b FROM CuentaBancaria b WHERE b.numero = :numero", CuentaBancaria.class)
                .setParameter("numero", numeroCuentaBancaria)
                .getResultStream()
                .findFirst());
    }


}

