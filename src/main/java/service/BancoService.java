package service;


import dao.BancoDAO;
import modelo.Banco;
import modelo.Usuario;

import java.util.List;

public class BancoService {

    private BancoDAO bancoDAO = new BancoDAO();

    public void crearBancoConUsuario(String nombreBanco, String nombreUsuario, String emailUsuario) {
        Usuario usuario = new Usuario(nombreUsuario, emailUsuario);
        Banco banco = new Banco(nombreBanco, usuario);

        bancoDAO.guardarBanco(banco);
    }

    public List<Banco> listarTodos() {
        return bancoDAO.findAll();
    }
}

