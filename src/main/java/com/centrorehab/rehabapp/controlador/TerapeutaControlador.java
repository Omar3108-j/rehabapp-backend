package com.centrorehab.rehabapp.controlador;

import com.centrorehab.rehabapp.modelo.Terapeuta;
import com.centrorehab.rehabapp.servicio.TerapeutaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terapeutas")
@CrossOrigin(origins = "http://localhost:5173")
public class TerapeutaControlador {

    private final TerapeutaServicio terapeutaServicio;

    public TerapeutaControlador(TerapeutaServicio terapeutaServicio) {
        this.terapeutaServicio = terapeutaServicio;
    }

    @GetMapping
    public List<Terapeuta> listar() {
        return terapeutaServicio.listarTodos();
    }

    @PostMapping
    public Terapeuta guardar(@RequestBody Terapeuta terapeuta) {
        return terapeutaServicio.guardar(terapeuta);
    }

    @GetMapping("/{id}")
    public Terapeuta obtener(@PathVariable Long id) {
        return terapeutaServicio.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Terapeuta actualizar(@PathVariable Long id, @RequestBody Terapeuta terapeuta) {
        terapeuta.setId(id);
        return terapeutaServicio.guardar(terapeuta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        terapeutaServicio.eliminar(id);
    }
}




