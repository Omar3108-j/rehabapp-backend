package com.centrorehab.rehabapp.controlador;

import com.centrorehab.rehabapp.modelo.Usuario;
import com.centrorehab.rehabapp.repositorio.UsuarioRepository;
import com.centrorehab.rehabapp.seguridad.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepo;

    public AuthController(AuthenticationManager authManager,
                          JwtService jwtService,
                          UsuarioRepository usuarioRepo) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.usuarioRepo = usuarioRepo;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {
        try {
            String username = body.get("username");
            String password = body.get("password");

            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            // Obtener roles del usuario
            Usuario usuario = usuarioRepo.findByUsername(username).get();
            List<String> roles = usuario.getRoles().stream()
                    .map(r -> r.getNombre())
                    .toList();

            // Generar token con roles
            String token = jwtService.generarToken(username, roles);

            return Map.of(
                    "token", token,
                    "roles", roles
            );

        } catch (BadCredentialsException e) {
            return Map.of(
                    "error", "Credenciales inválidas"
            );
        }
    }
}








