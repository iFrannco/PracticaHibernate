package modelo;

import jakarta.persistence.EntityManagerFactory;
import repositories.CuentaBancariaRepository;
import repositories.UsuarioRepository;
import services.CuentaBancariaService;
import services.UsuarioService;

import java.util.List;

public class Api {
    private CuentaBancariaService cuentaBancariaService;
    private UsuarioService usuarioService;

    public Api(EntityManagerFactory em) {
        CuentaBancariaRepository cuentaBancariaRepository = new CuentaBancariaRepository(em);
        UsuarioRepository usuarioRepository = new UsuarioRepository(em);

        this.usuarioService = new UsuarioService(usuarioRepository);
        this.cuentaBancariaService = new CuentaBancariaService(cuentaBancariaRepository);
    }

    public List<CuentaBancaria> listarCuentasBancarias() {
        return cuentaBancariaService.listarCuentasBancarias();
    }

    public void crearCuentaBancaria(String numeroCuentaBancaria, String nombreUsuario, String emailUsuario) {
        cuentaBancariaService.crearCuentaBancaria(numeroCuentaBancaria, nombreUsuario, emailUsuario);
    }

    public void crearUsuario(String nombreUsuario, String emailUsuario) {
        usuarioService.crearUsuario(nombreUsuario, emailUsuario);
    }
}
