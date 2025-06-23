package main;

import common.JPAUtil;
import jakarta.persistence.EntityManagerFactory;
import modelo.Banco;
import service.BancoService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory em = JPAUtil.getEntityManagerFactory();
        BancoService bancoService = new BancoService(em);

        // Crear un banco con un usuario
        // bancoService.crearBancoConUsuario("Banco Nacional", "Juan Pérez", "juan.perez@email.com");

        // Obtener todos los bancos
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Lista de bancos");
        List<Banco> bancos = bancoService.listarTodos();
        for (Banco banco : bancos) {
            System.out.println(banco);
        }
    }
}

