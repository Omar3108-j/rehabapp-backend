package com.centrorehab.rehabapp.servicio;

import com.centrorehab.rehabapp.modelo.Tratamiento;
import com.centrorehab.rehabapp.repositorio.TratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TratamientoServicio {

    @Autowired
    private TratamientoRepository tratamientoRepositorio;

    // 🔹 Listar todos los tratamientos
    public List<Tratamiento> listarTratamientos() {
        return tratamientoRepositorio.findAll();
    }

    // 🔹 Guardar o actualizar tratamiento
    public Tratamiento guardarTratamiento(Tratamiento tratamiento) {
        return tratamientoRepositorio.save(tratamiento);
    }

    // 🔹 Buscar tratamiento por ID
    public Tratamiento obtenerPorId(Long id) {
        return tratamientoRepositorio.findById(id).orElse(null);
    }

    // 🔹 Eliminar tratamiento
    public void eliminarTratamiento(Long id) {
        tratamientoRepositorio.deleteById(id);
    }
}
