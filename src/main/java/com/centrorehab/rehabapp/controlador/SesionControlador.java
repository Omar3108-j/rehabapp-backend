package com.centrorehab.rehabapp.controlador;

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

    @GetMapping
    public List<Sesion> listar() {
        return sesionServicio.listarTodas();
    }

    @GetMapping("/paciente/{id}")
    public List<Sesion> listarPorPaciente(@PathVariable Long id) {
        return sesionServicio.listarPorPaciente(id);
    }

    @GetMapping("/{id}")
    public Sesion obtener(@PathVariable Long id) {
        return sesionServicio.obtenerPorId(id);
    }

    @PostMapping
    public Sesion guardar(@RequestBody Sesion sesion) {
        return sesionServicio.guardar(sesion);
    }

    @PutMapping("/{id}")
    public Sesion actualizar(@PathVariable Long id, @RequestBody Sesion sesion) {
        sesion.setId(id);
        return sesionServicio.guardar(sesion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        sesionServicio.eliminar(id);
    }
}

