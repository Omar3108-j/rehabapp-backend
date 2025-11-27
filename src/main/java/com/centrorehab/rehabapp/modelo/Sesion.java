package com.centrorehab.rehabapp.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "sesion")
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // RELACIÓN CORRECTA CON PACIENTE
    @ManyToOne
    @JsonIgnoreProperties({"sesiones"})
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    // RELACIÓN CORRECTA CON TERAPEUTA
    @ManyToOne
    @JsonIgnoreProperties({"sesiones"})
    @JoinColumn(name = "terapeuta_id", nullable = false)
    private Terapeuta terapeuta;

    // RELACIÓN CORRECTA CON TRATAMIENTO
    @ManyToOne
    @JsonIgnoreProperties({"sesiones"})
    @JoinColumn(name = "tratamiento_id", nullable = false)
    private Tratamiento tratamiento;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime hora;

    private String notas;

    private String estado;

    public Sesion() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Terapeuta getTerapeuta() { return terapeuta; }
    public void setTerapeuta(Terapeuta terapeuta) { this.terapeuta = terapeuta; }

    public Tratamiento getTratamiento() { return tratamiento; }
    public void setTratamiento(Tratamiento tratamiento) { this.tratamiento = tratamiento; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}






