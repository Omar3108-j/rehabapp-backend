package com.centrorehab.rehabapp.controlador;

import com.centrorehab.rehabapp.modelo.Rol;
import com.centrorehab.rehabapp.modelo.Usuario;
import com.centrorehab.rehabapp.repositorio.RolRepository;
import com.centrorehab.rehabapp.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Listar todos
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Crear usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Map<String, Object> datos) {

        Usuario usuario = new Usuario();
        usuario.setUsername((String) datos.get("username"));
        usuario.setPassword(passwordEncoder.encode((String) datos.get("password")));
        usuario.setEnabled(true);

        // roles: ["ADMIN"] o ["USER"]
        List<String> rolesRecibidos = (List<String>) datos.get("roles");
        Set<Rol> roles = new HashSet<>();

        for (String r : rolesRecibidos) {
            Rol rol = rolRepository.findByNombre(r)
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + r));
            roles.add(rol);
        }

        usuario.setRoles(roles);

        return usuarioRepository.save(usuario);
    }

    // Editar usuario (excepto password)
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Map<String, Object> datos) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setUsername((String) datos.get("username"));

        // Roles
        List<String> rolesRecibidos = (List<String>) datos.get("roles");
        Set<Rol> roles = new HashSet<>();
        for (String r : rolesRecibidos) {
            Rol rol = rolRepository.findByNombre(r)
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + r));
            roles.add(rol);
        }
        usuario.setRoles(roles);

        return usuarioRepository.save(usuario);
    }

    // Cambiar contraseña
    @PutMapping("/{id}/password")
    public Usuario cambiarPassword(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String newPassword = body.get("password");
        usuario.setPassword(passwordEncoder.encode(newPassword));

        return usuarioRepository.save(usuario);
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
