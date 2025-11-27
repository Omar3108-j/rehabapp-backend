package com.centrorehab.rehabapp.seguridad;

import com.centrorehab.rehabapp.modelo.Usuario;
import com.centrorehab.rehabapp.repositorio.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetallesService implements UserDetailsService {

    private final UsuarioRepository usuarioRepo;

    public UsuarioDetallesService(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new UsuarioDetalles(usuario);
    }
}



