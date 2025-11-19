package com.centrorehab.rehabapp.controlador;

import com.centrorehab.rehabapp.modelo.Terapeuta;
import com.centrorehab.rehabapp.repositorio.TerapeutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terapeutas")
public class TerapeutaControlador {

    @Autowired
    private TerapeutaRepository terapeutaRepository;

    @GetMapping
    public List<Terapeuta> listarTerapeutas() {
        return terapeutaRepository.findAll();
    }

    @PostMapping
    public Terapeuta guardarTerapeuta(@RequestBody Terapeuta terapeuta) {
        return terapeutaRepository.save(terapeuta);
    }

    @PutMapping("/{id}")
    public Terapeuta actualizarTerapeuta(@PathVariable Long id, @RequestBody Terapeuta terapeutaActualizado) {
        Terapeuta terapeuta = terapeutaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        terapeuta.setNombre(terapeutaActualizado.getNombre());
        terapeuta.setEspecialidad(terapeutaActualizado.getEspecialidad());
        terapeuta.setTelefono(terapeutaActualizado.getTelefono());
        return terapeutaRepository.save(terapeuta);
    }

    @DeleteMapping("/{id}")
    public void eliminarTerapeuta(@PathVariable Long id) {
        terapeutaRepository.deleteById(id);
    }
}



