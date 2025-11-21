package com.centrorehab.rehabapp.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "terapeuta")
public class Terapeuta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private String especialidad;
    private String telefono;
    private String correo;
    private String turno;

    public Terapeuta() {}

    public Terapeuta(String nombre, String apellido, String dni,
                     String especialidad, String telefono,
                     String correo, String turno) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.correo = correo;
        this.turno = turno;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
}



