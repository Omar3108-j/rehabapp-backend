package com.centrorehab.rehabapp.repositorio;

import com.centrorehab.rehabapp.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
}


