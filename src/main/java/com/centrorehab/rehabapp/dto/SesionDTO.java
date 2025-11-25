package com.centrorehab.rehabapp.dto;

public class SesionDTO {

    private Long id;
    private String fecha;
    private String hora;
    private String estado;
    private String notas;

    private String terapeutaNombre;
    private String tratamientoNombre;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }

    public String getTerapeutaNombre() { return terapeutaNombre; }
    public void setTerapeutaNombre(String terapeutaNombre) { this.terapeutaNombre = terapeutaNombre; }

    public String getTratamientoNombre() { return tratamientoNombre; }
    public void setTratamientoNombre(String tratamientoNombre) { this.tratamientoNombre = tratamientoNombre; }
}




