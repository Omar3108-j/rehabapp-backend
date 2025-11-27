package com.centrorehab.rehabapp.repositorio;

import com.centrorehab.rehabapp.modelo.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SesionRepository extends JpaRepository<Sesion, Long> {

    // Sesiones por paciente
    List<Sesion> findByPacienteId(Long pacienteId);

    // OPCIONAL: Sesiones ordenadas por fecha y hora (recomendado)
    List<Sesion> findByPacienteIdOrderByFechaDescHoraDesc(Long pacienteId);
}





