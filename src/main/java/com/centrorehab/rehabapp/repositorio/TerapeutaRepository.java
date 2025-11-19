package com.centrorehab.rehabapp.repositorio;

import com.centrorehab.rehabapp.modelo.Terapeuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerapeutaRepository extends JpaRepository<Terapeuta, Long> {
}


