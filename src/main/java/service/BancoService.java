package service;

import common.Tx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import modelo.Banco;
import modelo.Usuario;

import java.util.List;
import java.util.function.Function;

public class BancoService {
    private EntityManagerFactory emf;

    public BancoService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void crearBancoConUsuario(String nombreBanco, String nombreUsuario, String emailUsuario) {
        new Tx(emf).inTx(em -> {
            Usuario usuario = new Usuario(nombreUsuario, emailUsuario);
            Banco banco = new Banco(nombreBanco, usuario);
            em.persist(banco);
        });
    }

    public List<Banco> listarTodos() {
        Function<EntityManager, List<Banco>> consulta = em ->
                em.createNativeQuery("SELECT * FROM bancos", Banco.class).getResultList();

        return new Tx(emf).inTx(consulta);
    }
}

