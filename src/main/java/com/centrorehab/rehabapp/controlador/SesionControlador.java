package com.centrorehab.rehabapp.controlador;

import com.centrorehab.rehabapp.dto.SesionDTO;
import com.centrorehab.rehabapp.modelo.Sesion;
import com.centrorehab.rehabapp.servicio.SesionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class SesionControlador {

    @Autowired
    private SesionServicio sesionServicio;

    @GetMapping("/pacientes/{pacienteId}/sesiones")
    public List<SesionDTO> listarSesionesPorPaciente(
            @PathVariable Long pacienteId
    ) {
        return sesionServicio.listarPorPaciente(pacienteId);
    }
}





