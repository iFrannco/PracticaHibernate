package repositories;

import common.Tx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import modelo.Usuario;

import java.util.Optional;
import java.util.function.Function;

public class UsuarioRepository {
    private EntityManagerFactory emf;

    public UsuarioRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Optional<Object> findByName(String nombreUsuario) {
        return Optional.ofNullable(new Tx(emf).inTx((Function<EntityManager, Object>) em ->
                em.createQuery("SELECT b FROM usuarios b WHERE b.nombre = :nombre", Usuario.class)
                        .setParameter("nombre", nombreUsuario)
                        .getResultStream()
                        .findFirst()));
    }

    public void create(Usuario nuevoUsuario) {
        new Tx(emf).inTx(em -> {
            em.persist(nuevoUsuario);
        });
    }
}
