package com.centrorehab.rehabapp.repositorio;

import com.centrorehab.rehabapp.modelo.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SesionRepository extends JpaRepository<Sesion, Long> {
    List<Sesion> findByPacienteId(Long pacienteId);
}







