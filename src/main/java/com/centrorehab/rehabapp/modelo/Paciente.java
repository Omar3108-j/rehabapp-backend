package com.centrorehab.rehabapp.modelo;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String dni;
    private String direccion;
    private String telefono;

    @ManyToMany
    @JoinTable(
            name = "paciente_tratamiento",
            joinColumns = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "tratamiento_id")
    )
    private Set<Tratamiento> tratamientos = new HashSet<>();

    public Paciente() {}

    public Paciente(String nombre, String dni, String direccion, String telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Set<Tratamiento> getTratamientos() { return tratamientos; }
    public void setTratamientos(Set<Tratamiento> tratamientos) { this.tratamientos = tratamientos; }
}

