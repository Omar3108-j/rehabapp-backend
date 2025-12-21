package com.centrorehab.rehabapp.controlador;

import com.centrorehab.rehabapp.modelo.Paciente;
import com.centrorehab.rehabapp.modelo.Tratamiento;
import com.centrorehab.rehabapp.repositorio.PacienteRepository;
import com.centrorehab.rehabapp.repositorio.TratamientoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "http://localhost:5173") // Ajusta si tu frontend usa otro puerto
public class PacienteControlador {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private TratamientoRepository tratamientoRepository;

    // Listar todos los pacientes
    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    // Obtener un paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPacientePorId(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensaje", "Paciente no encontrado"));
        }
        return ResponseEntity.ok(paciente.get());
    }

    // Agregar un nuevo paciente
    @PostMapping
    public ResponseEntity<Paciente> agregarPaciente(@RequestBody Paciente paciente) {
        Paciente nuevoPaciente = pacienteRepository.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPaciente);
    }

    // Actualizar un paciente existente
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPaciente(@PathVariable Long id, @RequestBody Paciente datos) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(id);
        if (pacienteOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensaje", "Paciente no encontrado"));
        }

        Paciente paciente = pacienteOpt.get();

        paciente.setNombre(datos.getNombre());
        paciente.setApellido(datos.getApellido());
        paciente.setCorreo(datos.getCorreo());
        paciente.setDireccion(datos.getDireccion());
        paciente.setDni(datos.getDni());
        paciente.setTelefono(datos.getTelefono());
        paciente.setEdad(datos.getEdad());
        paciente.setFechaNacimiento(datos.getFechaNacimiento());

        Paciente actualizado = pacienteRepository.save(paciente);

        return ResponseEntity.ok(actualizado);
    }


    // Eliminar un paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(id);
        if (pacienteOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensaje", "Paciente no encontrado"));
        }

        pacienteRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("mensaje", "Paciente eliminado correctamente"));
    }

    // Asignar un tratamiento a un paciente
    @PostMapping("/{id}/tratamientos")
    public ResponseEntity<?> asignarTratamiento(@PathVariable Long id, @RequestBody Map<String, Long> body) {
        Long tratamientoId = body.get("tratamientoId");

        Optional<Paciente> pacienteOpt = pacienteRepository.findById(id);
        Optional<Tratamiento> tratamientoOpt = tratamientoRepository.findById(tratamientoId);

        if (pacienteOpt.isEmpty() || tratamientoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensaje", "Paciente o tratamiento no encontrado"));
        }

        Paciente paciente = pacienteOpt.get();
        Tratamiento tratamiento = tratamientoOpt.get();

        paciente.getTratamientos().add(tratamiento);
        pacienteRepository.save(paciente);

        return ResponseEntity.ok(Map.of("mensaje", "Tratamiento asignado correctamente"));
    }

    // Listar tratamientos asignados a un paciente
    @GetMapping("/{id}/tratamientos")
    public ResponseEntity<?> listarTratamientosDePaciente(@PathVariable Long id) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(id);
        if (pacienteOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensaje", "Paciente no encontrado"));
        }

        Paciente paciente = pacienteOpt.get();
        return ResponseEntity.ok(paciente.getTratamientos());
    }
}






