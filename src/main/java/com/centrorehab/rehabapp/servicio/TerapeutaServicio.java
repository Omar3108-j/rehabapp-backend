package com.centrorehab.rehabapp.servicio;

import com.centrorehab.rehabapp.modelo.Terapeuta;
import com.centrorehab.rehabapp.repositorio.TerapeutaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerapeutaServicio {

    private final TerapeutaRepository terapeutaRepository;

    public TerapeutaServicio(TerapeutaRepository terapeutaRepository) {
        this.terapeutaRepository = terapeutaRepository;
    }

    public List<Terapeuta> listarTodos() {
        return terapeutaRepository.findAll();
    }

    public Terapeuta guardar(Terapeuta terapeuta) {
        return terapeutaRepository.save(terapeuta);
    }

    public Terapeuta obtenerPorId(Long id) {
        return terapeutaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        terapeutaRepository.deleteById(id);
    }
}

