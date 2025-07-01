package main;

import common.JPAUtil;
import jakarta.persistence.EntityManagerFactory;
import modelo.Api;
import modelo.CuentaBancaria;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory em = JPAUtil.getEntityManagerFactory();
        Api api = new Api(em);

        // Crear una cuenta bancaria
        api.crearCuentaBancaria("33333333", "Gustavo", "gus123@email.com");

        // Obtener todas las cuentas bancarias
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Lista de Cuentas Bancarias");
        List<CuentaBancaria> cuentaBancarias = api.listarCuentasBancarias();
        for (CuentaBancaria cuentaBancaria : cuentaBancarias) {
            System.out.println(cuentaBancaria);
        }
    }
}

