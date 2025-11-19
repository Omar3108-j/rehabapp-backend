package com.centrorehab.rehabapp.controlador;

import com.centrorehab.rehabapp.modelo.Tratamiento;
import com.centrorehab.rehabapp.repositorio.TratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tratamientos")
@CrossOrigin(origins = "http://localhost:5173")
public class TratamientoControlador {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    // 1. Listar todos
    @GetMapping
    public List<Tratamiento> listarTratamientos() {
        return tratamientoRepository.findAll();
    }

    // 2. Obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<Tratamiento> obtenerTratamientoPorId(@PathVariable Long id) {
        Optional<Tratamiento> tratamiento = tratamientoRepository.findById(id);
        return tratamiento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3. Crear
    @PostMapping
    public ResponseEntity<Tratamiento> crearTratamiento(@RequestBody Tratamiento tratamiento) {
        try {
            Tratamiento nuevo = tratamientoRepository.save(tratamiento);
            return ResponseEntity.ok(nuevo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // 4. Actualizar (usar los nombres reales de la entidad)
    @PutMapping("/{id}")
    public ResponseEntity<Tratamiento> actualizarTratamiento(
            @PathVariable Long id,
            @RequestBody Tratamiento tratamientoActualizado) {

        Optional<Tratamiento> opt = tratamientoRepository.findById(id);

        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Tratamiento tratamiento = opt.get();

        // Campos básicos (sobrescribimos si vienen)
        if (tratamientoActualizado.getNombre() != null) {
            tratamiento.setNombre(tratamientoActualizado.getNombre());
        }
        if (tratamientoActualizado.getDescripcion() != null) {
            tratamiento.setDescripcion(tratamientoActualizado.getDescripcion());
        }
        if (tratamientoActualizado.getTipo() != null) {
            tratamiento.setTipo(tratamientoActualizado.getTipo());
        }

        // duracion / precio (nombres que definiste en la entidad)
        if (tratamientoActualizado.getDuracion() != null) {
            tratamiento.setDuracion(tratamientoActualizado.getDuracion());
        }
        if (tratamientoActualizado.getPrecio() != null) {
            tratamiento.setPrecio(tratamientoActualizado.getPrecio());
        }

        // fechas y estado (si tu entidad las tiene)
        if (tratamientoActualizado.getFechaInicio() != null) {
            tratamiento.setFechaInicio(tratamientoActualizado.getFechaInicio());
        }
        if (tratamientoActualizado.getFechaFin() != null) {
            tratamiento.setFechaFin(tratamientoActualizado.getFechaFin());
        }
        if (tratamientoActualizado.getEstado() != null) {
            tratamiento.setEstado(tratamientoActualizado.getEstado());
        }

        Tratamiento guardado = tratamientoRepository.save(tratamiento);
        return ResponseEntity.ok(guardado);
    }

    // 5. Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTratamiento(@PathVariable Long id) {
        if (!tratamientoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tratamientoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}









