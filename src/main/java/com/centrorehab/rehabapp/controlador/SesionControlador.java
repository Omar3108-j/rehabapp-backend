package com.centrorehab.rehabapp.controlador;

import com.centrorehab.rehabapp.dto.SesionDTO;
import com.centrorehab.rehabapp.modelo.Sesion;
import com.centrorehab.rehabapp.servicio.SesionServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sesiones")
@CrossOrigin(origins = "http://localhost:5173")
public class SesionControlador {

    private final SesionServicio sesionServicio;

    public SesionControlador(SesionServicio sesionServicio) {
        this.sesionServicio = sesionServicio;
    }

    // Listar sesiones de un paciente (DTO)
    @GetMapping("/paciente/{id}")
    public List<SesionDTO> listarSesionesPorPaciente(@PathVariable Long id) {
        return sesionServicio.listarPorPaciente(id);
    }

    // Obtener sesión por ID
    @GetMapping("/{id}")
    public Sesion obtenerPorId(@PathVariable Long id) {
        return sesionServicio.obtenerPorId(id);
    }

    // Crear
    @PostMapping
    public Sesion crear(@RequestBody Sesion sesion) {
        return sesionServicio.guardar(sesion);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Sesion actualizar(@PathVariable Long id, @RequestBody Sesion sesion) {
        sesion.setId(id);
        return sesionServicio.guardar(sesion);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        sesionServicio.eliminar(id);
    }
}



