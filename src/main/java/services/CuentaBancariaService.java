package services;

import modelo.CuentaBancaria;
import modelo.Usuario;
import repositories.CuentaBancariaRepository;

import java.util.List;

public class CuentaBancariaService {
    private CuentaBancariaRepository cuentaBancariaRepository;

    public CuentaBancariaService(CuentaBancariaRepository cuentaBancariaRepository) {
        this.cuentaBancariaRepository = cuentaBancariaRepository;
    }

    public void crearCuentaBancaria(String numeroCuentaBancaria, String nombreUsuario, String emailUsuario) {
        if (cuentaBancariaRepository.findByNumber(numeroCuentaBancaria).isPresent()) {
            throw new RuntimeException("Ya existe una cuenta con ese numero");
        }
        Usuario usuario = new Usuario(nombreUsuario, emailUsuario);
        CuentaBancaria cuentaBancaria = new CuentaBancaria(numeroCuentaBancaria, usuario);
        cuentaBancariaRepository.create(cuentaBancaria);
    }

    public List<CuentaBancaria> listarCuentasBancarias() {
        return cuentaBancariaRepository.findAll();
    }
}

