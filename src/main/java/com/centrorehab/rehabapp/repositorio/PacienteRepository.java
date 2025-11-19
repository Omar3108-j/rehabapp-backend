package com.centrorehab.rehabapp.repositorio;

import com.centrorehab.rehabapp.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Aquí puedes agregar consultas personalizadas si las necesitas
}



