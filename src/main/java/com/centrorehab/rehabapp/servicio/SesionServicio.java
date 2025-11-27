package com.centrorehab.rehabapp.servicio;

import com.centrorehab.rehabapp.dto.SesionDTO;
import com.centrorehab.rehabapp.modelo.Sesion;
import com.centrorehab.rehabapp.repositorio.SesionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SesionServicio {

    private final SesionRepository sesionRepository;

    public SesionServicio(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    // Listar TODAS las sesiones (no DTO)
    public List<Sesion> listarTodas() {
        return sesionRepository.findAll();
    }

    // Listar sesiones por paciente → Devuelve DTO
    public List<SesionDTO> listarPorPaciente(Long pacienteId) {

        return sesionRepository.findByPacienteIdOrderByFechaDescHoraDesc(pacienteId)
                .stream()
                .map(s -> {
                    SesionDTO dto = new SesionDTO();
                    dto.setId(s.getId());
                    dto.setFecha(s.getFecha().toString());
                    dto.setHora(s.getHora().toString());
                    dto.setEstado(s.getEstado());
                    dto.setNotas(s.getNotas());

                    // IDs de apoyo para editar sesión
                    if (s.getTerapeuta() != null) {
                        dto.setTerapeutaNombre(s.getTerapeuta().getNombre());
                        dto.setTerapeutaId(s.getTerapeuta().getId());
                    }

                    if (s.getTratamiento() != null) {
                        dto.setTratamientoNombre(s.getTratamiento().getNombre());
                        dto.setTratamientoId(s.getTratamiento().getId());
                    }

                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Guardar (crear o actualizar)
    public Sesion guardar(Sesion sesion) {
        return sesionRepository.save(sesion);
    }

    // Obtener por ID
    public Sesion obtenerPorId(Long id) {
        return sesionRepository.findById(id).orElse(null);
    }

    // Eliminar
    public void eliminar(Long id) {
        sesionRepository.deleteById(id);
    }
}





