package com.centrorehab.rehabapp.servicio;

import com.centrorehab.rehabapp.dto.SesionDTO;
import com.centrorehab.rehabapp.modelo.Sesion;
import com.centrorehab.rehabapp.repositorio.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SesionServicio {

    @Autowired
    private SesionRepository sesionRepository;

    public List<SesionDTO> listarPorPaciente(Long pacienteId) {
        return sesionRepository.findByPacienteId(pacienteId)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    private SesionDTO convertirADTO(Sesion s) {
        SesionDTO dto = new SesionDTO();
        dto.setId(s.getId());
        dto.setFecha(s.getFecha().toString());
        dto.setHora(s.getHora().toString());
        dto.setEstado(s.getEstado());
        dto.setNotas(s.getNotas());
        dto.setTerapeutaNombre(s.getTerapeuta().getNombre());
        dto.setTratamientoNombre(s.getTratamiento().getNombre());
        return dto;
    }
}









