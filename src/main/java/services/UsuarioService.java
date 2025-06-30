package services;

import modelo.Usuario;
import repositories.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void crearUsuario(String nombreUsuario, String emailUsuario) {
        if (usuarioRepository.findByName(nombreUsuario).isPresent()) {
            throw new RuntimeException("Ya existe un usuario con ese nombre");
        }
        Usuario nuevoUsuario = new Usuario(nombreUsuario, emailUsuario);
        usuarioRepository.create(nuevoUsuario);
    }
}
