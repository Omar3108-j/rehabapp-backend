package com.centrorehab.rehabapp.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tratamiento")
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private String tipo;

    // Nueva propiedad: duración del tratamiento (por ejemplo: "3 meses", "10 sesiones", etc.)
    private String duracion;

    // Nueva propiedad: precio del tratamiento (puedes usar Double o BigDecimal)
    private Double precio;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private String estado;

    // 🔹 Constructores
    public Tratamiento() {
    }

    public Tratamiento(String nombre, String descripcion, String tipo, String duracion,
                       Double precio, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.duracion = duracion;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    // 🔹 Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}








