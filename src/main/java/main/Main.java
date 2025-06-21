package main;

import jakarta.persistence.*;
import modelo.Banco;
import modelo.Usuario;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Usuario usuario = new Usuario("Juan Pérez", "juan.perez@email.com");
            Banco banco = new Banco("Banco Nacional", usuario);

            em.persist(banco); // También persistirá el usuario por el CascadeType.ALL

            em.getTransaction().commit();

            System.out.println("Banco y usuario guardados correctamente.");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

