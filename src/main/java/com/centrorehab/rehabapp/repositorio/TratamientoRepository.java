package com.centrorehab.rehabapp.repositorio;

import com.centrorehab.rehabapp.modelo.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
}


