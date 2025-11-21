package com.centrorehab.rehabapp.servicio;

import com.centrorehab.rehabapp.modelo.Sesion;
import com.centrorehab.rehabapp.repositorio.SesionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionServicio {

    private final SesionRepository sesionRepository;

    public SesionServicio(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    // 🔹 Listar todas las sesiones
    public List<Sesion> listarTodas() {
        return sesionRepository.findAll();
    }

    // 🔹 Listar sesiones por ID de paciente
    public List<Sesion> listarPorPaciente(Long pacienteId) {
        return sesionRepository.findByPacienteId(pacienteId);
    }

    // 🔹 Guardar sesión (crear o actualizar)
    public Sesion guardar(Sesion sesion) {
        return sesionRepository.save(sesion);
    }

    // 🔹 Obtener sesión por ID
    public Sesion obtenerPorId(Long id) {
        return sesionRepository.findById(id).orElse(null);
    }

    // 🔹 Eliminar sesión
    public void eliminar(Long id) {
        sesionRepository.deleteById(id);
    }
}


